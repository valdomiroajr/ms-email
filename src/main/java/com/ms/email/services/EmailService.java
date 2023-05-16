package com.ms.email.services;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender mailSender; 

	@SuppressWarnings("finally")
	public EmailModel sendEmail(EmailModel emailModel) {
		emailModel.setSendDateEmail(LocalDateTime.now());
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmailFrom());
			message.setTo((emailModel.getEmailTo()));
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			mailSender.send(message);
		} catch (Exception e) {
			System.err.println(e);
			emailModel.setStatusEmail(StatusEmail.ERRO);
		}finally {
			return emailRepository.save(emailModel);
		}
	}

	public Page<EmailModel> findAll(Pageable pageable) {
		return emailRepository.findAll(pageable);
	}

	public Optional<EmailModel> findById(Long id) {
		return emailRepository.findById(id);
	}

	@Transactional
	public void delete(EmailModel model) {
		emailRepository.delete(model);
	}

}
