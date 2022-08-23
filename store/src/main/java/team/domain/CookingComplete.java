package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingComplete extends AbstractEvent {

    private Long id;
    private String orderId;
    private String price;
    private String quantity;
    private String status;

    public CookingComplete(Store aggregate){
        super(aggregate);
    }
    public CookingComplete(){
        super();
    }
    // keep

}
