package objects;

public class Bus {
    private String BusNum;
    private String location;
    private int price;
    private int numSeats;
    private int numAvail;

    public String getBusNum() {
        return BusNum;
    }

    public void setBusNum(String busNum) {
        BusNum = busNum;
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

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public int getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(int numAvail) {
        this.numAvail = numAvail;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "BusNum='" + BusNum + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", numSeats=" + numSeats +
                ", numAvail=" + numAvail +
                '}'+"\n";
    }
}
