package Classes;

public class Costumer {
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getWebshopID() {
        return WebshopID;
    }

    public Costumer(String id, String name, String address, String webshopID) {
        this.id = id;
        this.name = name;
        this.address = address;
        WebshopID = webshopID;
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", WebshopID='" + WebshopID + '\'' +
                '}';
    }

    private final String id;
    private final String name;
    private final String address;
    private final String WebshopID;
}
