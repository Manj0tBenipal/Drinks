package ca.sheridancollege.sin13014.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Drink {
    private int id;
    private String name;
    private String main1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMain1() {
        return main1;
    }

    public void setMain1(String main1) {
        this.main1 = main1;
    }

    public double getAmount1() {
        return amount1;
    }

    public void setAmount1(double amount1) {
        this.amount1 = amount1;
    }

    public String getMain2() {
        return main2;
    }

    public void setMain2(String main2) {
        this.main2 = main2;
    }

    public double getAmount2() {
        return amount2;
    }

    public void setAmount2(double amount2) {
        this.amount2 = amount2;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getiURL() {
        return iURL;
    }

    public void setiURL(String iURL) {
        this.iURL = iURL;
    }

    private double amount1;
    private String main2;
    private double amount2;
    private String directions;
    private String iURL;

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", main1='" + main1 + '\'' +
                ", amount1=" + amount1 +
                ", main2='" + main2 + '\'' +
                ", amount2=" + amount2 +
                ", directions='" + directions + '\'' +
                ", URL='" + iURL + '\'' +
                '}';
    }
}
