package dev.lest.GymRecorder.infrastructure.persistence.interfaces;

import dev.lest.GymRecorder.infrastructure.persistence.entitys.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity, Long> {
}
