/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.modelo;

/**
 *
 * @author rafael landa
 */
public class Usuario {
    private int    idUsuario;
    private String nombre;
    private String paterno;
    private String materno;
    private String email;
    private String nombreUsuario;
    private String claveUsuario;
    private String tipoUsuario;

    public Usuario () { }
    public Usuario (int idUsuario, String nombre,
                    String paterno, String materno,
                    String email, String nombreUsuario,
                    String claveUsuario, String tipoUsuario) { 
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.materno = materno;
            this.email = email;
            this.nombreUsuario = nombreUsuario;
            this.claveUsuario = claveUsuario;
            this.tipoUsuario = tipoUsuario;
    }

    public int    getIdUsuario () { return idUsuario; }
    public String getNombre () { return nombre; }
    public String getPaterno () { return paterno; }
    public String getMaterno () { return materno; }
    public String getEmail () { return email; }
    public String getNombreUsuario () { return nombreUsuario; }
    public String getClaveUsuario () { return claveUsuario; }
    public String getTipoUsuario () { return tipoUsuario; }

    public void setIdUsuario ( int idUsuario ) { this.idUsuario = idUsuario; }
    public void setNombre ( String nombre ) { this.nombre = nombre; }
    public void setPaterno ( String paterno ) { this.paterno = paterno; }
    public void setMaterno ( String materno ) { this.materno = materno; }
    public void setEmail ( String email ) { this.email = email; }
    public void setNombreUsuario ( String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public void setClaveUsuario ( String claveUsuario ) { this.claveUsuario = claveUsuario; }
    public void setTipoUsuario ( String tipoUsuario ) { this.tipoUsuario = tipoUsuario; }

    @Override
    public String toString () {
        StringBuilder retUsuario = new StringBuilder("");
        retUsuario.append("ID: ");
        retUsuario.append(getIdUsuario());
        retUsuario.append("\nNombre: ").append(getNombre());
        retUsuario.append("\nApellido paterno: ").append(getPaterno());
        retUsuario.append("\nApellido materno: ").append(getMaterno());
        retUsuario.append("\nNombre Usuario: ").append(getNombreUsuario());
        retUsuario.append("\nClave Usuario: ").append(getClaveUsuario());
        retUsuario.append("\nTipo Usuario: ").append(getTipoUsuario());
        return retUsuario.toString();
    }
}