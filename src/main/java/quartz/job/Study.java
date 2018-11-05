package quartz.job;

import org.quartz.*;

import java.util.Date;

import static org.quartz.DateBuilder.dateOf;

@PersistJobDataAfterExecution
public class Study  implements org.quartz.Job{

    public void execute(JobExecutionContext context) throws JobExecutionException {
        {
            Date x = new Date();
            long end = x.getTime();
            Date current = new Date();
            long cur = current.getTime();
            long timeToEnd =  minToEnd(x);
            whatTime(x,timeToEnd);
        }
    }

    public static Boolean breakOrLesson(Date x)
    {
        if((x.after(dateOf(00,00,00)) && x.before(dateOf(8,15,00)))
        || (x.after(dateOf(9,45,00)) && x.before(dateOf(10,00,00)))
        || (x.after(dateOf(11,30,00)) && x.before(dateOf(11,45,00)))
        || (x.after(dateOf(13,15,00)) && x.before(dateOf(13,45,00)))
        || (x.after(dateOf(15,15,00)) && x.before(dateOf(15,30,00)))
        || (x.after(dateOf(17,00,00)) && x.before(dateOf(17,15,00)))
        || (x.after(dateOf(18,45,00)) && x.before(dateOf(23,59,59))))
            return true;
        else
            return false;
    }

    public static Long minToEnd(Date x)
    {
        long current, end;
        end = 0;
        current = x.getTime();
        if(breakOrLesson(x))
        {
            if( (x.after(dateOf(18,45,00))) && x.before(dateOf(23,59,59))
                    || (x.after(dateOf(00,00,00))) && x.before(dateOf(8,15,00)))
            {
                if(x.after(dateOf(0,0,0)) && x.before(dateOf(8,15,00)))
                {
                    Date y = (Date) dateOf(8,15,00);
                    end = y.getTime();
                    return (1+(end-current)/60000);
                }
                else
                {
                    Date y = (Date) dateOf(23,59,59);
                    end = y.getTime() + 495*60000;
                    return (1+(end-current)/60000);
                }

            }

            if( (x.after(dateOf(17,00,00))) && x.before(dateOf(17,15,00)) )
            {

                Date y = (Date) dateOf(17,15,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }

            if( (x.after(dateOf(15,30,00))) && x.before(dateOf(15,45,00)) )
            {

                Date y = (Date) dateOf(15,45,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }

            if( (x.after(dateOf(13,15,00))) && x.before(dateOf(13,45,00)) )
            {

                Date y = (Date) dateOf(13,45,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }

            if( (x.after(dateOf(11,30,00))) && x.before(dateOf(11,45,00)) )
            {

                Date y = (Date) dateOf(11,45,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }

            if( (x.after(dateOf(9,45,00))) && x.before(dateOf(10,00,00)) )
            {

                Date y = (Date) dateOf(10,00,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }


            else
                return end;
        }
        else
        {
            if( (x.after(dateOf(8,15,00))) && x.before(dateOf(9,45,00)) )
            {

                Date y = (Date) dateOf(9,45,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }
            if( (x.after(dateOf(10,00,00))) && x.before(dateOf(11,30,0)) )
            {

                Date y = (Date) dateOf(11,30,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }
            if( (x.after(dateOf(11,45,00))) && x.before(dateOf(13,15,00)) )
            {

                Date y = (Date) dateOf(13,15,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }
            if( (x.after(dateOf(13,45,00))) && x.before(dateOf(15,15,00)) )
            {

                Date y = (Date) dateOf(15,15,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }
            if( (x.after(dateOf(15,30,00))) && x.before(dateOf(17,00,00)) )
            {

                Date y = (Date) dateOf(17,00,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }
            if( (x.after(dateOf(17,15,00))) && x.before(dateOf(18,45,00)) )
            {

                Date y = (Date) dateOf(9,45,00);
                end = y.getTime();
                return (1+(end-current)/60000);
            }

        }
    return end;
    }

    public static void whatTime(Date y, long timeToEnd)
    {
        if(breakOrLesson(y))
        {
            if(timeToEnd<30)
                System.err.println("Trwa przerwa. Do końca pozostało " + timeToEnd + " minut");
            if(timeToEnd>=30)
            {
                int hours;
                int minutes;
                hours = (int) timeToEnd/60;
                minutes = (int) timeToEnd%60;
                System.err.println("Koniec zajęć na dziś. Następne zajęcia odbędą się za: " + hours + " godzin "+ minutes + " minut");

            }
        }
        else
        {
            if(timeToEnd<60)
                System.err.println("Trwają zajęcia. Do końca pozostało " + timeToEnd + " minut");
            if(timeToEnd>=60)
            {
                int hours;
                int minutes;
                hours = (int) timeToEnd/60;
                minutes = (int) timeToEnd%60;
                System.err.println("Trwają zajęcia. Do końca pozostało " + hours + " godzin "+ minutes + " minut");

            }
        }
    }
}