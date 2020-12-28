public class Room {
    public boolean isEmpty = true;
    private String type;
    private int price;
    private int room_id;
    private Person person;

    public Room(String type, int price, int room_id) {
        this.type = type;
        this.price = price;
        this.room_id = room_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public int getPersonId() {
        return person.getPersonId();
    }

    public void addPerson(Person person) {
        this.person = person;
        isEmpty = false;
    }

    public void editPerson(Person person) {
        this.person = person;
    }

    public void removePerson() {
        this.person = null;
        isEmpty = true;
    }

    @Override
    public String toString() {
        if (person == null) return "Room is empty";
        return "Room{" +
                "type='" + type + '\'' + " room id " + room_id +
                ", price=" + price +
                person.toString() +
                '}';
    }

    public int getTotalMoney() {
        return price * person.getDay();
    }
}
