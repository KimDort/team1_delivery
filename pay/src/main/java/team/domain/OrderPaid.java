package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPaid extends AbstractEvent {

    private Long id;
    private String price;
    private String quantity;
    private String status;

    public OrderPaid(Pay aggregate){
        super(aggregate);
    }
    public OrderPaid(){
        super();
    }
    // keep

}
