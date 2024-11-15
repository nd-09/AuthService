package com.user.authservice.repositories;

import com.user.authservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositiry extends JpaRepository<User, Long> {

}
