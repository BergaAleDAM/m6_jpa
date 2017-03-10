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



@Entity
@NamedQueries({
@NamedQuery(name=Asseguradora.CONSULTA, query="SELECT a FROM Asseguradora a WHERE a.nom=:nom")})

@Table(name = "Asseguradora")
public class Asseguradora implements Serializable{

    
    private static final long serialVersionUID = 1L;
    
    public static final String CONSULTA="nomAsseg"; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    
    @Column(name = "nom", length = 100, nullable = false, unique = true)
    private String nom;
    
    
    private String nif;
    
//    @OneToMany (mappedBy = "asseguradoraId")
//    private List <Polissa> polissa;
//    

    public Asseguradora() {
    }

    public Asseguradora(long id, String nom, String nif) {
        this.id = id;
        this.nom = nom;
        this.nif = nif;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    

}
