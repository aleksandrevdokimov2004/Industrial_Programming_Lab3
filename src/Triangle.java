public class Triangle {

    private Point2d A;
    private Point2d B;
    private Point2d C;
    private double abDist;
    private double bcDist;
    private double caDist;

    public static final double _ACCURACY = 0.0001;

    public Triangle(Point2d A, Point2d B, Point2d C){
        this.A = A;
        this.B = B;
        this.C = C;

        abDist = Point2d.getDistance(A,B);
        bcDist = Point2d.getDistance(B,C);
        caDist = Point2d.getDistance(C,A);
    }

    public Triangle(){
        this.A = new Point2d();
        this.B = new Point2d();
        this.C = new Point2d();

        abDist = Point2d.getDistance(A,B);
        bcDist = Point2d.getDistance(B,C);
        caDist = Point2d.getDistance(C,A);
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

        abDist = Point2d.getDistance(A,B);
        bcDist = Point2d.getDistance(B,C);
        caDist = Point2d.getDistance(C,A);
    }

    /**
     * Проверяет, является ли треугольник равносторонний
     * @return boolean
     */
    public boolean isEquilateralTriangles(){ //равносторониий
        boolean isABeqBC = Math.abs(abDist-bcDist)<_ACCURACY;
        boolean isBCeqCA = Math.abs(bcDist-caDist)<_ACCURACY;
        return isABeqBC && isBCeqCA;
    }

    /**
     * Проверяет, является ли треугольник равнобедренный
     * @return boolean
     */

    public boolean isIsoscelesTriangle(){ //равнобедренный
        boolean isABeqBC = Math.abs(abDist-bcDist)<_ACCURACY;
        boolean isABeqCA = Math.abs(abDist-caDist)<_ACCURACY;
        boolean isBCeqCA = Math.abs(bcDist-caDist)<_ACCURACY;
        return isABeqBC || isABeqCA || isBCeqCA;
    }

    /**
     * Проверяет, является ли треугольник прямоугольным
     * @return boolean
     */
    public boolean isRightTriangle(){ //прямоугольный
        boolean isCAgipot = Math.abs(Math.pow(abDist,2)+Math.pow(bcDist,2)-Math.pow(caDist,2))<_ACCURACY;
        boolean isABgipot = Math.abs(Math.pow(caDist,2)+Math.pow(bcDist,2)-Math.pow(abDist,2))<_ACCURACY;
        boolean isBCgipot = Math.abs(Math.pow(caDist,2)+Math.pow(abDist,2)-Math.pow(bcDist,2))<_ACCURACY;
        return isCAgipot || isABgipot || isBCgipot;
    }
}