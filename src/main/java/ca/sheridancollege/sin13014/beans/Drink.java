package ca.sheridancollege.sin13014.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Drink {
    private int id;
    private String name;
    private String main1;
    private double amount1;
    private String main2;
    private double amount2;
    private String directions;

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
                '}';
    }
}
