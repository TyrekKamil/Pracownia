package quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Simplest job is a class that implements Job interface (execute method)
public class toFile implements org.quartz.Job {

    private int i = 0;

    public void execute(JobExecutionContext jobExecutionContext) {



        System.out.println("Executing like there is no tomorrow " + i);

        i++;

        System.out.println(jobExecutionContext.getFireTime());



    }

    public static void toFile( String t ) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("tekst.txt"));

        writer.write(t);

        writer.close();
    }
}
