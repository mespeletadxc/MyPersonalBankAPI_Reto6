package es.netmind.mypersonalbankapi.controladores;


import es.netmind.mypersonalbankapi.exceptions.ClientNotfoundException;
import es.netmind.mypersonalbankapi.exceptions.ClienteException;
import es.netmind.mypersonalbankapi.exceptions.ErrorCode;
import es.netmind.mypersonalbankapi.modelos.StatusMessage;
import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import es.netmind.mypersonalbankapi.modelos.clientes.Personal;
import es.netmind.mypersonalbankapi.persistencia.ClientesDBRepoJPA;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@RequestMapping("/clientes")
@Validated
@Tag(name = "Clientes API", description = "Clientes management APIs")
public class ClientesControllerAPI {
    private static final Logger logger = LoggerFactory.getLogger(ClientesControllerAPI.class);

    @Autowired
    private ClientesDBRepoJPA repo;

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Cliente>> getAll() {
        if (repo.getAll().size() > 0) {
            return new ResponseEntity<>(repo.getAll(), HttpStatus.OK);
        } else {
            throw new ClientNotfoundException("La lista de clientes está vacía");
        }
    }

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Personal> save(@RequestBody @Valid Personal newClient) {
        logger.info("newClient:" + newClient);
        newClient.setId(null);
        return new ResponseEntity<>(repo.addClientPersonal(newClient), HttpStatus.CREATED);
    }

    //    @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
//            @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
//    })
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Cliente getOne(
            @Parameter(name = "id", description = "Client id", example = "1", required = true)
            @PathVariable("pid") @Min(1) Integer id
    ) {
        return repo.getClientById(id);
    }
//
//    @RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
//    public ResponseEntity delete(@PathVariable("pid") @Min(1) Long id) {
//        repo.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    //    @RequestMapping(value = "/{pid}", method = RequestMethod.PUT)
//    @PutMapping(value = "/{pid}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<Object> update(@PathVariable("pid") @Min(1) Long id, @RequestBody Product product) {
//        if (id == product.getId()) {
//            return new ResponseEntity<>(repo.save(product), HttpStatus.ACCEPTED);
//        } else {
//            return new ResponseEntity<>(new StatusMessage(HttpStatus.PRECONDITION_FAILED.value(), "Id y produt.id deben cohincidir"), HttpStatus.PRECONDITION_FAILED);
//        }
//    }
//
//    @PostMapping(value = "/duplicarProducto/{pid}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<Product> duplicate(@PathVariable @Min(1) Long pid) {
//        return new ResponseEntity<>(service.duplicate(pid), HttpStatus.CREATED);
//    }

}


