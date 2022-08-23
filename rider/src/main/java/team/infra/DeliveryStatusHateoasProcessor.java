package team.infra;
import team.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class DeliveryStatusHateoasProcessor implements RepresentationModelProcessor<EntityModel<DeliveryStatus>>  {

    @Override
    public EntityModel<DeliveryStatus> process(EntityModel<DeliveryStatus> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/pick").withRel("pick"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/delivery").withRel("delivery"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/confirmdelivery").withRel("confirmdelivery"));

        
        return model;
    }
    
}
