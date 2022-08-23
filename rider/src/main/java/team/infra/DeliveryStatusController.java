package team.infra;
import team.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/deliveryStatuses")
@Transactional
public class DeliveryStatusController {
    @Autowired
    DeliveryStatusRepository deliveryStatusRepository;



    @RequestMapping(value = "deliveryStatuses/{id}/pick",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public DeliveryStatus pick(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /deliveryStatus/pick  called #####");
            Optional<DeliveryStatus> optionalDeliveryStatus = deliveryStatusRepository.findById(id);
            
            optionalDeliveryStatus.orElseThrow(()-> new Exception("No Entity Found"));
            DeliveryStatus deliveryStatus = optionalDeliveryStatus.get();
            deliveryStatus.pick();
            
            deliveryStatusRepository.save(deliveryStatus);
            return deliveryStatus;
            
    }
    



    @RequestMapping(value = "deliveryStatuses/{id}/delivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public DeliveryStatus delivery(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /deliveryStatus/delivery  called #####");
            Optional<DeliveryStatus> optionalDeliveryStatus = deliveryStatusRepository.findById(id);
            
            optionalDeliveryStatus.orElseThrow(()-> new Exception("No Entity Found"));
            DeliveryStatus deliveryStatus = optionalDeliveryStatus.get();
            deliveryStatus.delivery();
            
            deliveryStatusRepository.save(deliveryStatus);
            return deliveryStatus;
            
    }
    



    @RequestMapping(value = "deliveryStatuses/{id}/confirmdelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public DeliveryStatus confirmDelivery(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /deliveryStatus/confirmDelivery  called #####");
            Optional<DeliveryStatus> optionalDeliveryStatus = deliveryStatusRepository.findById(id);
            
            optionalDeliveryStatus.orElseThrow(()-> new Exception("No Entity Found"));
            DeliveryStatus deliveryStatus = optionalDeliveryStatus.get();
            deliveryStatus.confirmDelivery();
            
            deliveryStatusRepository.save(deliveryStatus);
            return deliveryStatus;
            
    }
    



    // keep
}
