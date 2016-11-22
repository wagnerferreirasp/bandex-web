package br.com.usp.ime.bandex.repository;

import br.com.usp.ime.bandex.entity.Line;

import java.util.Calendar;

/**
 * Repository class of the Line.
 */
public class LineRepository {
    public Line save(Line line) {
        System.out.println("Fila salva! " + line);
        return line;
    }
}
