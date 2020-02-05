package sequencing;

import org.testng.annotations.Test;

public class TestSkipping {
  //@Test(enabled = false)
  public void first() {
	  System.out.println("INSIDE Method No. ONE");
  }
  
  @Test(enabled = true, priority = 40)
  public void second() {
	  System.out.println("INSIDE Method No. TWO");
  }
  
  @Test(enabled = false)
  public void third() {
	  System.out.println("INSIDE Method No. THREE");
  }
  
  @Test(priority=60)
  public void fourth() {
	  System.out.println("INSIDE Method No. FOUR");
  }
  
  @Test(enabled = true)
  public void fifth() {
	  System.out.println("INSIDE Method No. FIVE");
  }
  
  
  
  
}
