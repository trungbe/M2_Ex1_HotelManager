import java.util.Set;
import java.util.TreeMap;

public class HotelManage {
    public TreeMap<Integer, Room> listRooms = new TreeMap<>();

    public void displayAllPerson() {
        System.out.println(listRooms);
    }

    public int getTotalMoneyById(int person_id) {
        Set<Integer> listRoomId = listRooms.keySet();
        for (Integer id : listRoomId) {
            boolean isTruePersonId = person_id == listRooms.get(id).getPersonId();
            if (isTruePersonId) {
                return listRooms.get(id).getTotalMoney();
            }
        }
        return 0;
    }

}
