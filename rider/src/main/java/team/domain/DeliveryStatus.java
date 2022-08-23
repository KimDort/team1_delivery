package team.domain;

import team.RiderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="DeliveryStatus_table")
@Data

public class DeliveryStatus  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Boolean isPicked;
    
    
    
    
    
    private Boolean isDelivered;
    
    
    
    
    
    private Date pickedTime;
    
    
    
    
    
    private Date delieveredTime;

    @PostPersist
    public void onPostPersist(){
    }

    public static DeliveryStatusRepository repository(){
        DeliveryStatusRepository deliveryStatusRepository = RiderApplication.applicationContext.getBean(DeliveryStatusRepository.class);
        return deliveryStatusRepository;
    }



    public void pick(){
        Picked picked = new Picked(this);
        picked.publishAfterCommit();

    }
    public void delivery(){
        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();

    }
    public void confirmDelivery(){
        ConfirmDelivered confirmDelivered = new ConfirmDelivered(this);
        confirmDelivered.publishAfterCommit();

    }

    public static void addDeliveryItems(CookingComplete cookingComplete){

        /** Example 1:  new item 
        DeliveryStatus deliveryStatus = new DeliveryStatus();
        repository().save(deliveryStatus);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookingComplete.get???()).ifPresent(deliveryStatus->{
            
            deliveryStatus // do something
            repository().save(deliveryStatus);


         });
        */

        
    }


}
