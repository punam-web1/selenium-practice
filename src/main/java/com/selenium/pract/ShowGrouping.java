package sequencing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShowGrouping {
 
	   @Test(groups = { "sanitytest", "fullregressiontest" })
	   public void testforboth() {
	      System.out.println("Inside testforboth()");
	      //Assert.assertEquals("successful execution", "successful");
	      //Assert.assertTrue(false, "successful execution false");
	   }

	   @Test(groups = { "sanitytest"})
	   public void testonlyforsanity() {
	      System.out.println("Inside testonlyforsanity()");
	   }

	   @Test(groups = { "fullregressiontest" })
	   public void testonlyforfullregression() {
	      System.out.println("Inside testonlyforfullregression()");
	   }
	   
}
