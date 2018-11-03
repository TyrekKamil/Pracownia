package quartz.job;

import org.quartz.JobExecutionContext;
import projekt.add_people;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Simplest job is a class that implements Job interface (execute method)
public class toFile implements org.quartz.Job {

    private int i = 0;


    public void setTextToFile(String textToFile) {
        this.textToFile = textToFile;
    }

    public String textToFile;

    public void execute(JobExecutionContext jobExecutionContext) {

        String a = add_people.getX();
        try {
            toFile(a);
            System.out.println("Wykonano zapis do pliku listOfPeople.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("nie wyslzo");
        }



    }


    public static void toFile( String t ) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("listOfPeople.txt"));
        writer.write(t);
        writer.close();
        String input;
        FileReader fileReader = new FileReader("listOfPeople.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String inputLine;
        List<String> lineList = new ArrayList<String>();
        while ((inputLine = bufferedReader.readLine()) != null) {
            lineList.add(inputLine);
        }
        fileReader.close();

        Collections.sort(lineList);

        FileWriter fileWriter = new FileWriter("listOfPeople.txt");
        PrintWriter out = new PrintWriter(fileWriter);
        for (String outputLine : lineList) {
            out.println(outputLine);
        }
        out.flush();
        out.close();
        fileWriter.close();




    }
}
