package com.server.boardd.domain.board.dto.request;

public record PostRequest(

        String title,
        String author,
        String content

) {
}
