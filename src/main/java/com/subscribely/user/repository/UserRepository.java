package com.subscribely.user.repository;

import com.subscribely.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public class UserRepository extends JpaRepository<User,Long>{

}