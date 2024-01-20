package com.devsuperior.DScommercenovo.repositories;

import com.devsuperior.DScommercenovo.entities.Product;
import com.devsuperior.DScommercenovo.entities.User;
import com.devsuperior.DScommercenovo.projections.UserDetailsProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT tb_user.email AS username, password, tb_role.id AS roleId, tb_role.authority " +
            "FROM tb_user_role " +
            "INNER JOIN tb_user ON tb_user_role.user_id = tb_user.id " +
            "INNER JOIN tb_role ON tb_user_role.role_id = tb_role.id " +
            "WHERE email = :email")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

    Optional<User> findByEmail(String email);

}
