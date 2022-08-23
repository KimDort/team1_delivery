package team.domain;

import team.infra.AbstractEvent;
import lombok.Data;
import java.util.Date;

@Data
public class Delivered extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Date pickedTime;
    private Boolean isDelivered;
    private Date delieveredTime;
}
