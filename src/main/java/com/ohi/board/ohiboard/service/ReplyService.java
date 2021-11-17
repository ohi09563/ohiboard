package com.ohi.board.ohiboard.service;

import com.ohi.board.ohiboard.domain.Reply.Reply;
import com.ohi.board.ohiboard.domain.Reply.ReplyRepository;
import com.ohi.board.ohiboard.domain.board.Board;
import com.ohi.board.ohiboard.domain.board.BoardRepository;
import com.ohi.board.ohiboard.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void replySave(Long boardId, Reply reply, User user) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("해당 boardId가 없습니다. id=" + boardId));

        reply.save(board, user);

        replyRepository.save(reply);
    }


    @Transactional
    public void replyDelete(Long replyId) {
        replyRepository.deleteById(replyId);
    }
}