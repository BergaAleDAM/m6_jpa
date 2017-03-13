package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Eric
 */
@Entity
@NamedQueries({
@NamedQuery(name = Asseguradora.CONSULTA, query = "Select a FROM Asseguradora a WHERE a.nom=:nom")})
@Table (name = "Asseguradora")
public class Asseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String CONSULTA = "nomAsseg";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nom", length = 100, nullable = false, unique = true)
    private String nom;
    
    @Column (name = "cif")
    private String cif;    
    
    @OneToMany (mappedBy = "asseguradora")
    private List <Polissa> polissa;

    public Asseguradora() {
    }

    public Asseguradora( String nom, String cif) {
        
        this.nom = nom;
        this.cif = cif;
    }

    public long getAsseguradoraId() {
        return id;
    }

    public void setAsseguradoraId(long asseguradoraId) {
        this.id = asseguradoraId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public List<Polissa> getPolissa() {
        return polissa;
    }

    public void setPolissa(List<Polissa> polissa) {
        this.polissa = polissa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Asseguradora other = (Asseguradora) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asseguradora{" + "asseguradoraId=" + id + ", nom=" + nom + ", cif=" + cif  + '}';
    }

    
    

     
    
}