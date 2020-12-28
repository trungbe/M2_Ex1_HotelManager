public class Person {
    private int person_id;
    private String name;
    private String birthday;
    private int day;

    public Person(int person_id, String name, String birthday, int day) {
        this.person_id = person_id;
        this.name = name;
        this.birthday = birthday;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getPersonId() {
        return person_id;
    }

    public void setInformation(int person_id, String name, String birthday, int day) {
        this.person_id = person_id;
        this.name = name;
        this.birthday = birthday;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
