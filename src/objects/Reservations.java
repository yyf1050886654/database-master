package objects;

public class Reservations {
    private String resvNum;//订单号
    private String custID;
    private int resvType;
    private String resvKey;//预定的航班号，大巴号，宾馆号

    public String getResvNum() {
        return resvNum;
    }

    public void setResvNum(String resvNum) {
        this.resvNum = resvNum;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public int getResvType() {
        return resvType;
    }

    public void setResvType(int resvType) {
        this.resvType = resvType;
    }

    public String getResvKey() {
        return resvKey;
    }

    public void setResvKey(String resvKey) {
        this.resvKey = resvKey;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "resvNum='" + resvNum + '\'' +
                ", custID='" + custID + '\'' +
                ", resvType=" + resvType +
                ", resvKey='" + resvKey + '\'' +
                '}'+"\n";
    }
}
