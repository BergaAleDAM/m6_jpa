package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@Table (name = "Usuari")
public class Usuari implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String consulta = "UsuariNom";
    
    @Id
    @Column(name = "Nom", length = 30, nullable = false)
    private String nom;
    
    @Column(name = "Password", length = 30, nullable = false)
    private String pass;

    public Usuari() {
    }

    public Usuari(String nom, String pass) {
        this.nom = nom;
        this.pass = pass;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuari other = (Usuari) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuari{" + "nom=" + nom + ", pass=" + pass + '}';
    }
    
    
    
    
}