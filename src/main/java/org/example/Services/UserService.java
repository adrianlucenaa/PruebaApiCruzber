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
    private UserRepository repository;

    //Logica que devuelve todos los clientes
    public List<User> getAllUsers(){
        List<User> clientes = repository.findAll();
        return clientes;
    }

    //Logica que devuelve un cliente por CodigoCliente
    public Optional<User> getUser(int CodigoCliente){
        Optional<User> cliente = repository.findById(CodigoCliente);
        return cliente;
    }

    //Logica para crear o actualizar a un cliente
    public User createOrUpdateUser(User user){
        if(user.getCodigoCliente() == 0){
            return repository.save(user);
        }else{
            Optional<User> query = repository.findById(user.getCodigoCliente());
            if(query.isPresent()){
                User newUser = query.get();
                newUser.setDni(user.getDni());
                newUser.setFechaAlta(user.getFechaAlta());
                newUser.setRazonSocial(user.getRazonSocial());
                return repository.save(newUser);
            }else{
                return repository.save(user);
            }
        }
    }

    //Logica para borrar a un cliente
    public User deleteUser(int CodigoCliente){
        Optional<User> user = repository.findById(CodigoCliente);
        if(user.isPresent()){
            repository.deleteById(CodigoCliente);
        }
        return user.get();
    }
}

