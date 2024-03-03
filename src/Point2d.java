public class Point2d {
    private double x,y;

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point2d(){
        this(0,0);
    }

    public static double getDistance(Point2d A, Point2d B){
        return Math.sqrt(Math.pow(B.x-A.x,2)+ Math.pow(B.y-A.y,2));
    }

    public String toString(){
        return String.format("x = %f\ty = %f", this.x, this.y);
    }
}