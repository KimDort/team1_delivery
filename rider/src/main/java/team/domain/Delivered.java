package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Delivered extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Date pickedTime;
    private Boolean isDelivered;
    private Date delieveredTime;

    public Delivered(DeliveryStatus aggregate){
        super(aggregate);
    }
    public Delivered(){
        super();
    }
    // keep

}
