package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private int puerto;
    private ServerSocket servidor;
    private Socket cliente;
    private DataInputStream dis;
    private Imprimible filas;
    private String mensaje;

    public Servidor(Imprimible filas) {
        this.filas = filas;
        mensaje = new String("");
        puerto = 2000;
        try {
            servidor = new ServerSocket(puerto);
            filas.isConnectedToServer(true);
        } catch (Exception e) {
            System.err.println("Mensaje de error: " + e.getMessage());
        }
    }

    public boolean aceptaConexion() {
        try {
            cliente=servidor.accept();
            dis=new DataInputStream(cliente.getInputStream());
            mensaje = "Cliente conectado desde " + cliente.getInetAddress().getHostAddress() + ":" + cliente.getPort();
            filas.showAdviceToServer(mensaje);
            filas.isConnectedToServer(true);
            return true;
        } catch (Exception e) {
            System.err.println("Mensaje de error: " + e.getMessage());
            return false;
        }
    }

    public void terminaConexion() {
        try {
            cliente.close();
            filas.isConnectedToServer(false);
        } catch (Exception e) {
            System.err.println("Mensaje de error: " + e.getMessage());
        }
    }

    public String recibe() {
        try {
            String nombre;
            nombre = dis.readUTF();
            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream( 
                            new File("src/updates/archivos/" + nombre)
                    )
            );
            long tamanio=dis.readLong();
            long leidos=0;
            int n=0;
            int porcentaje=0;
            byte[] buffer=new byte[1500];
            while(leidos<tamanio){
                n=dis.read(buffer);
                dos.write(buffer, 0, n);
                leidos+=n;
                porcentaje=(int)(leidos*100/tamanio);
                System.out.print("\rRecibido: "+porcentaje+"%");
            }
            mensaje = "\n" + nombre + " recibido ------------------> " + porcentaje + "%";
            filas.imprimirInformacion(mensaje);
            dos.close();
            return nombre;
        } catch (Exception e) {
            System.err.println("Mensaje de error: " + e.getMessage());
            return null;
        }

    }

    public void recibe(int[] archivos) {
        try {
            int numeroArchivos = dis.readInt();
            for(int i=0; i < numeroArchivos; i++) {
                recibe();
            }
        } catch (Exception e) {
            System.err.println("Mensaje de error: " + e.getMessage());
        }
    }
}
