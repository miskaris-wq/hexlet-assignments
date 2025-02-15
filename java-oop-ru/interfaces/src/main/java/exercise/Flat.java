package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        if (this.area > another.getArea()) {
            return 1;
        } else if (this.area == another.getArea()) {
            return 0;

        }
        return -1;
    }

    public String toString() {
        double fullArea = this.area + this.balconyArea;
        return "Квартира площадью " +  fullArea + " метров на " + floor + " этаже";
    }
}
// END
