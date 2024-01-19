package kr.co.seoulit.logistics.purcstosvc.purchase.mapper;

import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.purcstosvc.purchase.entity.OrderInfoEntity;
import kr.co.seoulit.logistics.purcstosvc.purchase.to.OrderInfoTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2024-01-18T19:57:51+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
=======
    date = "2024-01-18T20:08:41+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.20.1 (Amazon.com Inc.)"
>>>>>>> df7e1cf3d46502b24e3c48b60499a920925a2f0f
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
