package exercise;

// BEGIN
public class Cottage implements Home {
    double area;
    int floorCount;

    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount =  floorCount;
    }
    @Override
    public double getArea() {
        return this.area;
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
        return this.floorCount + " этажный коттедж площадью " + this.area + " метров";
    }
}
// END
