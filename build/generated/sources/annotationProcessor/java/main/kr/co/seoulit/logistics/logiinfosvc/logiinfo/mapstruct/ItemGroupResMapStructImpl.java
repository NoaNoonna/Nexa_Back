package kr.co.seoulit.logistics.logiinfosvc.logiinfo.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.logiinfosvc.logiinfo.dto.ItemGroupResDto;
import kr.co.seoulit.logistics.logiinfosvc.logiinfo.entity.ItemGroupEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2024-01-18T21:36:27+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
=======
    date = "2024-01-18T20:08:41+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.20.1 (Amazon.com Inc.)"
>>>>>>> df7e1cf3d46502b24e3c48b60499a920925a2f0f
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
