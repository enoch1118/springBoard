package testcode;

import com.enoch.domain.BoardVO;
import com.enoch.domain.Criteria;
import com.enoch.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/root-config.xml")
@Log4j
public class BoardServiceTest {
    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("서비스 타이틀");
        board.setWriter("서비스 작성자");
        board.setContent("서비스 내용");

        service.register(board);
        log.info("게시물번호:" + board.getBno());
    }

//    @Test
//    public void getListTest() {
//        List<BoardVO> list = service.getList();
//        list.forEach(board -> log.info(board));
//    }

    @Test
    public void getTest() {
        log.info(service.get(1L));
    }

    @Test
    public void deleteTest() {
        log.info(service.remove(1L));
    }

    @Test
    public void modifyTest() {
        BoardVO board = new BoardVO();
        board.setBno(2L);
        board.setTitle("서비스 업데이트 제목");
        board.setContent("서비스 업데이트 내용");
        board.setWriter("서비스 업데이트 작성자");

        log.info(service.modify(board));

    }

    @Test
    public void getListPageTest() {
        service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
    }
}
