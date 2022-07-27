package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UsersDTO {
    private String userId;
    private String username;
    private String password;

}
