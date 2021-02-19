package com.enoch.service;

import com.enoch.domain.BoardVO;
import com.enoch.domain.Criteria;

import java.util.List;

public interface BoardService {
    void register(BoardVO board);

    BoardVO get(Long bno);

    boolean modify(BoardVO board);

    boolean remove(Long bno);

    //    List<BoardVO> getList();
    public List<BoardVO> getList(Criteria cri);
}
