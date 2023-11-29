package org.example.repository.alpha;

import org.example.domain.alpha.Alpha2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(value = "ta", propagation = Propagation.SUPPORTS)
public interface Alpha2Repo extends JpaRepository<Alpha2Entity, Long> {
}
