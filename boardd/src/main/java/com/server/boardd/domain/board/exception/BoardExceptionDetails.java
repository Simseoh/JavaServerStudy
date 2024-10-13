package com.server.boardd.domain.board.exception;

import com.server.boardd.global.exception.ExceptionDetail;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BoardExceptionDetails implements ExceptionDetail {
    ID_NOT_FOUND(HttpStatus.BAD_REQUEST, "id not found in database"),
    ;

    private final HttpStatus status;
    private final String detail;

    @Override
    public HttpStatus getHttpStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return name();
    }

    @Override
    public String getDetail() {
        return detail;
    }
}

