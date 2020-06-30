package homework33.src.main.java.com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AddressDTO {
    private String postalCode;
    private String country;
    private String city;
    private String street;
    private String building;
    private String flat;
}
