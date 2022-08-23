package team.domain;

import team.infra.AbstractEvent;
import lombok.Data;
import java.util.Date;

@Data
public class Picked extends AbstractEvent {

    private Long id;
    private Boolean isPicked;
    private Long orderId;
    private Date pickedTime;
}
