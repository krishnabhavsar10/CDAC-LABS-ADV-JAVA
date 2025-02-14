package fi.microuserservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fi.microuserservice.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}