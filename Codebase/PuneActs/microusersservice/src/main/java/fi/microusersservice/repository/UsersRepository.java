package fi.microusersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fi.microusersservice.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}
