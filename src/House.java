public class House{
    private int id, number;
    private float square;
    private int floor, rooms;
    private String street;
    private String buildingType;
    private int lifetime;

    House(int id, int number, float sq, int floor, //конструктор 1
          int rooms, String street, String bType, int lifetime){
        this.id = id;
        this.number = number;
        this.square = sq;
        this.floor = floor;
        this.rooms = rooms;
        this.street = street;
        this.buildingType = bType;
        this.lifetime = lifetime;
    }

    House(int id, int number, float sq, int floor, int rooms, int lifetime){ //конструктор 2
        this(id,number,sq,floor,rooms,
                "НД", "НД", lifetime);
    }

    House(){ //конструктор 3
        this(-1,-1,-1,-1,-1,
                "НД", "НД", -1);
    }

    public void setId(int newId){
        this.id=newId;
    }

    public void setNumber(int newNumber){
        this.number=newNumber;
    }

    public void setSquare(int newSq){
        this.square=newSq;
    }

    public void setFloor(int newFloor){
        this.floor=newFloor;
    }

    public void setRooms(int newRooms){
        this.rooms=newRooms;
    }

    public void setStreet(String newStreet){
        this.street=newStreet;
    }

    public void setBuildingType(String newBType){
        this.buildingType=newBType;
    }

    public void setLifetime(int newLifetime){
        this.lifetime=newLifetime;
    }

    public int getId(){
        return this.id;
    }

    public int getNumber(){
        return this.number;
    }

    public float getSquare(){
        return this.square;
    }

    public int getFloor(){
        return this.floor;
    }

    public int getRooms(){
        return this.rooms;
    }

    public String getStreet(){
        return this.street;
    }

    public String getBuildingType(){
        return this.buildingType;
    }

    public int getLifetime(){
        return this.lifetime;
    }

    public String toString() {
        return String.format("id: %d\tНомер квартиры: %d\tПлощадь: %.1f\tЭтаж: %d\t" +
                        "Количество комнат: %d\tУлица: %s\tТип здания: %s\tСрок эксплуатации: %d", id, number,
                square, floor, rooms, street, buildingType, lifetime);
    }

    public void setData(int id, int number, float sq, int floor,
                        int rooms, String street, String bType, int lifetime){
        this.id = id;
        this.number = number;
        this.square = sq;
        this.floor = floor;
        this.rooms = rooms;
        this.street = street;
        this.buildingType = bType;
        this.lifetime = lifetime;
    }
}