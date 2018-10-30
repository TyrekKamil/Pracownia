import java.lang.reflect.Array;
import java.util.*;

public class add_people {

    public static void main(String[] args)

    {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        ArrayList<String> Person = new ArrayList<String>();
        HashMap<String, ArrayList<String> > people;
        people = new HashMap<>();

        while(true)
        {

            System.out.println("Wpisz miasto:");
            String city = reader.nextLine();
            String other = reader.nextLine();
            String[] sp = other.split(" ");

            if(sp[0] != null && sp[1] != null && sp[2]!= null)
            {
                String pesel = sp[2];
                System.out.println(isPeselGood(pesel));
                Person.add(other);
                people.put(city,Person);
              //  System.out.println(Arrays.asList(people));
                System.out.println(Arrays.asList(Person));
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


}
