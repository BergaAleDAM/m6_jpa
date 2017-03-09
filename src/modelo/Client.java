package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
@NamedQuery(name=Client.CONSULTA, query="SELECT c FROM Client c WHERE c.id=:id")})
@Table(name = "Client")

public class Client implements Serializable {

 
    private static final long serialVersionUID = 1L;
    public static final String CONSULTA = "nomCli";

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
 
    @Column(name = "NomUser", length = 50, nullable = false)
    private String nomUser;

    @Column(name = "Nif", length = 9, nullable = false)
    private String nif;
    
    @Embedded
    private Adreca adreca;
    
    
    @OneToMany(mappedBy = "prenedor")
    private List<Polissa> listaPoli;

    
    @OneToMany (mappedBy = "propietari")
    private List<Vehicle> listaVechiles;

    public Client(long id, String nomUser, String nif, String carrer, int numero, String poblacio) {
        this.id = id;
        this.nomUser = nomUser;
        this.nif = nif;
        this.adreca = new Adreca(carrer, numero,poblacio);
    }

    
    
    
    public Client() {
    }

    public List<Polissa> getListaPoli() {
        return listaPoli;
    }

    public void setListaPoli(List<Polissa> listaPoli) {
        this.listaPoli = listaPoli;
    }

    public List<Vehicle> getListaVechiles() {
        return listaVechiles;
    }

    public void setListaVechiles(List<Vehicle> listaVechiles) {
        this.listaVechiles = listaVechiles;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Adreca getAdreca() {
        return adreca;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    

}
