package team.domain;

import team.domain.Ordered;
import team.domain.Canceled;
import team.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderStatus;
    
    
    
    
    
    private String orderedTime;
    
    
    
    
    
    private String foodName;
    
    
    
    
    
    private String price;
    
    
    
    
    
    private String customerId;

    @PostPersist
    public void onPostPersist(){


        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();

    }
    @PreRemove
    public void onPreRemove(){


        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
