package br.com.usp.ime.bandex.line;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class of the LineStatus.
 */
@Repository
public interface LineStatusRepository extends CrudRepository<LineStatus, Long> {
}
