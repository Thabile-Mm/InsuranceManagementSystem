package com.qda.InsuranceManagementAPI.repository;

import com.qda.InsuranceManagementAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String email);
}
