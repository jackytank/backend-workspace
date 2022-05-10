package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Favorites database table.
 * 
 */
@Entity
@Table(name="Favorites", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"VideoId","UserId"})
})
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private long id;

	@Column(name="LikeDate")
	private Object likeDate;

	@Column(name="UserId")
	private Object userId;

	@Column(name="VideoId")
	private String videoId;

	public Favorite() {
	}



}