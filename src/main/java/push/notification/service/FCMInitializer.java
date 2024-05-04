package push.notification.service;

import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import push.notification.config.AppConfig;

@Service
public class FCMInitializer {

    @Autowired
    private AppConfig appConfig;

    @Value("${app.firebase-configuration-file}")
    private String fbConfigPath;

    Logger logger = LoggerFactory.getLogger(FCMInitializer.class);

    @PostConstruct
    public void initialize(){
        try{
            FirebaseOptions fbOptions = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials
                .fromStream(new ClassPathResource(appConfig.getFbConfigPath()).getInputStream())
            ).build();

            if(FirebaseApp.getApps().isEmpty()){
                FirebaseApp.initializeApp(fbOptions);
                logger.info("Firebase app has been initialized");
            }
        } catch(IOException ioe){
            logger.error(ioe.getMessage());
        }
    }
}
