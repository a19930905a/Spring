package spring.beans.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository("repository")
public class UserRepositoryimpl implements UserRepository {

	@Override
	public void save() {
		System.out.println("UserRepository save...");
	}

}
