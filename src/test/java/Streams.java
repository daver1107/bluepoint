import logic.SetUp;
import logic.StreamChecker;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.Login;

public class Streams extends SetUp {

    @Test
    public void streamTest(){
       StreamChecker.streamCheck();
    }


}
