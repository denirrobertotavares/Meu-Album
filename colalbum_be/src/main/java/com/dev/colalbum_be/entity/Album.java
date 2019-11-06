package com.dev.colalbum_be.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author Denir R. Tavares
 */
@Entity
@Table(name = "tb02_albuns", catalog = "db01_col_albuns", schema = "sc01_col_musica")
@XmlRootElement
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_album", nullable = false)
    private Long codAlbum;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String descricao;
    @JoinColumn(name = "fk_cod_artista", referencedColumnName = "cod_artista", nullable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Artista fkCodArtista;

    public Album() {
    }

    public Album(Long codAlbum) {
        this.codAlbum = codAlbum;
    }

    public Album(Long codAlbum, String descricao) {
        this.codAlbum = codAlbum;
        this.descricao = descricao;
    }

    public Long getCodAlbum() {
        return codAlbum;
    }

    public void setCodAlbum(Long codAlbum) {
        this.codAlbum = codAlbum;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Artista getFkCodArtista() {
        return fkCodArtista;
    }

    public void setFkCodArtista(Artista fkCodArtista) {
        this.fkCodArtista = fkCodArtista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlbum != null ? codAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.codAlbum == null && other.codAlbum != null) || (this.codAlbum != null && !this.codAlbum.equals(other.codAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dev.colalbum_be.entity.Album[ codAlbum=" + codAlbum + " ]";
    }

}
