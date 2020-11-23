package com.example.chat.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.chat.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity object to store users in relation database.
 *
 * @author Adam Vecsi
 * @since 2020. 10. 27
 */

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "neptun")
	private String neptun;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "senderUser")
	private List<DatabaseMessageEntity> messages;
}
