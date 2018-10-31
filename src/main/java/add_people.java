import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class add_people {

    public static void main(String[] args)
    {
        Start();
    }

public static void Start()
{

    FastListMultimap<String, String> ListofPeople = FastListMultimap.newMultimap();
    Scanner reader = new Scanner(System.in);
    String pesel, city, other;
    String outText;
    while (true) {

        System.out.println("Wpisz miasto:");
        city = reader.nextLine();
        other = reader.nextLine();
        String[] sp = other.split(" ");


        if (sp[0] != null && sp[1] != null && sp[2] != null && city != null) {
            pesel = sp[2];
            System.out.println(CheckPesel.isPeselGood(pesel));
            ListofPeople.put(city, other);

            /* DUPA BLADA */


        } else {
            System.out.println("Nie podano wszystkich danych. Wprowadz ponownie miasto, a następnie imię, nazwisko, pesel");
        }


    }


}

}

   /* public static void toFile( RichIterable<String> t )
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("tekst.txt"));

        writer.write(t);

        writer.close();
    }
*/

