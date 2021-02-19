package testcode;

import com.enoch.domain.BoardVO;
import com.enoch.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import com.enoch.mapper.BoardMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/root-config.xml")
@Log4j
public class mapperTest {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void mapperVOTest() {
        mapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void insertTest() {
        BoardVO board = new BoardVO();
        board.setTitle("새로작성");
        board.setContent("새로작성");
        board.setWriter("새로작성");
        mapper.insert(board);
        log.info(board);
    }

    @Test
    public void insertSelectKey() {
        BoardVO board = new BoardVO();
        board.setTitle("셀렉 새로작성");
        board.setContent("셀렉 새로작성");
        board.setWriter("셀렉 사람");

        mapper.insertSelectKey(board);

        log.info(board);
    }

    @Test
    public void readTest() {
        BoardVO board = mapper.read(5L);
        log.info(board);
    }

    @Test
    public void deleteTest() {
        log.info("delete count: " + mapper.delete(5L));
    }

    @Test
    public void updateTest() {
        BoardVO board = new BoardVO();
        board.setBno(6L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("수정된 작성자");

        int count = mapper.update(board);
        log.info("UPDATE COUNT : " + count);
    }

    @Test
    public void testPaging() {
        Criteria cri = new Criteria();
        cri.setPageNum(1);
        cri.setAmount(10);
        List<BoardVO> list = mapper.getListWithPaging(cri);
        list.forEach(board -> log.info(board));
    }
}
