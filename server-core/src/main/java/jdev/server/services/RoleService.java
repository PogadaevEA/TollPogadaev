package jdev.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jdev.server.dao.Role;
import jdev.server.dao.repo.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role create(Role role){
        return roleRepository.save(role);
    }

    public Role update(Role role){
        return roleRepository.save(role);
    }

    public void delete(Role role){
        roleRepository.delete(role);
    }

    public List<Role> findAll(){
        return (List<Role>) roleRepository.findAll();
    }

}
