package Order;

public class Order {
    private int Oid;
    private String BName;
    private String Name;


    public Order(int oid, String bName, String name) {
        Oid = oid;
        BName = bName;
        Name = name;
    }

    public int getOid() {
        return Oid;
    }

    public void setOid(int oid) {
        Oid = oid;
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Oid=" + Oid +
                ", BName='" + BName + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
