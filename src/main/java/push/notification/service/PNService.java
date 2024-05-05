package push.notification.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import push.notification.model.PNRequest;

@Service
public class PNService {
    private Logger logger = LoggerFactory.getLogger(PNService.class);

    @Autowired
    private FCMService fcmService;

    public void sendPNToToken(PNRequest request){
        try {fcmService.sendMessageToToken(request);}
        catch (Exception e) {logger.error(e.getMessage());}
    }
}
