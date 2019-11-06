package com.dev.colalbum_be.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Denir R. Tavares
 */
@Entity
@Table(name = "tb01_artistas", catalog = "db01_col_albuns", schema = "sc01_col_musica")
@XmlRootElement
public class Artista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_artista", nullable = false)
    private Long codArtista;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCodArtista")
    @JsonManagedReference
    private Collection<Album> albumCollection;

    public Artista() {
    }

    public Artista(Long codArtista) {
        this.codArtista = codArtista;
    }

    public Artista(Long codArtista, String descricao) {
        this.codArtista = codArtista;
        this.descricao = descricao;
    }

    public Long getCodArtista() {
        return codArtista;
    }

    public void setCodArtista(Long codArtista) {
        this.codArtista = codArtista;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArtista != null ? codArtista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.codArtista == null && other.codArtista != null) || (this.codArtista != null && !this.codArtista.equals(other.codArtista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dev.colalbum_be.entity.Artista[ codArtista=" + codArtista + " ]";
    }

}
