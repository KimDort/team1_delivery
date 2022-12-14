package team.infra;

import team.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="orderPushes", path="orderPushes")
public interface OrderPushRepository extends PagingAndSortingRepository<OrderPush, Long> {

    

    

    // keep

}
