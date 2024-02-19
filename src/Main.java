public class Main {

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
        houseGen.printHousesWithRooms(3);
        houseGen.printHousesWithRoomsAndFloorRange(3,2,5);
        houseGen.printHousesWithSquareMoreThan(10.f);
        System.out.printf("\nСписок домов\n%s", houseGen);
    }

    public static void Task2(){
        TriangleGenerator trGen = new TriangleGenerator(10);
        System.out.printf("Площадь 1-ого треугольника = %f\n", trGen.getTriangleById(1).findSq());
        System.out.printf("Периметр 2-ого треугольника = %f\n", trGen.getTriangleById(2).findSq());
        trGen.printCountOfSorted();
        trGen.recountTriangles();
        System.out.println();
        TriangleGenerator.printMinNMaxForGroup(trGen.getOtherTriangles());
    }

    public static void Task3(){
        PointComplex complexPoint1 = new PointComplex(5,6);
        PointComplex complexPoint2 = new PointComplex(3,-10);
        System.out.printf("Расстояние от %s до начала координат %f\n", complexPoint2, complexPoint2.getDistFromThisToCordStart());
        System.out.printf("Расстояние от %s до точки %s равно %f\n", complexPoint1, complexPoint2, complexPoint2.getDistFromThisToPointComplex(complexPoint1));
        System.out.printf("Расстояние от %s до точки %s равно %f\n", complexPoint1, complexPoint2, PointComplex.getDistFromOneToAnotherPoint(complexPoint1, complexPoint2));
    }
}