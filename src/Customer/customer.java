package Customer;

public class customer {
    private String Name;
    private int age;
    private int Phone;

    public customer(String name, int age, int phone) {
        Name = name;
        this.age = age;
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "customer{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", Phone=" + Phone +
                '}';
    }
}
