package es.netmind.mypersonalbankapi.persistencia;

import com.mysql.cj.xdevapi.Client;
import es.netmind.mypersonalbankapi.config.SpringConfig;
import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnableAutoConfiguration
class ClientesDBRepoJPATest {

    @Autowired
    private IClientesRepo repo;

    @Autowired
    EntityManagerFactory emf;

    private EntityManager em;


    @BeforeEach
    void before() {
        em = emf.createEntityManager();
    }

    @Test
    void getAll() throws Exception {
        List<Cliente> clientes = repo.getAll();
        System.out.println("Clientes:"+clientes.toString());
        System.out.println("Num Clientes:"+clientes.size());

        assertNotNull(clientes);
        assertThat(clientes.size(), greaterThan(0));
    }

    @Test
    void getClientById() throws Exception {
        Cliente cliemp = repo.getClientById(1);
        System.out.println("Cliente:"+cliemp);
        assertNotNull(cliemp);
    }

    @Test
    void addClient() {
    }

    @Test
    void addClientEmpresa() throws Exception {
        Empresa cliemp = new Empresa(null, "Servicios Informatico SL", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "J12345678", new String[]{"Dev", "Marketing"});
        repo.addClientEmpresa(cliemp);
        assertNotNull(cliemp);
        assertTrue(cliemp.getId() > 0);

        Empresa ccliemp = em.find(Empresa.class, cliemp.getId());
        assertNotNull(ccliemp);
        assertEquals(ccliemp.getId(), cliemp.getId());

    }

    @Test
    void addClientPersonal() throws Exception {

        Personal cliper = new Personal(null, "Juan Juanez", "jj@j.com", "Calle JJ 1", LocalDate.now(), true, false, "12345678J");

        repo.addClientPersonal(cliper);
        assertNotNull(cliper);
        assertTrue(cliper.getId() > 0);

        Personal ccliper = em.find(Personal.class, cliper.getId());
        assertNotNull(ccliper);
        assertEquals(ccliper.getId(), cliper.getId());

    }

    @Test
    void deleteClient() {
    }

    @Test
    void updateClient() {
    }

    @Test
    void setEm() {
    }
}