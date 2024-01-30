package kr.co.seoulit.logistics.purcstosvc.stock.mapStruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.purcstosvc.stock.dto.StockResDto;
import kr.co.seoulit.logistics.purcstosvc.stock.entity.StockEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-30T10:38:20+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.22 (Amazon.com Inc.)"
)
@Component
public class StockResMapStructImpl implements StockResMapStruct {

    @Override
    public ArrayList<StockResDto> toDto(ArrayList<StockEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        ArrayList<StockResDto> arrayList = new ArrayList<StockResDto>();
        for ( StockEntity stockEntity : entities ) {
            arrayList.add( toDto( stockEntity ) );
        }

        return arrayList;
    }

    @Override
    public StockResDto toDto(StockEntity entity) {
        if ( entity == null ) {
            return null;
        }

        StockResDto stockResDto = new StockResDto();

        stockResDto.setStatus( entity.getStatus() );
        stockResDto.setWarehouseCode( entity.getWarehouseCode() );
        stockResDto.setItemCode( entity.getItemCode() );
        stockResDto.setItemName( entity.getItemName() );
        stockResDto.setUnitOfStock( entity.getUnitOfStock() );
        stockResDto.setSafetyAllowanceAmount( entity.getSafetyAllowanceAmount() );
        stockResDto.setStockAmount( entity.getStockAmount() );
        stockResDto.setOrderAmount( entity.getOrderAmount() );
        stockResDto.setInputAmount( entity.getInputAmount() );
        stockResDto.setTotalStockAmount( entity.getTotalStockAmount() );

        return stockResDto;
    }

    @Override
    public List<StockResDto> toDto(List<StockEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<StockResDto> list = new ArrayList<StockResDto>( entities.size() );
        for ( StockEntity stockEntity : entities ) {
            list.add( toDto( stockEntity ) );
        }

        return list;
    }
}
