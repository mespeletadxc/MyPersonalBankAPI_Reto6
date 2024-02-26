package es.netmind.mypersonalbankapi.persistencia;


import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PrestamosDBRepoJPA implements IPrestamosRepo {

    @PersistenceContext // Accede al emf; emf.createEntityManager();
    EntityManager em;

    //@Transactional
    @Override
    public List<Prestamo> getAll() throws RuntimeException {
        return em.createQuery("SELECT s FROM Prestamo s", Prestamo.class).getResultList();
    }

    @Override
    public Prestamo getLoanById(Integer id) throws Exception {
        return em.find(Prestamo.class, id);
    }

    @Override
    public Prestamo addLoan(Prestamo prestamo) throws Exception {
        em.persist(prestamo);
        return prestamo;
    }

    @Override
    public boolean deleteLoan(Prestamo prestamo) throws Exception {
        return false;
    }

    @Override
    public Prestamo updateLoan(Prestamo prestamo) throws Exception {
        return null;
    }

    @Override
    public List<Prestamo> getLoansByClient(Integer uid) throws Exception {
        List<Prestamo> prestamos = +.findByOwnerId(ownerId);

    }

    @Override
    public Prestamo getLoansByClientAndId(Integer uid, Integer aid) throws Exception {
        List<Prestamo> accounts = accountRepository.findByOwnerId(ownerId);
    }


}