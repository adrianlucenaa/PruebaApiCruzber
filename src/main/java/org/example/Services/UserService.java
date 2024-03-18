package org.example.Services;

import org.example.models.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    //Logica para devolver todos los usuarios
    public List<User> getAllUsers() {
        List<User> users = repo.findAll();
        return repo.findAll();
    }

    //Logica para crear o actualizar a un usuario
    public User createOrUpdateUser(User user) {
        if (user.getCodigoCliente() > 0) { //update
            Optional<User> u = repo.findById(user.getCodigoCliente());
            if (u.isPresent()) {
                user = u.get();
                user.setDni(user.getDni());
                user.setFechaAlta(user.getFechaAlta());
                user.setRazonSocial(user.getRazonSocial());
                return repo.save(user);
            } else {
                return repo.save(user);
            }
        }

     }



        //Logica para borrar a un usuario
        public void deleteUser ( int CodigoCliente){
            Optional<User> u = repo.findById(CodigoCliente);
            if (u.isPresent()) {
                repo.delete(u.get());
            } else {
                throw new RuntimeException("User not found");
            }

        }

    }

}
