package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Cliente {

    private int puerto;
    private String host;
    private Socket cliente;
    private DataOutputStream dos;
    private Connectable conn;

    public Cliente(Connectable conn) {
        try{
            this.conn = conn;
            puerto=2000;
            host="localhost";
        }catch(Exception e){
            System.err.println("Mensaje de error: " + e.getMessage());
        }
    }

    public void envia(File archivo) {
        try {
            cliente = new Socket(host,puerto);
            dos = new DataOutputStream(cliente.getOutputStream());
            System.out.println("Conexion establecida");
            conn.isRunning(true);
            String nombre = archivo.getName();
            long tamanio = archivo.length();
            String path = archivo.getAbsolutePath();
            System.out.println(nombre);
            System.out.println(path);
            DataInputStream dis = new DataInputStream(new FileInputStream(path));
            dos.writeUTF(nombre);
            dos.writeLong(tamanio);
            byte[] buffer = new byte[1500];   //MTU Ethernet
            long enviados = 0;
            int n = 0;
            int porcentaje = 0;
            while(enviados < tamanio) {
                n = dis.read(buffer);
                dos.write(buffer, 0, n);
                enviados += n;
                porcentaje = (int)(enviados*100/tamanio);
                System.out.print("\rTransmitido: " + porcentaje + "%");
            }
            dos.flush();
            dis.close();
            destruir();
            conn.isRunning(false);
        } catch(Exception e) {
            System.err.println("Mensaje de error: " + e.getMessage());
        }
    }

    public boolean envia(File[] archivos) {
        try {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    envia(archivo.listFiles());
                } else {
                    envia(archivo);
                }
                System.out.println("\nArchivo enviado");
            }
            return true;
        } catch (Exception e) {
            System.err.println("Mensaje de error: " + e.getMessage());
            return false;
        }
    }

    public void destruir() {
        try{
            dos.close();
            cliente.close();
            conn.isRunning(false);
        }catch(Exception e){
            System.err.println("Mensaje de error: " + e.getMessage());
        }
    }
}