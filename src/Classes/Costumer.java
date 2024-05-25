package Classes;

public class Costumer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebshopID() {
        return WebshopID;
    }

    public void setWebshopID(String webshopID) {
        WebshopID = webshopID;
    }

    private int id;
    private String name;
    private String address;
    private String WebshopID;
}
