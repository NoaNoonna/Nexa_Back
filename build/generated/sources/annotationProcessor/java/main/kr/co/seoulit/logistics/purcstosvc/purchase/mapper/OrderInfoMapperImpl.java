package kr.co.seoulit.logistics.purcstosvc.purchase.mapper;

import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.purcstosvc.purchase.entity.OrderInfoEntity;
import kr.co.seoulit.logistics.purcstosvc.purchase.to.OrderInfoTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-05T10:32:03+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.22 (Amazon.com Inc.)"
)
@Component
public class OrderInfoMapperImpl implements OrderInfoMapper {

    @Override
    public OrderInfoTO entityToTO(OrderInfoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderInfoTO orderInfoTO = new OrderInfoTO();

        orderInfoTO.setOrderDate( entity.getOrderDate() );
        orderInfoTO.setOrderInfoStatus( entity.getOrderInfoStatus() );
        orderInfoTO.setOrderSort( entity.getOrderSort() );
        orderInfoTO.setItemCode( entity.getItemCode() );
        orderInfoTO.setItemName( entity.getItemName() );
        orderInfoTO.setOrderAmount( entity.getOrderAmount() );
        orderInfoTO.setInspectionStatus( entity.getInspectionStatus() );
        orderInfoTO.setChecked( entity.getChecked() );
        orderInfoTO.setOrderNo( entity.getOrderNo() );

        return orderInfoTO;
    }
}
