package team.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import team.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import team.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired StoreRepository storeRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPaid'")
    public void wheneverOrderPaid_ReceiveOrderInformation(@Payload OrderPaid orderPaid){

        OrderPaid event = orderPaid;
        System.out.println("\n\n##### listener ReceiveOrderInformation : " + orderPaid + "\n\n");


        

        // Sample Logic //
        Store.receiveOrderInformation(event);
        

        

    }

    // keep

}


