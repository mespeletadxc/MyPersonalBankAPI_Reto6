package es.netmind.mypersonalbankapi.persistencia;

import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Empresa;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;

import java.util.List;

public interface IClientesRepo {
    public List<Cliente> getAll() throws Exception;

    public Cliente getClientById(Integer id) throws Exception;

    public Cliente addClient(Cliente cliente) throws Exception;

    public Empresa addClientEmpresa (Empresa cliente) throws Exception;
    public Personal addClientPersonal (Personal cliente) throws Exception;

    public boolean deleteClient(Cliente cliente) throws Exception;

    public Cliente updateClient(Cliente cliente) throws Exception;

}
