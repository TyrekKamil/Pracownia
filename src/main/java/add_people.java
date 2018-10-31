

import org.eclipse.collections.impl.multimap.list.FastListMultimap;

import java.io.IOException;
import java.util.Scanner;

public class add_people {

    public static void main(String[] args)
    {
        Start();
    }

public static void Start()
{

    FastListMultimap<String, String> listOfPeople = FastListMultimap.newMultimap();
    Scanner reader = new Scanner(System.in);
    String pesel, city, other;
    while (true) {

        System.out.println("Wpisz miasto:");
        city = reader.nextLine();
        other = reader.nextLine();
        String[] sp = other.split(" ");
        String s = " ";

        if (sp[0] != null && sp[1] != null && sp[2] != null && city != null) {

            pesel = sp[2];

           if( s.contains(pesel))
            {
                System.out.println(true);
            }
            else
            System.out.println(false);


            listOfPeople.put(city, other);
            s = listOfPeople.keyValuePairsView().toString();


            //s = deleteSign(s);

            System.out.println(s);

            try
            {
                toXFile.toFile(s);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }



        } else {
            System.out.println("Nie podano wszystkich danych. Wprowadz ponownie miasto, a następnie imię, nazwisko, pesel");
        }


    }


}

    public static String deleteSign(String x)
    {
        x=x.replace(":"," ");
        x=x.replace("[","");
        x=x.replace("]","");
        x=x.replace(", ","\n");
        return x;

    }

    public static String renamePerson(String a, String p)
    {
        if( a.indexOf(p) != -1  )
        {
            return "jest";
        }
        else return "nie ma";
    }


}




