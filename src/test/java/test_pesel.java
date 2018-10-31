

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class test_pesel {

    CheckPesel pesel;
    final static Logger logger = Logger.getLogger(CheckPesel.class);

    @Before
    public void setUp(){
        logger.info("SetUp start");
       pesel = new CheckPesel();
    }

    @Test
    public void goodPesel()
    {
       String p1 = "98030408259";
       System.out.println( pesel.isPeselGood(p1));
             //   asserttrue!!
    }
    @Test
    public void goodyPesel()
    {
        String p1 = "981";
        System.out.println( pesel.isPeselGood(p1));
    }
    @Test
    public void goodxPesel()
    {
        String p1 = "9892XXaLSXLDLDLDL";
        System.out.println( pesel.isPeselGood(p1));
    }
}
