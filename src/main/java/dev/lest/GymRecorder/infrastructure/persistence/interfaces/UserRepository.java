package dev.lest.GymRecorder.infrastructure.persistence.interfaces;

import dev.lest.GymRecorder.infrastructure.persistence.entitys.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    boolean existsById(Long id);
    boolean existsByEmail(String email);

}
