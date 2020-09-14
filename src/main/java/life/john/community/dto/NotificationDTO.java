package life.john.community.dto;

import life.john.community.model.User;
import lombok.Data;

@Data
public class NotificationDTO {
    private Long gmtCreate;
    private Long id;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
