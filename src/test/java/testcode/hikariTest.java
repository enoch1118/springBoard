package testcode;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/root-config.xml")
@Log4j
public class hikariTest {
    @Setter(onMethod_ = @Autowired)
    private DataSource dataSource;

    @Test
    public void testConn() {
        try (Connection conn = dataSource.getConnection()) {
            log.info(conn);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
