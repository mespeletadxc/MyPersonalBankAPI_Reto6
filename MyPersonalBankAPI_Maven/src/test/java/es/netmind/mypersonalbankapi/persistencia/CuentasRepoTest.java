package es.netmind.mypersonalbankapi.persistencia;

//import es.netmind.mypersonalbankapi.config.SpringConfigOLD;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {SpringConfigOLD.class})

class CuentasRepoTest {

    @Autowired
    private  ICuentasRepo repo;

     @Test
    void testBeans() {
        assertThat(repo, notNullValue());
    }
    @Test
    void getAll() {
    }

    @Test
    void getAccountById() {
    }

    @Test
    void addAccount() {
    }

    @Test
    void deleteAccount() {
    }

    @Test
    void updateAccount() {
    }

    @Test
    void getAccountsByClient() {
    }

    @Test
    void getAccountsByClientAndId() {
    }
}