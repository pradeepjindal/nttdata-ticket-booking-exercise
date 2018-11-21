package org.prajin.ex.nttdata.flightticketing.model;

import lombok.Data;

@Data
public class ResponseDto <T> {
    private String status;
    private String message;
    private T payload;

    public ResponseDto(String status, String message) {
        this(status, message, null);
    }

    public ResponseDto(String status, String message, T payload) {
        this.status = status;
        this.message = message;
        this.payload = payload;
    }
}
