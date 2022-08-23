package team.domain;

import team.domain.OrderAccepted;
import team.domain.CookingComplete;
import team.domain.OrderCanceled;
import team.domain.CookingStarted;
import team.StoreApplication;
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
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String price;
    
    
    
    
    
    private String quantity;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();



        CookingComplete cookingComplete = new CookingComplete(this);
        cookingComplete.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();



        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = StoreApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void receiveOrderInformation(OrderPaid orderPaid){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPaid.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
