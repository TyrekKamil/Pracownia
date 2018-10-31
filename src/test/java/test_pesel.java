

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.testng.Assert.assertTrue;

public class test_pesel  {

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
       assertTrue(( pesel.isPeselGood(p1)));
             //   asserttrue!!
    }
    @Test
    public void tooShortPesel()
    {
        String p1 = "981";
        assertFalse(( pesel.isPeselGood(p1)));
    }
    @Test
    public void LetterInPesel()
    {
        String p1 = "9892X15151";
        assertFalse(( pesel.isPeselGood(p1)));
    }
}
