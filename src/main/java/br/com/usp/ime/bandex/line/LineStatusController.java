package br.com.usp.ime.bandex.line;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The LineStatusController
 */

@RestController
public class LineStatusController {

    @Autowired
    private LineStatusService lineStatusService;

    @PostMapping("post_line_status")
    public ResponseEntity<String> sendLine(@RequestBody LineStatusDTO lineStatusDTO) {
        lineStatusService.save(lineStatusDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sucesso!");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> handleException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
