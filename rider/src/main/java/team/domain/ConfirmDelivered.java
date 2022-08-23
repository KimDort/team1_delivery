package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ConfirmDelivered extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Boolean isDelivered;
    private Date pickedTime;

    public ConfirmDelivered(DeliveryStatus aggregate){
        super(aggregate);
    }
    public ConfirmDelivered(){
        super();
    }
    // keep

}
