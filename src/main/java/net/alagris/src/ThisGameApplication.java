package net.alagris.src;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
@ImportResource("classpath:/Beans.xml")
public class ThisGameApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ThisGameApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ThisGameApplication.class, args);
		
	}

	
	
	@Bean
	public ViewResolver viewResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setTemplateMode("XHTML");
		templateResolver.setPrefix("classpath:/src/main/resources/templates/");
		templateResolver.setSuffix(".html");
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver);

		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(engine);
		return viewResolver;
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {
		logInfo();
//		Thread t = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				Scanner sc = new Scanner(System.in);
//				while(true){
//					
//					
//					
//				}
//				sc.close();
//			}
//		});
	}

	private void logInfo() throws Exception {
		///////////////////////////////////
		// LOGGING USEFUL INFO
		///////////////////////////////////
		log.info("App started! Logging useful info...");
		//////////////
		// DATABASE
		//////////////
		log.info("Database info:");
		log.info("\tURL=\t\t" + jdbcTemplate.getDataSource().getConnection().getMetaData().getURL());
		log.info("\tUser=\t\t" + jdbcTemplate.getDataSource().getConnection().getMetaData().getUserName());
		log.info("\tDriver=\t\t" + jdbcTemplate.getDataSource().getConnection().getMetaData().getDriverName());
		log.info("\tProduct=\t" + jdbcTemplate.getDataSource().getConnection().getMetaData().getDatabaseProductName());
		log.info("\tVersion=\t"
				+ jdbcTemplate.getDataSource().getConnection().getMetaData().getDatabaseProductVersion());

		///////////////////////////////////
		// LOGGING USEFUL INFO FINISH
		///////////////////////////////////
		log.info("..logging useful info finished!");
	}
}
