package push.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import push.notification.model.PNRequest;
import push.notification.model.PNResponse;
import push.notification.service.PNService;

@RestController
public class PNController {

	@Autowired
    private PNService pnService;

    @GetMapping()
    public String home(){
        return "In Home Controller in PN Service";
    }

    @PostMapping("/notification/token")
    public ResponseEntity<PNResponse> sendTokenNotification(@RequestBody PNRequest request) {
        pnService.sendPNToToken(request);
        return new ResponseEntity<>(new PNResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
}
