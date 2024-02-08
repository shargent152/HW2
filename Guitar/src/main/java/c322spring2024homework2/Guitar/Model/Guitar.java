package c322spring2024homework2.Guitar.Model;

public class Guitar {
    String serialNumber;
    double price;
    String builder;
    String model;
    String type;
    String backWood;
    String topWood;

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }

    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBackWood() {
        return backWood;
    }


    public String getTopWood() {
        return topWood;
    }

    public double getPrice() {
        return price;
    }


    public String getBuilder() {
        return builder;
    }


    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

}
