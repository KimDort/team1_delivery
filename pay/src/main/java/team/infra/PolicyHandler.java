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
    @Autowired PayRepository payRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Canceled'")
    public void wheneverCanceled_Refund(@Payload Canceled canceled){

        Canceled event = canceled;
        System.out.println("\n\n##### listener Refund : " + canceled + "\n\n");


        

        // Sample Logic //
        Pay.refund(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Ordered'")
    public void wheneverOrdered_AddPaymentList(@Payload Ordered ordered){

        Ordered event = ordered;
        System.out.println("\n\n##### listener AddPaymentList : " + ordered + "\n\n");


        

        // Sample Logic //
        Pay.addPaymentList(event);
        

        

    }

    // keep

}


