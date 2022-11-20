package data;

import model.Articulo;
import model.Cliente;
import model.Libreria;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
    public class GestorDatos {
        public static Libreria leerArchivoArticulos(Libreria libreria, String direccionArchivo) {
            String textoArchivo = "";

            try {
                File archivo = new File(direccionArchivo);
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                //Lee cada linea del archivo hasta que la linea sea nula
                while ((textoArchivo = br.readLine()) != null) {
                    String[] data = textoArchivo.split(",");
                    libreria.getArticulos().add(new Articulo(data[0], data[1], data[2]));
                }
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println("Documento no disponible, favor contactar con administrador");
            }
            return libreria;
        }

        public static Libreria leerArchivoCliente(Libreria libreria, String direccionArchivo) {
            String textoArchivo = "";
            try {
                File archivo = new File(direccionArchivo);
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while ((textoArchivo = br.readLine()) != null) {
                    String[] data = textoArchivo.split(",");
                    libreria.getClientes().add(new Cliente(data[0]));
                }
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println("Documento no disponible, favor contactar con administrador");
            }
            return libreria;
        }

        public static boolean registrarDato(Object objeto, String direccionArchivo) {
            boolean lineaVacia = false;
            try {
                File file = new File(direccionArchivo);
                if (!file.exists()) {
                    file.createNewFile();
                    lineaVacia = true;
                }
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                if (lineaVacia == false) {
                    bw.newLine();
                }
                bw.write(objeto.toString());

                bw.close();
                fw.close();
                return true;
            } catch (Exception e) {
                System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
                return false;
            }
        }

        public static boolean registrarDatos(List objetos, String direccionArchivo) {
            try {
                File file = new File(direccionArchivo);
                if (Files.deleteIfExists(Paths.get("C:\\Users\\" + direccionArchivo))) {
                    System.out.println("El fichero ha sido borrado satisfactoriamente");
                } else {
                    System.out.println("El fichero no puede ser borrado");
                }
                File fichero = new File(direccionArchivo);
                fichero.createNewFile();
                FileWriter fw = new FileWriter(fichero, true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Object objeto : objetos) {
                    bw.write(objeto.toString());
                    bw.newLine();
                }
                bw.close();
                fw.close();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
