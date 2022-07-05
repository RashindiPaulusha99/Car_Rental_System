package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Admin {
    private String adminId;
    private String adminName;
    private String adminAddress;
    private String adminContact;
    private String adminEmail;

}
