package model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
public class Board {
	@Id
	@GeneratedValue(generator = "board_seq")
	@SequenceGenerator(name = "board_seq", sequenceName = "BOARD_SEQ", allocationSize = 1)
	private Long no;

	@Column(name = "gender", length = 10)
	private String gender;

	@Column(name = "finddate", nullable = false)
	private String finddate;

	private String loc;
	private String detail;

	@Temporal(TemporalType.TIMESTAMP)
	private Date writedate;

//	@ManyToOne
//	@JoinColumn(name = "writer")
	private String writer;

}
