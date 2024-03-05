import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TriangleGenerator {
    private int count;
    private Triangle[] triangles;

    private ArrayList<Triangle> equilateralTriangles;
    private ArrayList<Triangle> isoscelesTriangle;
    private ArrayList<Triangle> rightTriangle;
    private ArrayList<Triangle> other;

    public ArrayList<Triangle> getEquilateralTriangles(){
        return equilateralTriangles;
    }

    public ArrayList<Triangle> getIsoscelesTriangle(){ return isoscelesTriangle; }

    public ArrayList<Triangle> getRightTriangle(){
        return rightTriangle;
    }

    public ArrayList<Triangle> getOtherTriangles(){
        return other;
    }

    public TriangleGenerator(int count, double origin, double bounds){
        Random rd = new Random();
        this.count = count;
        triangles = new Triangle[count];

        equilateralTriangles = new ArrayList<>();
        isoscelesTriangle = new ArrayList<>();
        rightTriangle = new ArrayList<>();
        other = new ArrayList<>();

        for(int i =0; i<count; i++){
            Point2d A = new Point2d(rd.nextDouble(origin,bounds), rd.nextDouble(origin,bounds));
            Point2d B = new Point2d(rd.nextDouble(origin,bounds), rd.nextDouble(origin,bounds));
            Point2d C = new Point2d(rd.nextDouble(origin,bounds), rd.nextDouble(origin,bounds));
            triangles[i]=new Triangle(A,B,C);
        }
        recountTriangles();
    }

    public TriangleGenerator(int count){
        this(count, 0,1);
    }

    public TriangleGenerator(){
        this(0, 0,1);
    }

    public TriangleGenerator(Triangle[] triangles){
        this.count = triangles.length;
        this.triangles = triangles;

        equilateralTriangles = new ArrayList<>();
        isoscelesTriangle = new ArrayList<>();
        rightTriangle = new ArrayList<>();
        other = new ArrayList<>();

        recountTriangles();
    }

    public void setTriangles(Triangle[] triangles){
        this.count = triangles.length;
        this.triangles = triangles;
    }

    public Triangle[] getTriangles(){
        return triangles;
    }

    public void recountTriangles(){
        equilateralTriangles = new ArrayList<>();
        isoscelesTriangle = new ArrayList<>();
        rightTriangle = new ArrayList<>();
        other = new ArrayList<>();
        for(int i =0; i<count; i++){
            if(triangles[i].isEquilateralTriangles()) equilateralTriangles.add(triangles[i]);
            else if(triangles[i].isIsoscelesTriangle()) isoscelesTriangle.add(triangles[i]);
            else if(triangles[i].isRightTriangle()) rightTriangle.add(triangles[i]);
            else other.add(triangles[i]);
        }
    }

    public Triangle getTriangleById(int id){
        if(id < 0 || id>triangles.length)
            return null;
        return triangles[id];
    }

    public void addNew(Triangle newTriangle){
        triangles = Arrays.copyOf(triangles, triangles.length+1);
        triangles[triangles.length-1]=newTriangle;
        recountTriangles();
    }

    public boolean eraseById(int id){
        if(id<0 || id>= triangles.length)
            return false;
        for(int i = 0, k = 0; i < triangles.length; i++){
            if (i == id) {
                continue;
            }
            triangles[k++] = triangles[i];
        }
        triangles = Arrays.copyOf(triangles, triangles.length-1);
        recountTriangles();
        return true;
    }

    public static Triangle getMinTriangleBySquare(ArrayList<Triangle> list) {
        if(list.isEmpty()) { return null; }
        Triangle minSq = list.getFirst();
        double minSqValue = list.getFirst().findSq();
        for(Triangle one : list){
            if(one.findSq() < minSqValue) {
                minSq=one;
                minSqValue=one.findSq();
            }
        }
        return minSq;
    }

    public static Triangle getMaxTriangleBySquare(ArrayList<Triangle> list) {
        if(list.isEmpty()) { return null; }
        Triangle maxSq = list.getFirst();
        double maxSqValue = list.getFirst().findSq();
        for(Triangle one : list){
            if(one.findSq() > maxSqValue) {
                maxSq=one;
                maxSqValue=one.findSq();
            }
        }
        return maxSq;
    }

    public static Triangle getMinTriangleByPerimeter(ArrayList<Triangle> list) {
        if(list.isEmpty()) { return null; }
        Triangle maxP = list.getFirst();
        double maxPValue = list.getFirst().findP();
        for(Triangle one : list){
            if(one.findP() < maxPValue) {
                maxP=one;
                maxPValue=one.findP();
            }
        }
        return maxP;
    }

    public static Triangle getMaxTriangleByPerimeter(ArrayList<Triangle> list) {
        if(list.isEmpty()) { return null; }
        Triangle minP = list.getFirst();
        double minPValue = list.getFirst().findP();
        for(Triangle one : list){
            if(one.findP() > minPValue) {
                minP=one;
                minPValue=one.findP();
            }
        }
        return minP;
    }
}
