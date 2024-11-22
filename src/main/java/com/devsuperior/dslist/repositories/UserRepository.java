package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
