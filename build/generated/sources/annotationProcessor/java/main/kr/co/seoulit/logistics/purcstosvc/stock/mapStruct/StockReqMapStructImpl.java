package kr.co.seoulit.logistics.purcstosvc.stock.mapStruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.purcstosvc.stock.dto.StockRepDto;
import kr.co.seoulit.logistics.purcstosvc.stock.entity.StockEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2024-01-18T20:32:24+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
=======
    date = "2024-01-18T20:08:42+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.20.1 (Amazon.com Inc.)"
>>>>>>> df7e1cf3d46502b24e3c48b60499a920925a2f0f
)
@Component
public class StockReqMapStructImpl implements StockReqMapStruct {

    @Override
    public ArrayList<StockEntity> toEntity(ArrayList<StockRepDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        ArrayList<StockEntity> arrayList = new ArrayList<StockEntity>();
        for ( StockRepDto stockRepDto : dtos ) {
            arrayList.add( toEntity( stockRepDto ) );
        }

        return arrayList;
    }

    @Override
    public StockEntity toEntity(StockRepDto dto) {
        if ( dto == null ) {
            return null;
        }

        StockEntity stockEntity = new StockEntity();

        stockEntity.setStatus( dto.getStatus() );
        stockEntity.setWarehouseCode( dto.getWarehouseCode() );
        stockEntity.setItemCode( dto.getItemCode() );
        stockEntity.setItemName( dto.getItemName() );
        stockEntity.setUnitOfStock( dto.getUnitOfStock() );
        stockEntity.setSafetyAllowanceAmount( dto.getSafetyAllowanceAmount() );
        stockEntity.setStockAmount( dto.getStockAmount() );
        stockEntity.setOrderAmount( dto.getOrderAmount() );
        stockEntity.setInputAmount( dto.getInputAmount() );
        stockEntity.setTotalStockAmount( dto.getTotalStockAmount() );

        return stockEntity;
    }

    @Override
    public List<StockEntity> toEntity(List<StockRepDto> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StockEntity> list = new ArrayList<StockEntity>( entities.size() );
        for ( StockRepDto stockRepDto : entities ) {
            list.add( toEntity( stockRepDto ) );
        }

        return list;
    }
}
