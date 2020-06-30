package homework33.src.main.java.com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "user_table")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String lastName;
    private String email;
    private String phone;

    @JoinColumn(name = "address_id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "Login")
    private String login;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    private String pass;

}
