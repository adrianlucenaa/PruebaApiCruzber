package org.example.repository;

import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    /*

    //Query para que devuelva todos los usuarios
    @Query(value = "SELECT * FROM Clientes", nativeQuery = true)
    List<User> getAllUsers();

     */

}
