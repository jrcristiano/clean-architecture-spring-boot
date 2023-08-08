package com.api.innovation.infra.config.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private String message;
    private int status;

    public ResponseDTO(String message, int status) {
        super();
        this.message = message;
        this.status = status;
    }

    public ResponseDTO() {
        super();
    }
}
