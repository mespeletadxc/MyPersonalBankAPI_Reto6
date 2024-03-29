package es.netmind.mypersonalbankapi;


import es.netmind.mypersonalbankapi.config.SpringConfig;
import es.netmind.mypersonalbankapi.controladores.IClientesController;
import es.netmind.mypersonalbankapi.modelos.clientes.Cliente;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //context.getEnvironment().setActiveProfiles("dev");
        context.register(SpringConfig.class);
        context.refresh();

        IClientesController servicioClientes = context.getBean(IClientesController.class);

        //Cliente unCliente = null;
        try {
            servicioClientes.mostrarDetalle(1);

            //System.out.println(unCliente);

//            Cliente otroEstudiante = servicioEstudiantes.getStudentById(3L);
//            System.out.println(otroEstudiante);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
