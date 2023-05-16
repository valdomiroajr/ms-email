package com.ms.email.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.ms.email.enums.StatusEmail;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@SuppressWarnings("unused")
@Getter @Setter
public class EmailDto {
	
	@NotBlank
	private String ownerRef;

	@NotBlank
	private String emailFrom;

	@NotBlank
	private String emailTo;

	@NotBlank
	private String subject;

	@NotBlank
	private String text;

	@NotBlank
	private LocalDateTime sendDateEmail;

	@NotBlank
	private StatusEmail statusEmail;
}
