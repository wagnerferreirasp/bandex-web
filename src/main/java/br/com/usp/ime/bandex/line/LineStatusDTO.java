package br.com.usp.ime.bandex.line;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LineStatusDTO {
    private final int status;
    private final Long restaurantId;
}
