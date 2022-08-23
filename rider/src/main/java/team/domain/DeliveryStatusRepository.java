package team.domain;

import team.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="deliveryStatuses", path="deliveryStatuses")
public interface DeliveryStatusRepository extends PagingAndSortingRepository<DeliveryStatus, Long>{

}
