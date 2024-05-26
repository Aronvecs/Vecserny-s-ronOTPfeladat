package Classes;

public class Costumer {
    public int getId() {
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

    public Costumer(int id, String name, String address, String webshopID) {
        this.id = id;
        this.name = name;
        this.address = address;
        WebshopID = webshopID;
    }

    private int id;
    private String name;
    private String address;
    private String WebshopID;
}
