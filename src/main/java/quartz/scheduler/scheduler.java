package quartz.scheduler;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import quartz.job.toFile;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class scheduler {

    public static void main(String[] args) throws InterruptedException {

    Start();

    }

    public static void Start()
    {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our SimpleJob class
            JobDetail job = newJob(toFile.class)
                    .withIdentity("job1", "group1")
                    .build();
            //  ToFile.setTextToFile(add_people.getS());

            // Trigger the job to run now, and then repeat every 1 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(cronSchedule("0/30 * * * * ?"))
                    .build();


            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

            // and start it off
            scheduler.start();


        } catch (SchedulerException se) {
            se.printStackTrace();
        }

    }



    public static void Study()
    {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our SimpleJob class
            JobDetail job = newJob(Study.class)
                    .withIdentity("job1", "group1")
                    .build();
            //  ToFile.setTextToFile(add_people.getS());

            // Trigger the job to run now, and then repeat every 1 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(cronSchedule("0 15 8 ? * MON"))
                    .build();




            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

            // and start it off
            scheduler.start();


        } catch (SchedulerException se) {
            se.printStackTrace();
        }

    }
}
