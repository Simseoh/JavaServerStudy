package com.server.boardd.domain.board.exception.impl;

import com.server.boardd.domain.board.exception.BoardExceptionDetails;
import com.server.boardd.global.exception.CustomException;

public class IdNotFound extends CustomException {
    private IdNotFound() {super(BoardExceptionDetails.ID_NOT_FOUND);}

    public static final IdNotFound INSTANCE = new IdNotFound();
}
