package objects;

public class Hotels {
    private String hotelNum;
    private String location;
    private int price;
    private int numRooms;
    private int numAvail;

    public String getHotelNum() {
        return hotelNum;
    }

    public void setHotelNum(String hotelNum) {
        this.hotelNum = hotelNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public int getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(int numAvail) {
        this.numAvail = numAvail;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "hotelNum='" + hotelNum + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", numRooms=" + numRooms +
                ", numAvail=" + numAvail +
                '}'+"\n";
    }
}
