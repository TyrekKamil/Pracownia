import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class toXFile
{


public static void toFile( String t ) throws IOException
        {
        BufferedWriter writer = new BufferedWriter(new FileWriter("tekst.txt"));

        writer.write(t);

        writer.close();
        }
}