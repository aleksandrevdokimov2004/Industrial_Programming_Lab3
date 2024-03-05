public class Triangle {

    private Point2d a;
    private Point2d b;
    private Point2d c;
    private double abDist;
    private double bcDist;
    private double caDist;

    public static final double _ACCURACY = 0.0001;

    public Triangle(Point2d a, Point2d b, Point2d c){
        this.a = a;
        this.b = b;
        this.c = c;

        abDist = Point2d.getDistance(a,b);
        bcDist = Point2d.getDistance(b,c);
        caDist = Point2d.getDistance(c,a);
    }

    public Triangle(){
        this.a = new Point2d();
        this.b = new Point2d();
        this.c = new Point2d();

        abDist = Point2d.getDistance(a,b);
        bcDist = Point2d.getDistance(b,c);
        caDist = Point2d.getDistance(c,a);
    }

    public String toString(){
        return String.format("Координаты:\ta:\t%s\t\t", a) +
                String.format("b:\t%s\t\t", b) +
                String.format("c:\t%s\n", c) +
                String.format("Длины:\tAB = %f\tBC = %f\tCA  = %f\n",
                        Point2d.getDistance(a,b),
                        Point2d.getDistance(b,c),
                        Point2d.getDistance(c,a));
    }

    public double findSq(){
        return 0.5*Math.abs((b.getX()-a.getX())*(c.getY()-a.getY())-(c.getX()-a.getX())*(b.getY()-a.getY()));
    }

    public double findP(){
        return Math.sqrt(Math.pow(b.getX() - a.getX(),2) + Math.pow(b.getY() - a.getY(),2));
    }

    public void setPoints(Point2d newPointA,Point2d newPointB,Point2d newPointC){
        this.a=newPointA;
        this.b=newPointB;
        this.c=newPointC;

        abDist = Point2d.getDistance(a,b);
        bcDist = Point2d.getDistance(b,c);
        caDist = Point2d.getDistance(c,a);
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