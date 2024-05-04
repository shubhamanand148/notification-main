package push.notification.model;

import lombok.Data;

@Data
public class PNRequest {
    private String title;
    private String message;
    private String topic;
    private String token;
}
