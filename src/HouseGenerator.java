import java.util.Arrays;

public class HouseGenerator {
    private House[] houses;
    HouseGenerator(int count){
        houses = new House[count];
        for(int i =0 ;i<count; i++)
            houses[i] = new House(i, i+1, 10.f, 1+i/4, 3, 1);
    }

    public House getHouseById(int id){
        if (id >= 0 && id < houses.length) return houses[id];
        System.out.print("Ошибка: Выход за границы массива\n");
        return null;
    }

    public House[] getHouses() {
        return houses;
    }

    public String toString(){
        String output = "";
        for(House each : houses)
            output = output.concat(each+"\n");
        return output;
    }

    public void addNew(House newHouse){
        houses = Arrays.copyOf(houses, houses.length+1);
        houses[houses.length-1]=newHouse;
        houses[houses.length-1].setId(houses.length-1);
    }

    public void eraseById(int id){
        if(id<0 || id>= houses.length) {
            System.out.print("Ошибка: Выход за границы массива\tНичего не изменено\n");
            return;
        }
        for(int i = 0, k = 0; i < houses.length; i++){
            if (i == id) {
                continue;
            }
            houses[k++] = houses[i];
        }
        houses = Arrays.copyOf(houses, houses.length-1);
    }

    public void printHousesWithRooms(int rooms){
        System.out.printf("Квартиры с %d комнатами\n", rooms);
        for(House one : houses){
            if(one.getRooms()==rooms)
                System.out.println(one);
        }
    }

    public void printHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor){
        System.out.printf("Квартиры с %d комнатами и на этажах с %d до %d\n", rooms, minFloor, maxFloor);
        for(House one : houses){
            if(one.getRooms()==rooms && one.getFloor() >= minFloor && one.getFloor()<=maxFloor)
                System.out.println(one);
        }
    }

    public void printHousesWithSquareMoreThan(float sq){
        System.out.printf("Квартиры с площадью больше %.2f\n", sq);
        for(House one : houses)
            if(one.getSquare()>sq)
                System.out.println(one);
    }
}