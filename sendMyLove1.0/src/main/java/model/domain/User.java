package model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "nickname" }) })
@Entity
public class User {
	@Id
	private String id;
	@Column(length = 100, nullable = false)
	private String password;

//	@OneToMany(mappedBy = "writer")
//	List<Board> posts = new ArrayList<Board>();
	
	@Column(name="nickname")
	private String nickname;
}
