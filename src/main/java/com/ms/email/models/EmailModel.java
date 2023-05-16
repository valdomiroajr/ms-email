package com.ms.email.models;

import java.time.LocalDateTime;


import javax.validation.constraints.Email;

import com.ms.email.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TB_EMAIL")
@SuppressWarnings("unused")
@Data
public class EmailModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String ownerRef;

	private String emailFrom;

	private String emailTo;

	private String subject;

	@Column(columnDefinition = "TEXT")
	private String text;

	private LocalDateTime sendDateEmail;

	private StatusEmail statusEmail;
}
