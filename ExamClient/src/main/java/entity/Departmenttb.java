/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "departmenttb")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departmenttb.findAll", query = "SELECT d FROM Departmenttb d"),
    @NamedQuery(name = "Departmenttb.findById", query = "SELECT d FROM Departmenttb d WHERE d.id = :id"),
    @NamedQuery(name = "Departmenttb.findByName", query = "SELECT d FROM Departmenttb d WHERE d.name = :name")})
public class Departmenttb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private Collection<Employeetb> employeetbCollection;

    public Departmenttb() {
    }

    public Departmenttb(Integer id) {
        this.id = id;
    }

    public Departmenttb(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @XmlTransient
    @JsonbTransient
    public Collection<Employeetb> getEmployeetbCollection() {
        return employeetbCollection;
    }

    public void setEmployeetbCollection(Collection<Employeetb> employeetbCollection) {
        this.employeetbCollection = employeetbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departmenttb)) {
            return false;
        }
        Departmenttb other = (Departmenttb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.examemployee.entity.Departmenttb[ id=" + id + " ]";
    }
    
}
