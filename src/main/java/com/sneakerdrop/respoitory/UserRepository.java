package com.sneakerdrop.respoitory;

import com.sneakerdrop.datamodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
