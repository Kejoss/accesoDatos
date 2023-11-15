package tema2.transporteKevinMoreno.mainKevinMoreno;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import tema2.transporteKevinMoreno.pojoKevinMoreno.*;

public class TransportesKevinMorenoTest {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("1- Listar todos los empleados, 2-Listar todo");
        System.out.println("3-Insertar nuevo empleado, 4-Insertar nueva localidad");
        System.out.println("5- Borrar empleado, 6-Mostrar empleado mas antiguo");
        System.out.println("7- Mostrar empleado que mas dinero gana, 8- Salir");
        int opr;

        while ((opr = sc.nextInt())!=8) {
            
            switch (opr) {
                case 1:
                    listarEmpleados();
                    break;
                case 2:
                    listarTodo();
                    break;
                case 3:
                    insertarEmpleado();
                    break;
                case 4:
                    insertarLocalidad();
                    break;
                case 5:
                    borrarEmpleado();
                    break;
                case 6:
                    mostrarEmpleadoAntiguo();
                    break;
                case 7:
                    mostarEmpleadoConMasDienero();
                    break;

                default:
                    System.out.println("Operador invalido");
                    break;
            }

            System.out.println("1- Listar todos los empleados, 2-Listar todo");
            System.out.println("3-Insertar nuevo empleado, 4-Insertar nueva localidad");
            System.out.println("5- Borrar empleado, 6-Mostrar empleado mas antiguo");
            System.out.println("7- Mostrar empleado que mas dinero gana, 8- Salir");
        }


    }

    private static Empleados cargarEmpleados(){
        try {
            
            JAXBContext contexto = JAXBContext.newInstance(Empleados.class);
            Unmarshaller um = contexto.createUnmarshaller();

            return (Empleados)um.unmarshal(new File("transporteKevinMoreno/xmlKevinMoreno/Empleado.xml"));
                   
        } catch (Exception e) {}

        return null;
    }

    private static Localidades cargarLocalidades(){
        try {
            
            JAXBContext contexto = JAXBContext.newInstance(Localidades.class);
            Unmarshaller um = contexto.createUnmarshaller();

            return (Localidades)um.unmarshal(new File("transporteKevinMoreno/xmlKevinMoreno/Localidad.xml"));
                   
        } catch (Exception e) {}

        return null;
    } 

    private static Regiones cargarRegiones(){
        try {
            
            JAXBContext contexto = JAXBContext.newInstance(Regiones.class);
            Unmarshaller um = contexto.createUnmarshaller();

            return (Regiones)um.unmarshal(new File("transporteKevinMoreno/xmlKevinMoreno/Region.xml"));
                   
        } catch (Exception e) {}

        return null;
    }

    private static Provincias cargarProvincias(){
        try {
            
            JAXBContext contexto = JAXBContext.newInstance(Provincias.class);
            Unmarshaller um = contexto.createUnmarshaller();

            return (Provincias)um.unmarshal(new File("transporteKevinMoreno/xmlKevinMoreno/Provincia.xml"));
                   
        } catch (Exception e) {}

        return null;
    }

    private static void listarEmpleados(){
        Empleados empleados = cargarEmpleados();
        for (Empleado empleado : empleados.getListaEmpleado()) {
            System.out.println(empleado);
        }
    }

    private static void listarTodo(){
        Localidades localidades = cargarLocalidades();
        Empleados empleados = cargarEmpleados();
        Provincias provincias = cargarProvincias();
        Regiones regiones = cargarRegiones();

        System.out.println("Localidades");
        
        for (Localidad localidad : localidades.getListaLocalidades()) {
            System.out.println(localidad);
        }

        System.out.println("Regiones");
        
        for (Region region: regiones.getListaRegiones()) {
            System.out.println(region);
        }

        System.out.println("Provincias");
        
        for (Provincia provincia : provincias.getListaProvincias()) {
            System.out.println(provincia);
        }

        System.out.println("Empleados");
        
        for (Empleado empleado : empleados.getListaEmpleado()) {
            System.out.println(empleado);
        }

    }

    private static void insertarEmpleado(){
        Empleados empleados = cargarEmpleados();
        
        System.out.println("Ingrese el id");
        String id = sc.next();
        System.out.println("Ingresa el DNI");
        String dni = sc.next();
        System.out.println("Ingresa el nombre");
        String nombre = sc.nextLine();
        sc.nextLine();
        System.out.println("Ingresa la fecha de nacimiento (dd/mm/aaaa)");
        String fechaNac = sc.next();
        System.out.println("Ingresa el numero de telefono");
        String telefono = sc.next();
        System.out.println("Ingresa el salario");
        double salario = sc.nextDouble();
        System.out.println("Ingresa el lugar de nacimiento (Localidad)");
        String localidad = sc.next();

        Empleado empleado = new Empleado(id, dni, nombre, fechaNac, telefono, salario, localidad);
        empleados.getListaEmpleado().add(empleado);

        Localidades localidades=cargarLocalidades();
        Localidad localidad2 = localidades.existeLocalidades(localidad);
        
        if (localidad2==null) {
            
            System.out.println("Ingresa el codigo de localidad");
            String codiLocalidad = sc.next();
            System.out.println("Ingresa el nombre de la provincia a la que pertenece");
            String nombreProvincia = sc.next();

            localidades.getListaLocalidades().add(new Localidad(localidad, codiLocalidad, nombreProvincia));

            Provincias provincias = cargarProvincias();
            Provincia provincia2 = provincias.existeProvincia(nombreProvincia);

            if (provincia2==null) {
                
                System.out.println("Ingresa el codigo de la provincia");
                String codProvincia = sc.next();
                System.out.println("¿A que region pertenece?");
                String nombreRegion = sc.next();

                Regiones regiones = cargarRegiones();
                Region region = regiones.existeRegion(nombreRegion);
                provincias.getListaProvincias().add(new Provincia(codProvincia, nombreProvincia, nombreRegion));

                if (region==null) {
                    System.out.println("Ingresa el codigo de la region");
                    String codRegion = sc.next();

                    regiones.getListaRegiones().add(new Region(codRegion, nombreRegion));
                    
                    try {
                    
                        JAXBContext context = JAXBContext.newInstance(Regiones.class);
                        Marshaller marshaller = context.createMarshaller();

                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                        marshaller.marshal(regiones, new File("transporteKevinMoreno/xmlKevinMoreno/Region.xml"));

                    } catch (Exception e) {}

                }

                try {
                    
                    JAXBContext context = JAXBContext.newInstance(Provincias.class);
                    Marshaller marshaller = context.createMarshaller();

                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                    marshaller.marshal(provincias, new File("transporteKevinMoreno/xmlKevinMoreno/Provincia.xml"));

                } catch (Exception e) {}
                

            }


            try {

                JAXBContext context = JAXBContext.newInstance(Localidades.class);
                Marshaller marshaller = context.createMarshaller();

                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                marshaller.marshal(localidades, new File("transporteKevinMoreno/xmlKevinMoreno/Localidad.xml"));

            } catch (Exception e) {}

        }

        try {
            
            JAXBContext context = JAXBContext.newInstance(Empleados.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(empleados, new File("transporteKevinMoreno/xmlKevinMoreno/Empleado.xml"));

        } catch (Exception e) {}
        
    }

    private static void borrarEmpleado(){
        Empleados empleados = cargarEmpleados();
        
        System.out.println("Ingrese el el DNI");
        String dni = sc.next();

        Empleado empleado =empleados.existeEmpleaado(dni);
        int cantidadEmpleados = empleados.sacarCantidadDeEmpleadosLocalidad(empleado.getLugarNacimiento());

        if (cantidadEmpleados==1) {
            Localidades localidades = cargarLocalidades();
            Localidad localidad = localidades.existeLocalidades(empleado.getLugarNacimiento());
            int cantidadesLocalidades = localidades.cantidadLocalidadesEnUnaProvincia(localidad.getProvincia());

            if (cantidadesLocalidades==1) {
                
                Provincias provincias = cargarProvincias();
                Provincia provincia = provincias.existeProvincia(localidad.getProvincia());
                int cantidadesProvincias= provincias.cantidadProvinciasEnUnaRegion(provincia.getRegion());

                if (cantidadesProvincias == 1) {
                    Regiones regiones = cargarRegiones();
                    regiones.eliminarRegion(provincia.getRegion());

                    try {
                        JAXBContext contextRegiones = JAXBContext.newInstance(Regiones.class);
                        Marshaller marshallerRegiones = contextRegiones.createMarshaller();

                        marshallerRegiones.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                        marshallerRegiones.marshal(empleados, new File("transporteKevinMoreno/xmlKevinMoreno/Region.xml"));
                    } catch (Exception e) {}
                }

                provincias.borrarProvincia(provincia.getNombreProvincia());

                try {
                    JAXBContext contextProvincias = JAXBContext.newInstance(Provincias.class);
                    Marshaller marshallerProvincias = contextProvincias.createMarshaller();

                    marshallerProvincias.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                    marshallerProvincias.marshal(provincias, new File("transporteKevinMoreno/xmlKevinMoreno/Provincia.xml"));

                } catch (Exception e) { }
            }

            localidades.borrarLocalidad(localidad.getNombre());

            try {
                JAXBContext contextLocalidades = JAXBContext.newInstance(Localidades.class);
                Marshaller marshallerLocalidades = contextLocalidades.createMarshaller();

                marshallerLocalidades.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                marshallerLocalidades.marshal(localidades, new File("transporteKevinMoreno/xmlKevinMoreno/Localidad.xml"));
            } catch (Exception e) {}

        }

        try {
            
            JAXBContext contextEmpleados = JAXBContext.newInstance(Empleados.class);           
            Marshaller marshallerEmpleados = contextEmpleados.createMarshaller();
            
            marshallerEmpleados.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshallerEmpleados.marshal(empleados, new File("transporteKevinMoreno/xmlKevinMoreno/Empleado.xml"));

        } catch (Exception e) {}

    }

    private static void insertarLocalidad(){
        System.out.println("Ingresa el codigo de la localidad");
        String codLocalidad = sc.next();
        System.out.println("Ingresa el nombre");
        String nombre = sc.next();
        System.out.println("¿A que provincia pertenece?");
        String provincia = sc.next();

        Localidad localidad = new Localidad(nombre, codLocalidad,provincia);
        Localidades localidades = cargarLocalidades();
        localidades.getListaLocalidades().add(localidad);

        Provincias provincias = cargarProvincias();
        Provincia provincia2 = provincias.existeProvincia(provincia);

        if (provincia2==null) {
            
            System.out.println("Ingresa el codigo de la provincia");
            String codProvincia = sc.next();
            System.out.println("¿A que region pertenece?");
            String nombreRegion = sc.next();

            Regiones regiones = cargarRegiones();
            Region region = regiones.existeRegion(nombreRegion);
            provincias.getListaProvincias().add(new Provincia(codProvincia, provincia, nombreRegion));

            if (region==null) {
                System.out.println("Ingresa el codigo de la region");
                String codRegion = sc.next();

                regiones.getListaRegiones().add(new Region(codRegion, nombreRegion));
                
                try {
                
                    JAXBContext context = JAXBContext.newInstance(Regiones.class);
                    Marshaller marshaller = context.createMarshaller();

                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                    marshaller.marshal(regiones, new File("transporteKevinMoreno/xmlKevinMoreno/Region.xml"));

                } catch (Exception e) {}

            }

            try {
                
                JAXBContext context = JAXBContext.newInstance(Provincias.class);
                Marshaller marshaller = context.createMarshaller();

                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
                marshaller.marshal(provincias, new File("transporteKevinMoreno/xmlKevinMoreno/Provincia.xml"));

            } catch (Exception e) {}
            

        }

        try {
            
            JAXBContext context = JAXBContext.newInstance(Localidades.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(localidades, new File("transporteKevinMoreno/xmlKevinMoreno/Localidad.xml"));

        } catch (Exception e) {}

    }

    private static void mostrarEmpleadoAntiguo(){
        Empleados empleados = cargarEmpleados();

        DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDate fechaMaayor = LocalDate.now();
        Empleado empleadoMayor = null;

        for (Empleado empleado : empleados.getListaEmpleado()) {
            
            if (fechaMaayor.isAfter(LocalDate.parse(empleado.getFechaNac(),dFormatter))) {
                fechaMaayor = LocalDate.parse(empleado.getFechaNac(),dFormatter);
                empleadoMayor = empleado;
            }    
        }

        System.out.println("El empleado mayor es: "+empleadoMayor.getNombre()+ " su fecha de nacimiento es: "+empleadoMayor.getFechaNac());

    }

    private static void mostarEmpleadoConMasDienero(){
        Empleados empleados = cargarEmpleados();
        Empleado enpleadoConMasSalario = null;
        double salario =0;
        for (Empleado empleado : empleados.getListaEmpleado()) {
            if (salario<empleado.getSalario()) {
                salario = empleado.getSalario();
                enpleadoConMasSalario = empleado;
            }
        }

        System.out.println("El empleado con mas salario es: "+enpleadoConMasSalario.getNombre()+" su salario es de: "+enpleadoConMasSalario.getSalario());
    }

}
