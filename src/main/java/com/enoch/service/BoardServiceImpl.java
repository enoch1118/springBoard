package com.enoch.service;

import com.enoch.domain.BoardVO;
import com.enoch.domain.Criteria;
import com.enoch.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("getservice>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify service>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("deleteservice>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList(Criteria cri) {
        log.info("getlist service>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(cri);
        return mapper.getListWithPaging(cri);
    }
}
