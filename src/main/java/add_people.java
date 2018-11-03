
package projekt;

import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import quartz.scheduler.scheduler;
import quartz.scheduler.scheduler_study;

import java.util.Scanner;

public class add_people {


    public static String getX() {
        return x;
    }

    public static String x = "";



    public static void main(String[] args) {
        Start();
    }

    public static void Start() {
        FastListMultimap<String,FastListMultimap> listOfPeople = FastListMultimap.newMultimap();
        FastListMultimap<String, String> listOfPeoplePesel = FastListMultimap.newMultimap();
        Scanner reader = new Scanner(System.in);
        String s = "";
        String other;
        String city[] = new String[250];

        int i=0;
        while (true) {

            System.out.println("Wpisz miasto:");
            city[i] = reader.nextLine();
            city[i] = city[i].substring(0,1).toUpperCase() + city[i].substring(1);
            other = reader.nextLine();
            String[] sp = other.split(" ");

            if (/*CheckPesel.isPeselGood(sp[2])*/true) {

                //listOfPeoplePesel = renamePerson(listOfPeoplePesel, listOfPeople, sp[2], sp[0]+ " " + sp[1]);

                //listOfPeople = renameMan(listOfPeople, listOfPeoplePesel, i, city, sp[0]+ " " + sp[1],sp[2]);


                listOfPeoplePesel.put(sp[2], sp[0] + " " + sp[1]);
                listOfPeople.put(city[i], new_person( sp[2], sp[0] + " " + sp[1] ) );
                listOfPeople = ifPeselRepeat( (sp[2]),listOfPeoplePesel, listOfPeople,city,i);
                s = listOfPeople.keyValuePairsView().toString();

                s = deleteSign(s);
                x=s;

                System.out.println(s);
                i++;

            } else {
                System.out.println("Podano zły pesel. Proszę spróbować jeszcze raz.");
            }


        }


    }

    public static String deleteSign(String x) {
        x = x.replace(":", " ");
        x = x.replace("[", "");
        x = x.replace("]", "");
        x = x.replace(", ", "\n");
        x = x.replace ("{","");
        x = x.replace ("}","");
        x = x.replace ("="," ");
        return x;

    }

    public static FastListMultimap renamePerson(FastListMultimap a, FastListMultimap b, String p, String o)
    {
        a.removeAll(p);
        a.put(p, o);
        return a;
    }
    public static FastListMultimap renameMan(FastListMultimap a, FastListMultimap b, int j, String c[], String o, String p)
    {

        for(int k = 0; k<j+1;k++)
        {
            if(a.containsKey(b))
            {
                a.remove(c[j], b);
            }

        }

        return a;
    }

    public static FastListMultimap new_person(String key, String o) {
        FastListMultimap<String, String> x = FastListMultimap.newMultimap();
        x.put(key,o);
        return x;

    }

    public static FastListMultimap ifPeselRepeat(String p, FastListMultimap ap, FastListMultimap a, String[] c, int j)
    {
        int i = 0;
        int result = 0;
        while(i<j)
        {
            String x = a.get(c[i]).toString();
            x = deleteSign(x);
            if(x.contains(p) && x.contains(c[i]) == false)
            {
                result++;
            }
            i++;
        }
        return a;
    }

    /*public static FastListMultimap deleteRepeat(FastListMultimap a, FastListMultimap ap, String p)
    {
        if(ifPeselRepeat(p) == false )
            return a;
        else
        {
            a.
        }
    }*/






}


