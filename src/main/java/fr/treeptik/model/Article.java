package fr.treeptik.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Article implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titre;
	private String chapeau;
	private String contenu;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Transient
	private boolean enLigne;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Categorie categorie;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Personne personne;
	
	@OneToMany (mappedBy = "article")
	private Set<Commentaire> commentaires;
	
	
	public Article() {
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getChapeau() {
		return chapeau;
	}

	public void setChapeau(String chapeau) {
		this.chapeau = chapeau;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isEnLigne() {
		return enLigne;
	}

	public void setEnLigne(boolean enLigne) {
		this.enLigne = enLigne;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Set<Commentaire> getCommentaires() {
		
		if (commentaires==null){
			commentaires = new HashSet<Commentaire>();
		}
		
		return commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", chapeau="
				+ chapeau + ", contenu=" + contenu + ", creationDate="
				+ creationDate + ", enLigne=" + enLigne + ", categorie="
				+ categorie + ", auteur=" + personne.getNom() + ", commentaires="
				+ commentaires + "]";
	}


	
	
}
