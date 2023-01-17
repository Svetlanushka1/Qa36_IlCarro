package model;

import lombok.*;

@Setter
@Getter
@ToString
@Builder

public class Car {
    private String location;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
    private String seats;
    private String clasS;
    private String carRegNumber;
    private String price;
    private String about;
}
