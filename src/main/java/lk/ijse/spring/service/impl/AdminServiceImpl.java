package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO admin) {
        if (!adminRepo.existsById(admin.getAdminId())){
            adminRepo.save(mapper.map(admin, Admin.class));
        }else {
            throw new RuntimeException(admin.getAdminId() + " " + "Admin Already Exists..!");
        }
    }

    @Override
    public void updateAdmin(AdminDTO admin) {
        if (adminRepo.existsById(admin.getAdminId())){
            adminRepo.save(mapper.map(admin, Admin.class));
        }else {
            throw new RuntimeException(admin.getAdminId() + " " + "No Such Admin..! Please Check The Correct Id..!");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if (adminRepo.existsById(id)){
            adminRepo.deleteById(id);
        }else {
            throw new RuntimeException(id + " " + "No Such Admin..! Please Check The Correct Id..!");
        }
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if (adminRepo.existsById(id)){
            Admin admin = adminRepo.findById(id).get();
            return mapper.map(admin, AdminDTO.class);
        }else {
            throw new RuntimeException(id + " " + "No Such Admin..! Please Check The Id..!");
        }
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        List<Admin> all = adminRepo.findAll();
        return mapper.map(all, new TypeToken<List<AdminDTO>>(){
        }.getType());
    }

    @Override
    public String generateAdminIds() {

        return adminRepo.generateAdminId();
    }
}
