package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepositoryData extends JpaRepository<Cliente, Integer> {
}
