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

    public ArrayList<Triangle> getIsoscelesTriangle(){
        return isoscelesTriangle;
    }

    public ArrayList<Triangle> getRightTriangle(){
        return rightTriangle;
    }

    public ArrayList<Triangle> getOtherTriangles(){
        return other;
    }

    TriangleGenerator(int count, double origin, double bounds){
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

    TriangleGenerator(int count){
        this(count, 0,1);
    }

    TriangleGenerator(){
        this(0, 0,1);
    }

    TriangleGenerator(Triangle[] triangles){
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
        if(id < 0 || id>triangles.length) {
            System.out.print("Ошибка: Выход за границы массива\n");
            return null;
        }
        return triangles[id];
    }

    public void addNew(Triangle newTriangle){
        triangles = Arrays.copyOf(triangles, triangles.length+1);
        triangles[triangles.length-1]=newTriangle;
    }

    public void eraseById(int id){
        if(id<0 || id>= triangles.length) {
            System.out.print("Ошибка: Выход за границы массива\tНичего не изменено\n");
            return;
        }
        for(int i = 0, k = 0; i < triangles.length; i++){
            if (i == id) {
                continue;
            }
            triangles[k++] = triangles[i];
        }
        triangles = Arrays.copyOf(triangles, triangles.length-1);
    }

    public static void printList(ArrayList<Triangle> list){
        if(list.isEmpty()) return;
        for(Triangle one : list) {
            System.out.printf("%s\n", one);
        }
    }

    public void printCountOfSorted(){
        recountTriangles();
        System.out.printf("Количество равносторонних треугольников %d\n", equilateralTriangles.size());
        System.out.printf("Количество равнобедренный треугольников %d\n", isoscelesTriangle.size());
        System.out.printf("Количество прямоугольных треугольников %d\n", rightTriangle.size());
        System.out.printf("Количество других треугольников %d\n", other.size());
    }

    public static void printMinNMaxForGroup(ArrayList<Triangle> list){
        if(list.isEmpty()) {
            System.out.print("Ошибка: Массив пуст\n");
            return;
        }
        Triangle minSq = list.getFirst();
        Triangle maxSq = list.getFirst();
        Triangle minP = list.getFirst();
        Triangle maxP = list.getFirst();
        for(Triangle one : list){
            if(one.findSq() > maxSq.findSq()) maxSq=one;
            if(one.findSq() < minSq.findSq()) minSq=one;
            if(one.findP() > maxP.findP()) maxP=one;
            if(one.findP() < minSq.findP()) minP=one;
        }
        System.out.println("Треугольник с минимальной площадью:\n" + minSq + "Площадь: " + minSq.findSq() + "\n");
        System.out.println("Треугольник с максимальной площадью:\n" + maxSq + "Площадь: " + maxSq.findSq() + "\n");
        System.out.println("Треугольник с минимальным периметром:\n" + minP + "Периметр: " + minP.findP() + "\n");
        System.out.println("Треугольник с максимальным периметром:\n" + maxP + "Периметр: " + maxP.findP() + "\n");
    }
}
