package Classes;

public class TopCostumer {
    public String getName() {
        return Name;
    }


    public String getAddress() {
        return Address;
    }

    public int getSum() {
        return Sum;
    }

    public TopCostumer(String name, String address, int sum) {
        Name = name;
        Sum = sum;
        Address = address;
    }

    @Override
    public String toString() {
        return "TopCostumer{" +
                "Name='" + Name + '\'' +
                ", Sum=" + Sum +
                ", Address='" + Address + '\'' +
                '}';
    }

    String Name;
    int Sum;
    String Address;
}
