package tema3.practica.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.basex.core.Context;
import org.basex.core.cmd.XQuery;
import org.basex.query.QueryException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.json.JSONObject;
import org.json.XML;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    private static int PRETTY_PRINT_INDENT_FACTOR=4;

    public static void main(String[] args) {
        
        try {

            File fileProductos = new File("tema3/practica/xml/ProductosStock.xml");
            File fileEmpleados = new File("tema3/practica/xml/Empleados.xml");

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            
            Document documentoProductos = documentBuilder.parse(fileProductos);
            Document documentoEmpleados = documentBuilder.parse(fileEmpleados);

            Element nodoRaizEmpleados = documentoEmpleados.getDocumentElement();
            Element nodoRaizProductos = documentoProductos.getDocumentElement();            

            System.out.println("1- Listar todos los productos en stock"+"\n"+
            "2- Mostrar el nombre de los empleados disponibles en cada cargo"+"\n"+
            "3- Dar de baja Empleado"+"\n"+
            "4- Agregar productos a la lista de Stock"+"\n"+
            "5- Salir");
            int opr;

            while ((opr = sc.nextInt()) != 5) {
                
                switch (opr) {
                    case 1:
                        
                        listarProductos();

                        break;
                    case 2:
                        mostarNombreEmpleados();
                        break;
                    case 3:
                        
                        System.out.println("Ingresa el id del empleado");
                        String idEmpleado = sc.next();

                        NodeList listaEmpleados = nodoRaizEmpleados.getElementsByTagName("empleado");
                        for (int i = 0; i < listaEmpleados.getLength(); i++) {
                            
                            Element empleadoActual = (Element)listaEmpleados.item(i);
                            if(empleadoActual.getAttribute("id").equalsIgnoreCase(idEmpleado)){
                                empleadoActual.getParentNode().removeChild(empleadoActual);
                            }
                        }

                        System.out.println("Se ha dado de baja correctamente al empleado");
                        
                        guardarDocumento(documentoEmpleados, fileEmpleados);

                        break;
                    case 4:
                        
                        int codigo = nodoRaizProductos.getElementsByTagName("producto").getLength()+1;
                        System.out.println("Ingresa el nombre del producto");
                        String nombreProducto = sc.next();
                        System.out.println("Ingresa la cantidad del stock");
                        String cantidadProducto = sc.next();
                        System.out.println("Ingesa el precio de venta por paquete");
                        String precioProducto = sc.next();

                        Element elementProducto = documentoProductos.createElement("producto");
                        Element elementNombre = documentoProductos.createElement("nombre");
                        Element elementCantidad = documentoProductos.createElement("cantidad");
                        Element elementPrecio = documentoProductos.createElement("precio");
        
                        elementProducto.setAttribute("codigo", Integer.toString(codigo++));
                        elementNombre.appendChild(documentoProductos.createTextNode(nombreProducto));
                        elementCantidad.appendChild(documentoProductos.createTextNode(cantidadProducto));
                        elementPrecio.appendChild(documentoProductos.createTextNode(precioProducto));

                        elementProducto.appendChild(elementNombre);
                        elementProducto.appendChild(elementCantidad);
                        elementProducto.appendChild(elementPrecio);

                        documentoProductos.getElementsByTagName("Productos").item(0).appendChild(elementProducto);

                        guardarDocumento(documentoProductos, fileProductos);

                        break;
                
                    default:
                        break;
                }

                System.out.println("1- Listar todos los productos en stock"+"\n"+
                "2- Mostrar el nombre de los empleados disponibles en cada cargo"+"\n"+
                "3- Dar de baja Empleado"+"\n"+
                "4- Agregar productos a la lista de Stock"+"\n"+
                "5- Salir");

            }




        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (QueryException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    private static void listarProductos()throws IOException, QueryException {

        Context context = new Context();
        String consulta = "for $x in doc('tema3/practica/xml/ProductosStock.xml')//producto return concat('Nombre: ',data($x/nombre),'   Cantidad en stock: ',data($x/cantidad))";
        System.out.println(new XQuery(consulta).execute(context)+"\n"); 

        String query = "for $x in doc('tema3/practica/xml/ProductosStock.xml')//producto return $x";
        String queryToJsoString = new XQuery(query).execute(context); 

        JSONObject json = XML.toJSONObject(queryToJsoString);
        String jsoString = json.toString(PRETTY_PRINT_INDENT_FACTOR);

        Path pathJson = Paths.get("tema3/practica/json/ProductosStock.json");
        Files.write(pathJson, jsoString.getBytes());


    }

    private static void mostarNombreEmpleados()throws IOException, QueryException{
        Context context = new Context();
        System.out.println("Ingresa el cargo: (RRHH, Informatico, Productores)");
        String cargo = sc.next();
        String consulta = "for $x in doc('tema3/practica/xml/Empleados.xml')//empleado where $x/@cargo = '"+cargo+"' return concat('id: ',data($x/@id),' ',data($x/nombre),' ',data($x/apellidos))";
        System.out.println("\n"+ new XQuery(consulta).execute(context)+"\n");
                
        String query = "for $x in doc('tema3/practica/xml/Empleados.xml')//empleado where $x/@cargo = '"+cargo+"' return $x";
        String queryToJsoString = new XQuery(query).execute(context); 

        JSONObject json = XML.toJSONObject(queryToJsoString);
        String jsoString = json.toString(PRETTY_PRINT_INDENT_FACTOR);

        Path pathJson = Paths.get("tema3/practica/json/Empleados.json");
        Files.write(pathJson, jsoString.getBytes());

    }


    private static void guardarDocumento(Document document, File file)throws IOException, TransformerException{

        DOMSource domSource = new DOMSource(document);
        FileWriter fileWriter = new FileWriter(file);

        StreamResult streamResult = new StreamResult(fileWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, streamResult);

        fileWriter.close();
   }

}
