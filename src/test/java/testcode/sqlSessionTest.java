package testcode;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/root-config.xml")
@Log4j
public class sqlSessionTest {
    @Setter(onMethod_ = @Autowired)
    private DataSource dataSource;

    @Setter(onMethod_ = @Autowired)
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testMyBatis() {
        try (SqlSession sql = sqlSessionFactory.openSession();
             Connection conn = sql.getConnection()) {
            log.info(sql);
            log.info(conn);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
