package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.exceptions.GlobalException;
import es.netmind.mypersonalbankapi.modelos.prestamos.Prestamo;
import es.netmind.mypersonalbankapi.persistencia.IPrestamosRepo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/prestamos")
@Validated
@Tag(name = "Prestamos API", description = "Prestamos management APIs")
public class PrestamosControllerAPI {
    @Autowired
    private IPrestamosRepo repo;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Prestamo>> getLoansByClient(Integer id) throws Exception {
        if (repo.getLoansByClient(id).size() > 0) {
            return new ResponseEntity<>(repo.getLoansByClient(id), HttpStatus.OK);
        } else {
            throw new GlobalException("La lista de prestamos para el cliente está vacía");

        }
    }



}
