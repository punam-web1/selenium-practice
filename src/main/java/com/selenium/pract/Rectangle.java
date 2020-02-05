package day2;

public class Rectangle extends Shape implements IDrawable {
    double len;
    double width;
    @Override
    double calcArea() {
        area = len * width;
        return area;
    }

    public Rectangle() {
    }

    public Rectangle(double len, double width) {
        this.len = len;
        this.width = width;
    }

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		
	}
}
