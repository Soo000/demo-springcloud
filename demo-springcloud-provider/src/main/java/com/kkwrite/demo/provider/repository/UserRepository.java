package com.kkwrite.demo.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kkwrite.demo.provider.pojo.UserDO;

public interface UserRepository extends JpaRepository<UserDO, Long> {
    
    UserDO findByUserId(Long userId);
    
    @Query(value = "select count(*) from user", nativeQuery=true)
	int getUserCount();
    
}
