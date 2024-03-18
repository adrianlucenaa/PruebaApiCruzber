package org.example.controllers;

import org.example.Services.UserService;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


    //Devuelve todos los clientes
    @GetMapping
    public List<User> getAll(){
        return service.getAllUsers();
    }

    //Devuelve un Cliente por CodigoCliente
    @GetMapping("/{CodigoCliente}")
    public Optional<User> getUser(@PathVariable int CodigoCliente){
        return service.getUser(CodigoCliente);
    }

    //Crea o actualiza un cliente
   @PostMapping
    public User createOrUpdateUser(@RequestBody User user){
        return service.createOrUpdateUser(user);
    }

    //Borra un cliente
    @DeleteMapping("/{CodigoCliente}")
    public User deleteUser(@PathVariable int CodigoCliente){
        return service.deleteUser(CodigoCliente);
    }
}
