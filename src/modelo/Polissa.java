package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@NamedQueries({
@NamedQuery(name=Polissa.CONSULTA2, query="SELECT p FROM Polissa p WHERE p.cliente=:clientId"),
@NamedQuery(name=Polissa.CONSULTA3, query="SELECT v FROM Vehicle v WHERE v.vehicleId=:vehicleId"),
@NamedQuery(name=Polissa.CONSULTA4, query="SELECT a FROM Asseguradora a WHERE a.id=:id"),
@NamedQuery(name=Polissa.CONSULTA5, query="SELECT c FROM Client c WHERE c.id=:id"),
@NamedQuery(name=Polissa.CONSULTA1, query="SELECT p FROM Polissa p WHERE p.vehicle.vehicleId=:vehicle")})
@Table (name = "Polissas", indexes = {@Index(columnList = "clientId", name = "indexPrenedor")})
public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final String CONSULTA1= "cercaPolizaPerVehicle";
    public static final String CONSULTA2= "cercarPolissaCliente";
    public static final String CONSULTA3= "asignarVehicle";
    public static final String CONSULTA4= "asignarAsseguradora";
    public static final String CONSULTA5= "asignarClient";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "polissaId", unique = true)
    private long idPolissa;

    
    @OneToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;
    
    @ManyToOne 
    @JoinColumn(name = "clientId")
    private Client cliente;
    
    @Column (name = "dataInici", nullable = false)
    private Date dataInici;
    
    @Column (name = "dataFi", nullable = false)
    private Date dataFi;
    
    
    private TipusPolissa tipus;
    
    
    private double prima;
    
    @ManyToOne
    @JoinColumn(name = "asseguradoraId")
    private Asseguradora asseguradora;

    public Polissa() {
    }

    public Polissa( Vehicle vehicle, Client cliente, Date dataInici, Date dataFi, TipusPolissa tipus, double prima, Asseguradora asseguradora) {
       
        
        this.vehicle = vehicle;
        this.cliente = cliente;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipus = tipus;
        this.prima = prima;
        this.asseguradora = asseguradora;
    }

    public long getIdPolissa() {
        return idPolissa;
    }

    public void setIdPolissa(long idPolissa) {
        this.idPolissa = idPolissa;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public TipusPolissa isTipus() {
        return tipus;
    }

    public void setTipus(TipusPolissa tipus) {
        this.tipus = tipus;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public Asseguradora getAsseguradora() {
        return asseguradora;
    }

    public void setAsseguradora(Asseguradora asseguradora) {
        this.asseguradora = asseguradora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.idPolissa ^ (this.idPolissa >>> 32));
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
        final Polissa other = (Polissa) obj;
        if (this.idPolissa != other.idPolissa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polissa{" + "idPolissa=" + idPolissa + ", vehicle=" + vehicle + ", cliente=" + cliente + ", dataInici=" + dataInici + ", dataFi=" + dataFi + ", tipus=" + tipus + ", prima=" + prima + ", asseguradora=" + asseguradora + '}';
    }


    

   

    
   

   
}