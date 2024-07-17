package com.zensar.email;

import com.zensar.email.dto.MailRequest;
import com.zensar.email.dto.MailResponse;
import com.zensar.email.service.AttachementEmailService;
import com.zensar.email.service.TemplateEmailService;
import com.zensar.email.service.TextEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringbootEmailApplication  implements CommandLineRunner {

	@Autowired
	private TextEmailService textEmailService;

	@Autowired
	private AttachementEmailService attachementEmailService;

	@Autowired
	private TemplateEmailService templateEmailService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEmailApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("run method");
		//textEmailService.sendTextEmail("tech.mithilesh108@gmail.com","Springboot Text Email using SMTP gmail server","lund \n bando");
		//attachementEmailService.sendAttachmentEmail("tech.mithilesh108@gmail.com","Springboot Attachment Email using SMTP gmail server","lund \n bando");

		MailRequest request = new MailRequest();
		request.setTo("tech.mithilesh108@gmail.com");
		request.setFrom("tech.mk108@gmail.com");
		request.setSubject("Spring boot Template Email using SMTP gmail server");
		request.setName("Mithilesh");
		//set dynamic values
		Map<String, Object> model = new HashMap<>();
		model.put("Name", "Mithilesh");
		model.put("location", "Bangalore,India");
		MailResponse response =templateEmailService.sendTemplateEmail(request, model);
		System.out.println(response);
	}
}
