package kr.co.seoulit.logistics.logiinfosvc.logiinfo.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.logiinfosvc.logiinfo.dto.ItemGroupResDto;
import kr.co.seoulit.logistics.logiinfosvc.logiinfo.entity.ItemGroupEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T20:03:42+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class ItemGroupResMapStructImpl implements ItemGroupResMapStruct {

    @Override
    public ArrayList<ItemGroupResDto> toDto(ArrayList<ItemGroupEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        ArrayList<ItemGroupResDto> arrayList = new ArrayList<ItemGroupResDto>();
        for ( ItemGroupEntity itemGroupEntity : entities ) {
            arrayList.add( toDto( itemGroupEntity ) );
        }

        return arrayList;
    }

    @Override
    public ItemGroupResDto toDto(ItemGroupEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ItemGroupResDto itemGroupResDto = new ItemGroupResDto();

        itemGroupResDto.setItemGroupCode( entity.getItemGroupCode() );
        itemGroupResDto.setDescription( entity.getDescription() );
        itemGroupResDto.setItemGroupName( entity.getItemGroupName() );

        return itemGroupResDto;
    }

    @Override
    public List<ItemGroupResDto> toDto(List<ItemGroupEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ItemGroupResDto> list = new ArrayList<ItemGroupResDto>( entities.size() );
        for ( ItemGroupEntity itemGroupEntity : entities ) {
            list.add( toDto( itemGroupEntity ) );
        }

        return list;
    }
}
