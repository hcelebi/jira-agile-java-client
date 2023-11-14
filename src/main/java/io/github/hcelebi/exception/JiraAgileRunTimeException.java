package io.github.hcelebi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;

@Getter
@AllArgsConstructor
public class JiraAgileRunTimeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -3829641624015437540L;

    public JiraAgileRunTimeException(String message) {
        super(message);
    }
}
