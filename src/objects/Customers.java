package objects;

public class Customers {
    private String custID;
    private String custName;

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "custID='" + custID + '\'' +
                ", custName='" + custName + '\'' +
                '}'+"\n";
    }
}
