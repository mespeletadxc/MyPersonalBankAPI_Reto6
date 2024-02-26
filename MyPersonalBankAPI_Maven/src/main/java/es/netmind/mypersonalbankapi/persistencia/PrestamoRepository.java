package es.netmind.mypersonalbankapi.persistencia;


import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    //List<Prestamo> findByOwnerId(Long OwnerId);
    public List<Prestamo> getLoansById(Integer uid) throws Exception;


}
