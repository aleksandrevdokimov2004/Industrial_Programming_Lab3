public class Point2d {
    public double x,y;

    Point2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    Point2d(){
        this(0,0);
    }

    public static double getDistance(Point2d A, Point2d B){
        return Math.sqrt(Math.pow(B.x-A.x,2)+ Math.pow(B.y-A.y,2));
    }
}