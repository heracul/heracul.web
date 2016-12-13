package heracul.web;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ApplicationConfiguration {

	Logger logger = org.slf4j.LoggerFactory.getLogger(ApplicationConfiguration.class);
	@Value("${heracul.web.port:8098}")
	private String port;

	@Value("${heracul.context.path:/ys2}")
	private String contextPath;

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		logger.info("Setting custom configuration for Mainstay:");
		logger.info("Setting port to {}", port);
		logger.info("Setting context to {}", contextPath);
		factory.setPort(Integer.valueOf(port));
		factory.setContextPath(contextPath);
		return factory;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfiguration.class, args);
	}
}
