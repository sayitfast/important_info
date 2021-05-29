package com.sayitfast.important_info.repositories;

import com.sayitfast.important_info.models.App_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<App_User, Integer> {

    App_User findByUsername(String username);
}
