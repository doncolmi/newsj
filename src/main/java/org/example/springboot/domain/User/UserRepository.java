package org.example.springboot.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUid(String uid);
    User findByEmail(String email);
    User findByEmailAndUid(String email, String id);
    int countByUid(String uid);
    int countByEmail(String email);
    int countByUidAndPassword(String uid, String pw);

}
