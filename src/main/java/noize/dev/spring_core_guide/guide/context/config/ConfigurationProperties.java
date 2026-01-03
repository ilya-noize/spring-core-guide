package noize.dev.spring_core_guide.guide.context.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigurationProperties {
}
