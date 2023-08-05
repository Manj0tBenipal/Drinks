package ca.sheridancollege.sin13014.Assignment3_Manjot_Singh.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private int id;
    private String address;
    private String userName;
    private String date;
    private String time;
    private double price;
    private String animeGroup;

    public void setTime(String time) {
        this.time= time;
        if(time.equals("9:00AM EDT")){
            this.price = 234.98;
        }else if(time.equals("9:00PM EDT")){
            this.price=199.90;
        }else{
            this.price = 300.00;
        }
    }


}
