package push.notification.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import lombok.Data;

@Data
@Configuration
@ComponentScan(basePackages = "push.notification")
@ConfigurationProperties("app-config")
public class AppConfig {
    @Value("${app.firebase-configuration-file}")
    private String fbConfigPath;
}
