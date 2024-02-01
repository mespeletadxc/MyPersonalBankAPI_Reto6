package es.netmind.mypersonalbankapi.persistencia;

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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnableAutoConfiguration
class ClientesRepositoryDataTest {

    @Autowired
    ClientesRepositoryData repo;

    /*@Autowired
    EntityManagerFactory emf;
    private EntityManager em;


    @BeforeEach
    void before() {
        em = emf.createEntityManager();
    }*/

    @Test
    void testBeans() {
        assertThat(repo, notNullValue());
    }
    @Test
    @Transactional
    void getAll() throws Exception {
        //List<Cliente> clientes = repo.getAll();
        List<Cliente> clientes = repo.findAll();
        System.out.println("Clientes:"+clientes.toString());
        System.out.println("Num Clientes:"+clientes.size());

        assertNotNull(clientes);
        assertThat(clientes.size(), greaterThan(0));
    }

    @Test
    @Transactional
    void getClientById() throws Exception {
        Optional<Cliente> op = repo.findById(1);
        Cliente cliemp = op.get();
        //Cliente cliemp = repo.getClientById(1);
        System.out.println("Cliente:"+cliemp);
        assertNotNull(cliemp);
    }

    @Test
    void addClient() {
    }

    @Test
    void saveEmpresa() throws Exception {
        //Empresa cliemp = new Empresa(null, "Servicios Informatico SL", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "J12345678", new String[]{"Dev", "Marketing"});

        Cliente cliemp = new Empresa(null, "Servicios Informatico SL", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "J12345678", new String[]{"Dev", "Marketing"});
        repo.save(cliemp);
        assertNotNull(cliemp);
        assertTrue(cliemp.getId() > 0);

        //Empresa ccliemp = em.find(Empresa.class, cliemp.getId());
        Cliente ccliemp = repo.getById(cliemp.getId());
        assertNotNull(ccliemp);
        assertEquals(ccliemp.getId(), cliemp.getId());



    }
   /* @Test
    void save() throws SQLException {
        Student newStd = new Student(null, "Matias", "Mattel", 2);
        System.out.println(newStd);
        repoStudents.save(newStd);
        Student aStudent = repoStudents.getById(newStd.getId());
        assertEquals(aStudent.getId(), newStd.getId());
    }*/

    @Test
    void savePersonal() throws Exception {

        Cliente cliper = new Personal(null, "Juan Juanez", "jj@j.com", "Calle JJ 1", LocalDate.now(), true, false, "12345678J");

        repo.save(cliper);
        assertNotNull(cliper);
        assertTrue(cliper.getId() > 0);

        Cliente ccliper = repo.getById(cliper.getId());
        assertNotNull(ccliper);
        assertEquals(ccliper.getId(), cliper.getId());

    }

    @Test
    void deleteClient() {
    }


    @Test
    //@Transactional
    void updateClient() throws Exception {
       // Cliente cliToChange = repo.getClientById(1);
        Cliente cliToChange = repo.getById(1);
        //Cliente cliToChange = em.find(Cliente.class, repo.getClientById(1));
        System.out.println("cliToChange:"+cliToChange.toString());
        Cliente cli = new Empresa(cliToChange.getId(), "Nuevo cliente 1", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "J12345678", new String[]{"Dev", "Marketing"});

        //Cliente cli = new Empresa(1, "Nuevo cliente", "si@s.com", "Calle SI 3", LocalDate.now(), true, false, "J12345678", new String[]{"Dev", "Marketing"});


        //Cliente cliC = repo.updateClient(cli);
        Cliente cliC = repo.save(cli);
        System.out.println("cli update:"+cliC);
        assertNotNull(cliC);
        assertEquals(cli.getNombre(), cliC.getNombre());
    }

    @Test
    void setEm() {
    }
}