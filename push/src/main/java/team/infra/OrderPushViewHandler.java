package team.infra;

import team.domain.*;
import team.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderPushViewHandler {


    @Autowired
    private OrderPushRepository orderPushRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (!ordered.validate()) return;

            // view 객체 생성
            OrderPush orderPush = new OrderPush();
            // view 객체에 이벤트의 Value 를 set 함
            orderPush.setId(ordered.getId());
            // view 레파지 토리에 save
            orderPushRepository.save(orderPush);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_1(@Payload OrderAccepted orderAccepted) {
        try {
            if (!orderAccepted.validate()) return;
                // view 객체 조회
            Optional<OrderPush> orderPushOptional = orderPushRepository.findById(Long.valueOf(orderAccepted.getOrderId()));

            if( orderPushOptional.isPresent()) {
                 OrderPush orderPush = orderPushOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderPush.setStoreStatus("주문수락");    
                // view 레파지 토리에 save
                 orderPushRepository.save(orderPush);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPicked_then_UPDATE_2(@Payload Picked picked) {
        try {
            if (!picked.validate()) return;
                // view 객체 조회
            Optional<OrderPush> orderPushOptional = orderPushRepository.findById(picked.getOrderId());

            if( orderPushOptional.isPresent()) {
                 OrderPush orderPush = orderPushOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderPush.setIsPicked("픽업함");    
                // view 레파지 토리에 save
                 orderPushRepository.save(orderPush);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_3(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회
            Optional<OrderPush> orderPushOptional = orderPushRepository.findById(delivered.getOrderId());

            if( orderPushOptional.isPresent()) {
                 OrderPush orderPush = orderPushOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderPush.setIsDelivered("배달완료");    
                // view 레파지 토리에 save
                 orderPushRepository.save(orderPush);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookingStarted_then_UPDATE_4(@Payload CookingStarted cookingStarted) {
        try {
            if (!cookingStarted.validate()) return;
                // view 객체 조회
            Optional<OrderPush> orderPushOptional = orderPushRepository.findById(Long.valueOf(cookingStarted.getOrderId()));

            if( orderPushOptional.isPresent()) {
                 OrderPush orderPush = orderPushOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderPush.setStoreStatus("조리시작");    
                // view 레파지 토리에 save
                 orderPushRepository.save(orderPush);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookingComplete_then_UPDATE_5(@Payload CookingComplete cookingComplete) {
        try {
            if (!cookingComplete.validate()) return;
                // view 객체 조회
            Optional<OrderPush> orderPushOptional = orderPushRepository.findById(Long.valueOf(cookingComplete.getOrderId()));

            if( orderPushOptional.isPresent()) {
                 OrderPush orderPush = orderPushOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderPush.setStoreStatus("조리완료");    
                // view 레파지 토리에 save
                 orderPushRepository.save(orderPush);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_6(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회
            Optional<OrderPush> orderPushOptional = orderPushRepository.findById(Long.valueOf(orderCanceled.getOrderId()));

            if( orderPushOptional.isPresent()) {
                 OrderPush orderPush = orderPushOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderPush.setStoreStatus("주문거절");    
                // view 레파지 토리에 save
                 orderPushRepository.save(orderPush);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // keep

}

