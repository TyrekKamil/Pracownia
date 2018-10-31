import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class add_people {

    public static void main(String[] args)

    {
        FastListMultimap<String, String> ListofPeople = FastListMultimap.newMultimap();
        Scanner reader = new Scanner(System.in);
        String pesel, city,other;
        String outText;
        while(true)
        {

            System.out.println("Wpisz miasto:");
            city = reader.nextLine();
            other = reader.nextLine();
            String[] sp = other.split(" ");


            if(sp[0] != null && sp[1] != null && sp[2]!= null && city != null)
            {
                pesel = sp[2];
                System.out.println(isPeselGood(pesel));
                ListofPeople.put(city,other);

      /* DUPA BLADA */



            }

            else
            {
                System.out.println("Nie podano wszystkich danych. Wprowadz ponownie miasto, a następnie imię, nazwisko, pesel");
            }


        }




    }

    public static Boolean isPeselGood(String p)
    {
        if(p.length()==11 && checkPesel(p)==true) return true;
        else
        {
             return false;
        }
    }

    public static Boolean checkPesel(String p)
    {
    long psl = Long.parseLong(p);
    long psl_id[] = new long[11];
    int i=9;
    psl_id[10]=psl%10;
    psl=psl/10;

    while(i>=0)
    {
    psl_id[i]=psl%10;
    psl=psl/10;
    i--;
    }

    float sum=psl_id[0]+3*psl_id[1]+7*psl_id[2]+9*psl_id[3]+psl_id[4]+3*psl_id[5]+7*psl_id[6]+9*psl_id[7]+psl_id[8]+3*psl_id[9];
    sum %= 10;
    sum = 10 - sum;
    sum %= 10;
    System.out.println(sum);
    System.out.println(psl_id[10]);

    if(sum==psl_id[10])
        return true;
    else
        return false;
    }

    public static void toFile( RichIterable<String> t )
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("tekst.txt"));

        writer.write(t);

        writer.close();
    }

}
