package repo;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Users;
import lk.ijse.spring.repo.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
public class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void saveCustomer(){
       /* Customer customer = new Customer(
                "C00-0001",
                LocalDate.parse("2021-12-21"),
                "Bihara",
                "Galle",
                "078-7991075",
                "rash@gmail.com",
                "995371286v",
                "22548962125v",
                new Users("U00-0001","Cus","1234")
        );
        customerRepo.save(customer);*/
    }

}
