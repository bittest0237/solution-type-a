package problem03;

public class RectTriangle extends Shape {
	private double width;
	private double height;

	public RectTriangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		double res = this.width * this.height * 0.5;
		System.out.println("");
		return res;
	}

	@Override
	public double getPerimeter() {
		double res = 0.0, c = 0.0;
		c = width* width + height * height;
		res = Math.sqrt(c)+width+height;
		return res;
	}
}
