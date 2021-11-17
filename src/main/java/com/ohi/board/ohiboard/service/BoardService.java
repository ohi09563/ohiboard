package com.ohi.board.ohiboard.service;

import com.ohi.board.ohiboard.domain.board.Board;
import com.ohi.board.ohiboard.domain.board.BoardRepository;
import com.ohi.board.ohiboard.domain.user.User;
import com.ohi.board.ohiboard.dto.board.BoardSaveRequestDto;
import com.ohi.board.ohiboard.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto, User user) {
        boardSaveRequestDto.setUser(user);
        return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
    }

    /**
     * 글목록 로직
     * @return
     */
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    /**
     * 글상세 로직
     */
    @Transactional(readOnly = true)
    public Board detail(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
    }

    /**
     * 글삭제 로직
     */
    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    /**
     * 글목록 로직
     */
    @Transactional(readOnly = true)
    public Page<Board> findAll(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }

    /**
     * 글수정 로직
     */
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
        board.update(boardUpdateRequestDto.getTitle(), boardUpdateRequestDto.getContent());
        return id;
    }






    /**
     * 글목록 로직
     */
    @Transactional(readOnly = true)
    public Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable) {
        return boardRepository.findByTitleContainingOrContentContaining(title, content, pageable);
    }




    public void updateCount(Long id) {
    }
}