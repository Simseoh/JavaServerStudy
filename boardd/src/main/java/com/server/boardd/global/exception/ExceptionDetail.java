package com.server.boardd.global.exception;

import org.springframework.http.HttpStatus;

public interface ExceptionDetail {
    HttpStatus getHttpStatus();
    String getMessage();
    String getDetail();
}

