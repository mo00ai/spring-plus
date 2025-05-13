package org.example.expert.domain.log.repository;

import org.example.expert.domain.log.entity.Log;
import org.example.expert.domain.manager.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
