public class Triangle {

    private Point2d A;
    private Point2d B;
    private Point2d C;

    public static final double accuracy = 0.0001;

    Triangle(Point2d A, Point2d B, Point2d C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    Triangle(){
        this.A = new Point2d();
        this.B = new Point2d();
        this.C = new Point2d();
    }

    public String toString(){
        return String.format("Координаты:\tA:\t%s\t\t", A) +
                String.format("B:\t%s\t\t", B) +
                String.format("C:\t%s\n", C) +
                String.format("Длины:\tAB = %f\tBC = %f\tCA  = %f\n",
                        Point2d.getDistance(A,B),
                        Point2d.getDistance(B,C),
                        Point2d.getDistance(C,A));
    }

    public double findSq(){
        return 0.5*Math.abs((B.getX()-A.getX())*(C.getY()-A.getY())-(C.getX()-A.getX())*(B.getY()-A.getY()));
    }

    public double findP(){
        return Math.sqrt(Math.pow(B.getX() - A.getX(),2) + Math.pow(B.getY() - A.getY(),2));
    }

    public void setPoints(Point2d newPointA,Point2d newPointB,Point2d newPointC){
        this.A=newPointA;
        this.B=newPointB;
        this.C=newPointC;
    }

    /**
     * Проверяет, является ли треугольник равносторонний
     * @return boolean
     */
    public boolean isEquilateralTriangles(){ //равносторониий
        return Math.abs(Point2d.getDistance(A,B)-Point2d.getDistance(B,C))<accuracy
                && Math.abs(Point2d.getDistance(B,C)-Point2d.getDistance(A,C))<accuracy;
    }

    /**
     * Проверяет, является ли треугольник равнобедренный
     * @return boolean
     */

    public boolean isIsoscelesTriangle(){ //равнобедренный
        return (
                Math.abs(Point2d.getDistance(A,B)-Point2d.getDistance(B,C))<accuracy
                        && Math.abs(Point2d.getDistance(A,B)-Point2d.getDistance(A,C))>=accuracy
                ) || (
                Math.abs(Point2d.getDistance(A,C)-Point2d.getDistance(A,B))<accuracy
                        && Math.abs(Point2d.getDistance(A,B)-Point2d.getDistance(C,B))>=accuracy
                ) || (
                Math.abs(Point2d.getDistance(A,C)-Point2d.getDistance(C,B))<accuracy
                        && Math.abs(Point2d.getDistance(A,C)-Point2d.getDistance(A,B))>=accuracy
                );
    }

    /**
     * Проверяет, является ли треугольник прямоугольным
     * @return boolean
     */
    public boolean isRightTriangle(){ //прямоугольный
        return (
                Math.abs((Math.pow(Point2d.getDistance(A,B),2)
                + Math.pow(Point2d.getDistance(B,C),2)) - Math.pow(Point2d.getDistance(A,C),2))<accuracy
                ) || (
                Math.abs((Math.pow(Point2d.getDistance(A,B),2)
                        + Math.pow(Point2d.getDistance(A,C),2)) - Math.pow(Point2d.getDistance(B,C),2))<accuracy
                ) || (
                Math.abs((Math.pow(Point2d.getDistance(B,C),2)
                        + Math.pow(Point2d.getDistance(A,C),2)) - Math.pow(Point2d.getDistance(A,B),2))<accuracy
                );
    }
}
