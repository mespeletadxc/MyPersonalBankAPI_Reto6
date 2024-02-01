package es.netmind.mypersonalbankapi.controladores;

import es.netmind.mypersonalbankapi.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class ClientesControllerDataTest {

    /*@Autowired
    private ClientesController service;*/
    @Autowired
    IClientesController service;

    @Test
    void testBeans() {
        assertNotNull(service);
    }

    @Test
    void mostrarLista() throws Exception {
        service.mostrarLista();
    }

    @Test
    void mostrarDetalle(){
        service.mostrarDetalle(1);
    }

    @Test
    void actualizar() {
        service.actualizar(1, new String[]{"a","nuevo@email","b", String.valueOf(LocalDate.now()),"c","d,e","",""});
    }

}