import java.util.ArrayList;
import java.util.Arrays;

public class HouseGenerator {
    private House[] houses;

    public HouseGenerator(int count){
        houses = new House[count];
        for(int i =0 ;i<count; i++)
            houses[i] = new House(i, i+1, 10.f, 1+i/4, 3, 1);
    }

    public House getHouseById(int id){
        if (id >= 0 && id < houses.length) return houses[id];
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

    public boolean eraseById(int id){
        if(id<0 || id>= houses.length) return false;
        for(int i = 0, k = 0; i < houses.length; i++){
            if (i == id) {
                continue;
            }
            houses[k++] = houses[i];
        }
        houses = Arrays.copyOf(houses, houses.length-1);
        return true;
    }

    public ArrayList<House> getHousesWithRooms(int rooms){
        ArrayList<House> housesWith = new ArrayList<>();
        for(House one : houses){
            if(one.getRooms()==rooms)
                housesWith.add(one);
        }
        return housesWith;
    }

    public ArrayList<House> getHousesWithRoomsAndFloorRange(int rooms, int minFloor, int maxFloor){
        ArrayList<House> housesWith = new ArrayList<>();
        for(House one : houses){
            if(one.getRooms()==rooms && one.getFloor() >= minFloor && one.getFloor()<=maxFloor)
                housesWith.add(one);
        }
        return housesWith;
    }

    public ArrayList<House> getHousesWithSquareMoreThan(float sq){
        ArrayList<House> housesWith = new ArrayList<>();
        for(House one : houses)
            if(one.getSquare()>sq)
                housesWith.add(one);
        return housesWith;
    }
}