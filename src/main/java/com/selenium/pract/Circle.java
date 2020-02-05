package day2;

public class Circle extends Shape implements IDrawable{
    double rad;
    
    
  @Override
    double calcArea() {
        area = 3.14 * rad * rad;
        return area;
    }
    public Circle(){
        this.rad = 5;
    }

    public Circle(double rad) {
        this.rad = rad;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Cirle");

    }

    @Override
    public void erase() {
        System.out.println("Erasing Circle");

    }

	

	
}
