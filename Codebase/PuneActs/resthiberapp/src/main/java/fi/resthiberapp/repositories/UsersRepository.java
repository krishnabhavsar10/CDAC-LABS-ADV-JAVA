package fi.resthiberapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fi.resthiberapp.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	
	@Query(nativeQuery = true,value="select * from users where username=:uname")
	public Users getUser(@Param("uname") String name);

}
