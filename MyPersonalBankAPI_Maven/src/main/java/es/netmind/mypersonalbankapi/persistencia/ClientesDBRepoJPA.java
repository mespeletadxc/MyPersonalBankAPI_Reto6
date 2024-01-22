package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Repository
public class ClientesDBRepoJPA implements IClientesRepo {

    @PersistenceContext // Accede al emf; emf.createEntityManager();
    EntityManager em;

    //@Transactional
    @Override
    public List<Cliente> getAll() throws RuntimeException {
        return em.createQuery("SELECT s FROM Cliente s", Cliente.class).getResultList();
    }

    @Override
        public Cliente getClientById(Integer id) throws Exception {
        return em.find(Cliente.class, id);
    }

    @Override
    public Cliente addClient(Cliente cliente) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public Empresa addClientEmpresa(Empresa cliente) throws Exception{
        em.persist(cliente);
        return cliente;
    }

    @Override
    @Transactional
    public Personal addClientPersonal(Personal cliente) throws Exception{
        em.persist(cliente);
        return cliente;
    }


    @Override
    public boolean deleteClient(Cliente cliente) throws Exception {
        return false;
    }

    @Override
    @Transactional
    public Cliente updateClient(Cliente cliente) {
        Cliente cli = em.find(Cliente.class, cliente.getId());

        cli.setNombre(cliente.getNombre());
        //cli.setEstudiantes(escuela.getEstudiantes());
        return cli;
    }
}
