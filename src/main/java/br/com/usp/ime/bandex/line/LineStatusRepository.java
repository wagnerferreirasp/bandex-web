package br.com.usp.ime.bandex.line;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class of the LineStatus.
 */
@Repository
public interface LineStatusRepository extends JpaRepository<LineStatus, Long> {
}
