import quartz.scheduler.scheduler;
import quartz.scheduler.scheduler_study;
import projekt.add_people;

public class Main {
    public static void main(String[] args)
    {
        add_people add = new add_people();
        scheduler Scheduler = new scheduler();
        Scheduler.Start();
        scheduler_study x = new scheduler_study();
        scheduler_study.Start();
        add_people.Start();
    }
}
