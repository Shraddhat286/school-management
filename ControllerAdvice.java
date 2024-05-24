package com.shd.newSchoolManagement.web.rest.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;


@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = BadRequestAlertException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleExceptionHandler(BadRequestAlertException e) {
        return new ErrorDetails(HttpStatus.BAD_REQUEST, LocalDateTime.now(), e.getLocalizedMessage(), "Bad Request");
    }

    class ErrorDetails {
        private HttpStatus status;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDateTime timestamp;
        private String message;
        private String details;

        public ErrorDetails() {

        }

        public ErrorDetails(HttpStatus status, LocalDateTime timestamp, String message, String details) {
            super();
            this.status = status;
            this.timestamp = timestamp;
            this.message = message;
            this.details = details;
        }
        public HttpStatus getStatus() {
            return status;
        }

        public void setStatus(HttpStatus status) {
            this.status = status;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

    }

}