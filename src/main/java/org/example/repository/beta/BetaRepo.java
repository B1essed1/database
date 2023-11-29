package org.example.repository.beta;

import org.example.domain.beta.BetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(value = "tb", propagation = Propagation.SUPPORTS)
public interface BetaRepo extends JpaRepository<BetaEntity, Long> {
}
