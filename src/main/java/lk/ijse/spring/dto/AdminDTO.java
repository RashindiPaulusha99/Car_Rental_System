package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AdminDTO {
    private String adminId;
    private UsersDTO users;
    private String adminName;
    private String adminAddress;
    private String adminContact;
    private String adminEmail;
}
