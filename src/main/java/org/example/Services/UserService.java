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
    public Optional<User> getUser(int CodigoCliente) {
        Optional<User> user = repository.findById(CodigoCliente);
        if (user.isPresent()) {
            return user;
        } else {
            throw new org.example.exception.RecordNotFoundException("No se encontro el cliente");
        }
    }

    //Logica para crear o actualizar a un cliente
    public User createOrUpdateUser(User user){
        if (user.getCodigoCliente() > 0) {
            Optional<User> result = repository.findById(user.getCodigoCliente());
            if (result.isPresent()) {
                User currentUser = result.get();
                currentUser.setDni(user.getDni());
                currentUser.setFechaAlta(user.getFechaAlta());
                currentUser.setRazonSocial(user.getRazonSocial());
                return repository.save(currentUser);
            } else {
                throw new org.example.exception.RecordNotFoundException("No se encontro el cliente");
            }
        } else {
            return repository.save(user);
        }
    }

    /*
    // Lógica para crear o actualizar un cliente
    public User createOrUpdateUser(User user){
        if (user.getCodigoCliente() != null && user.getCodigoCliente() > 0) {
            Optional<User> result = repository.findById(user.getCodigoCliente());
            if (result.isPresent()) {
                User currentUser = result.get();
                currentUser.setDni(user.getDni());
                currentUser.setFechaAlta(user.getFechaAlta());
                currentUser.setRazonSocial(user.getRazonSocial());
                return repository.save(currentUser); // Actualizar el usuario existente
            } else {
                throw new org.example.exception.RecordNotFoundException("No se encontró el cliente con el código: " + user.getCodigoCliente());
            }
        } else {
            return repository.save(user); // Crear un nuevo usuario con el código proporcionado por el usuario
        }
    }

     */

    //Logica para borrar a un cliente
    public User deleteUser(int CodigoCliente){
        Optional<User> user = repository.findById(CodigoCliente);
        if(user.isPresent()){
            repository.deleteById(CodigoCliente);
        }
        return user.get();
    }
}

