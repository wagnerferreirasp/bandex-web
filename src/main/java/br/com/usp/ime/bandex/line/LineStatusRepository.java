package br.com.usp.ime.bandex.line;

import org.springframework.data.repository.Repository;

/**
 * Repository class of the LineStatus.
 */
public class LineStatusRepository implements Repository<LineStatus, Long> {
    public LineStatus save(LineStatus lineStatus) {
        System.out.println("Fila salva! " + lineStatus);
        return lineStatus;
    }
}
