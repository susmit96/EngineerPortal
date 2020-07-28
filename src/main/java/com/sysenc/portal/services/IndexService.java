package com.sysenc.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysenc.portal.model.EngineerInformation;
import com.sysenc.portal.repository.EngineerInformationRepository;
import com.sysenc.portal.view.IndexPostModel;

@Service
public class IndexService {

	@Autowired
	private EngineerInformationRepository engineerInformationRepository;

	@Transactional(readOnly = false)
	public void insertRegisterInfo(IndexPostModel postModel) {
		EngineerInformation engineerInformation = new EngineerInformation();
		engineerInformation.setFullName(postModel.getName());
		engineerInformation.setGender(postModel.getGender());
		engineerInformation.setAddress(postModel.getAddress());
		engineerInformation.setMailAddress(postModel.getEmail());
		engineerInformation.setPhoneNumber(postModel.getPhoneNumber());
		engineerInformation.setSkill(postModel.getSkill());
		engineerInformation.setComment(postModel.getComment());

		engineerInformationRepository.save(engineerInformation);
	}

//	public void registerCompleteMail(RegisterFormPostModel postModel) {
//		String mailAddress = "basnetsusmit@gmail.com";
//		ExecutorService exec = Executors.newFixedThreadPool(5);
//		SimpleMailMessage msg = new SimpleMailMessage();
//		JavaMailSender javaMailSender = setUp();
//
//		StringWriter writer = new StringWriter();
//		msg.setFrom(postModel.getEmail());
//		msg.setTo(mailAddress);
//		msg.setSubject("登録完了!");
//		msg.setText(writer.toString());
//		MailSendTask msp = new MailSendTask(msg,javaMailSender);
//		exec.submit(msp);
//	}
//
//	private JavaMailSender setUp() {
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		mailSender.setHost("localhost");
//		mailSender.setPort(25);
//		mailSender.setProtocol("smtp");
//		mailSender.setUsername("basnetsusmit@gmail.com");
//		mailSender.setPassword("sysenc5953");
//		Properties mailProperties = new Properties();
//		mailProperties.put("mail.smtp.auth", true);
//		mailProperties.put("mail.smtp.starttls.enable",true);
//		mailProperties.put("mail.debug",true);
//		mailSender.setJavaMailProperties(mailProperties);
//		return mailSender;
//	}

}
