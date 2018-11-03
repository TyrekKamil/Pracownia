import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import quartz.job.Study;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.quartz.DateBuilder.dateOf;
import static org.testng.Assert.assertTrue;

public class testStudy  {

    Study study;
    final static Logger logger = Logger.getLogger(Study.class);

    @Before
    public void setUp(){
        logger.info("SetUp start");
        study = new Study();
    }

    @Test
    public void lesson()
    {
        Date x = dateOf(8,20,00);
        assertFalse(study.breakOrLesson(x));
        //   asserttrue!!
    }
    @Test
    public void endDay()
    {
        Date x = dateOf(0,20,53);
        assertTrue(study.breakOrLesson(x));
    }
    @Test
    public void breakTime()
    {
        Date x = dateOf(9,47,32);
        assertTrue(study.breakOrLesson(x));
    }
}
