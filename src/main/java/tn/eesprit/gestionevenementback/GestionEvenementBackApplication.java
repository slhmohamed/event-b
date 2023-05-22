package tn.eesprit.gestionevenementback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.eesprit.gestionevenementback.Entities.ERole;
import tn.eesprit.gestionevenementback.Entities.Role;
import tn.eesprit.gestionevenementback.Repository.RoleRepository;

import java.util.Optional;

@SpringBootApplication
public class GestionEvenementBackApplication implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionEvenementBackApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Optional _memebre=roleRepository.findByName(ERole.membre);
        System.out.println(_memebre.isPresent());
        if(_memebre.isPresent()==false){
            Role _role=new Role(ERole.membre);
            System.out.println(_role);
            roleRepository.save(_role);
        }
        Optional _admin=roleRepository.findByName(ERole.admin);
        if(_admin.isPresent()==false){

            roleRepository.save(new Role(ERole.admin));
        }
    }


}
