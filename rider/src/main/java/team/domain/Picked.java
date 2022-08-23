package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Picked extends AbstractEvent {

    private Long id;
    private Boolean isPicked;
    private Long orderId;
    private Date pickedTime;

    public Picked(DeliveryStatus aggregate){
        super(aggregate);
    }
    public Picked(){
        super();
    }
    // keep

}
