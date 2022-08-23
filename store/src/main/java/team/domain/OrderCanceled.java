package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String price;
    private String quantity;
    private String status;

    public OrderCanceled(Store aggregate){
        super(aggregate);
    }
    public OrderCanceled(){
        super();
    }
    // keep

}
