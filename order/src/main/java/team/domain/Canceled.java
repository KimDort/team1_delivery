package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String orderStatus;
    private String orderedTime;
    private String foodName;

    public Canceled(Order aggregate){
        super(aggregate);
    }
    public Canceled(){
        super();
    }
    // keep

}
