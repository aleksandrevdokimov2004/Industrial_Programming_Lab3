import java.util.ArrayList;

public class Main {

    public static void printList(ArrayList list){
        if(list.isEmpty()) return;
        for(Object one : list) {
            System.out.printf("%s\n", one);
        }
    }

    public static void main(String[] args) {
        System.out.println("Задание 1");
        Task1();
        System.out.println("Задание 2");
        Task2();
        System.out.println("Задание 3");
        Task3();
    }

    public static void Task1(){
        HouseGenerator houseGen = new HouseGenerator(3);
        houseGen.addNew(new House(0,6,15.f,3,3,1));
        System.out.println("Список домов с 3 комнатами");
        printList(houseGen.getHousesWithRooms(3));
        System.out.println("Список домов с 3 комнатами между 2 и 5 этажом");
        printList(houseGen.getHousesWithRoomsAndFloorRange(3,2,5));
        System.out.println("Список домов с площадью более 10 м^2");
        printList(houseGen.getHousesWithSquareMoreThan(10.f));

        System.out.printf("\nСписок домов\n%s", houseGen);
    }

    public static void Task2(){
        TriangleGenerator trGen = new TriangleGenerator(10);

        System.out.printf("Количество равносторонних треугольников %d\n", trGen.getEquilateralTriangles().size());
        System.out.printf("Количество равнобедренный треугольников %d\n", trGen.getIsoscelesTriangle().size());
        System.out.printf("Количество прямоугольных треугольников %d\n", trGen.getRightTriangle().size());
        System.out.printf("Количество других треугольников %d\n", trGen.getOtherTriangles().size());

        if(trGen.getTriangles().length!=0) {
            Triangle minSq = TriangleGenerator.getMinTriangleBySquare(trGen.getOtherTriangles());
            Triangle maxSq = TriangleGenerator.getMaxTriangleBySquare(trGen.getOtherTriangles());

            Triangle minP = TriangleGenerator.getMinTriangleByPerimeter(trGen.getOtherTriangles());
            Triangle maxP = TriangleGenerator.getMaxTriangleByPerimeter(trGen.getOtherTriangles());

            if(minSq!=null)
                System.out.println("Треугольник с минимальной площадью:\n" + minSq + "Площадь: " + minSq.findSq() + "\n");
            if(maxSq!=null)
                System.out.println("Треугольник с максимальной площадью:\n" + maxSq + "Площадь: " + maxSq.findSq() + "\n");
            if(minP!=null)
                System.out.println("Треугольник с минимальным периметром:\n" + minP + "Периметр: " + minP.findP() + "\n");
            if(maxP!=null)
                System.out.println("Треугольник с максимальным периметром:\n" + maxP + "Периметр: " + maxP.findP() + "\n");
        }
    }

    public static void Task3(){
        PointComplex complexPoint1 = new PointComplex(5,6);
        PointComplex complexPoint2 = new PointComplex(3,-10);
        System.out.printf("Расстояние от %s до начала координат %f\n", complexPoint2, complexPoint2.getDistFromThisToCordStart());
        System.out.printf("Расстояние от %s до точки %s равно %f\n", complexPoint1, complexPoint2, complexPoint2.getDistFromThisToPointComplex(complexPoint1));
        System.out.printf("Расстояние от %s до точки %s равно %f\n", complexPoint1, complexPoint2, PointComplex.getDistFromOneToAnotherPoint(complexPoint1, complexPoint2));
    }
}