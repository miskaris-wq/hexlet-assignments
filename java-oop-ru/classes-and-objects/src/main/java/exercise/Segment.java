package exercise;

// BEGIN
class Segment {
    private Point point1;
    private Point point2;

    Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getBeginPoint() {
        return point1;
    }

    public Point getEndPoint() {
        return point2;
    }

    public Point getMidPoint() {
        int x = (point1.getX() + point2.getY()) / 2;
        int y = (point1.getY() + point2.getY()) / 2;
        return new Point(x, y);
    }
}
// END
