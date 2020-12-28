import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        HotelManage hotelManage = new HotelManage();
        TreeMap<Integer, Room> listRooms = hotelManage.listRooms;
        int priceOfTypeA = 500000;
        int priceOfTypeB = 400000;
        int priceOfTypeC = 300000;
        Room roomId_101 = new Room("A", priceOfTypeA, 101);
        Room roomId_102 = new Room("A", priceOfTypeA, 102);
        Room roomId_103 = new Room("A", priceOfTypeA, 103);
        Room roomId_201 = new Room("B", priceOfTypeB, 201);
        Room roomId_202 = new Room("B", priceOfTypeB, 202);
        Room roomId_203 = new Room("B", priceOfTypeB, 203);
        Room roomId_301 = new Room("C", priceOfTypeC, 301);
        Room roomId_302 = new Room("C", priceOfTypeC, 302);
        Room roomId_303 = new Room("C", priceOfTypeC, 303);
        Room roomId_304 = new Room("C", priceOfTypeC, 304);
        Room[] newlistRoom = {roomId_101, roomId_102, roomId_103, roomId_201, roomId_202, roomId_203, roomId_301, roomId_302, roomId_303, roomId_304};
        for (Room room : newlistRoom) {
            listRooms.put(room.getRoom_id(), room);
        }
        Set<Integer> listRoomId = listRooms.keySet();
        do {
            System.out.println("1. add new person in room");
            System.out.println("2. edit person in room");
            System.out.println("3. remove person in room");
            System.out.println("4. get total money by person ID");
            System.out.println("5. display all person 's information");
            System.out.println("0. exit");
            choice = input.nextInt();
            int room_id_input;
            switch (choice) {
                case 1:
                    room_id_input = getRoom_id_input(input);
                    addNewPersonByRoomId(input, listRooms, room_id_input);
                    break;
                case 2:
                    room_id_input = getRoom_id_input(input);
                    editPersonByRoomId(input, listRooms, room_id_input);
                    break;
                case 3:
                    room_id_input = getRoom_id_input(input);
                    removePersonByRoomID(listRooms, room_id_input);
                    break;
                case 4:
                    System.out.println("input person ID");
                    int person_id_input = input.nextInt();
                    int totalMoney = hotelManage.getTotalMoneyById(person_id_input);
                    System.out.println(totalMoney);
                    break;
                case 5:
                    hotelManage.displayAllPerson();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }

    private static void removePersonByRoomID(TreeMap<Integer, Room> listRooms, int room_id_input) {
        Room room = listRooms.get(room_id_input);
        if (room == null) System.out.println("room is invalid");
        else {
            room.removePerson();
        }
    }

    public static int getRoom_id_input(Scanner input) {
        int room_id_input;
        System.out.println("input room id you want to add");
        room_id_input = input.nextInt();
        return room_id_input;
    }

    private static void addNewPersonByRoomId(Scanner input, TreeMap<Integer, Room> listRooms, int room_id_input) {
        Room room = listRooms.get(room_id_input);
        if (room == null) System.out.println("room is not valid");
        else {
            if (room.isEmpty) {
                Person person = getInputPerson();
                room.addPerson(person);
            } else System.out.println("room is full");
        }
    }

    private static void editPersonByRoomId(Scanner input, TreeMap<Integer, Room> listRooms, int room_id_input) {
        Room room = listRooms.get(room_id_input);
        if (room == null) System.out.println("room is not valid");
        else {
            if (!room.isEmpty) {
                Person person = getInputPerson();
                room.editPerson(person);
            } else System.out.println("room is empty");
        }
    }

    public static Person getInputPerson() {
        Scanner input = new Scanner(System.in);
        System.out.println("input name");
        String name = input.nextLine();
        System.out.println("input person id");
        int person_id = Integer.parseInt(input.nextLine());
        System.out.println("input birthday");
        String birthday = input.nextLine();
        System.out.println("input how many day living in hotel");
        int day = Integer.parseInt(input.nextLine());
        Person person = new Person(person_id, name, birthday, day);
        return person;
    }

}
