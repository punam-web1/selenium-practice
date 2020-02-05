package sequencing;

import org.testng.annotations.Test;

public class TestSequence {
	
  @Test(priority=5)
  public void first() {
	  System.out.println("INSIDE Method No. ONE");
  }
  
  @Test(priority=0)
  public void second() {
	  System.out.println("INSIDE Method No. TWO");
  }
  
  @Test(priority=-6)
  public void third() {
	  System.out.println("INSIDE Method No. THREE");
  }
  
  @Test(priority=3)
  public void fourth() {
	  System.out.println("INSIDE Method No. FOUR");
  }
  
  @Test(priority=8)
  public void fifth() {
	  System.out.println("INSIDE Method No. FIVE");
  }
  
  
  
  
}
