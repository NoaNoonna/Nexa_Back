package kr.co.seoulit.logistics.logiinfosvc.logiinfo.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.logiinfosvc.logiinfo.dto.ItemGroupReqDto;
import kr.co.seoulit.logistics.logiinfosvc.logiinfo.entity.ItemGroupEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-19T20:03:42+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class ItemGroupReqMapStructImpl implements ItemGroupReqMapStruct {

    @Override
    public ArrayList<ItemGroupEntity> toEntity(ArrayList<ItemGroupReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        ArrayList<ItemGroupEntity> arrayList = new ArrayList<ItemGroupEntity>();
        for ( ItemGroupReqDto itemGroupReqDto : dtos ) {
            arrayList.add( toEntity( itemGroupReqDto ) );
        }

        return arrayList;
    }

    @Override
    public ItemGroupEntity toEntity(ItemGroupReqDto dto) {
        if ( dto == null ) {
            return null;
        }

        ItemGroupEntity itemGroupEntity = new ItemGroupEntity();

        itemGroupEntity.setItemGroupCode( dto.getItemGroupCode() );
        itemGroupEntity.setDescription( dto.getDescription() );
        itemGroupEntity.setItemGroupName( dto.getItemGroupName() );
        itemGroupEntity.setChecked( dto.getChecked() );
        itemGroupEntity.setStatus( dto.getStatus() );

        return itemGroupEntity;
    }

    @Override
    public List<ItemGroupEntity> toEntity(List<ItemGroupReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ItemGroupEntity> list = new ArrayList<ItemGroupEntity>( dtos.size() );
        for ( ItemGroupReqDto itemGroupReqDto : dtos ) {
            list.add( toEntity( itemGroupReqDto ) );
        }

        return list;
    }
}
