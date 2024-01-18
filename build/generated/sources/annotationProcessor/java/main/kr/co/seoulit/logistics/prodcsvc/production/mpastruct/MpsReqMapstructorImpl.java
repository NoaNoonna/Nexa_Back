package kr.co.seoulit.logistics.prodcsvc.production.mpastruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.prodcsvc.production.entity.MpsEntity;
import kr.co.seoulit.logistics.prodcsvc.production.to.MpsReqTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T20:08:42+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.20.1 (Amazon.com Inc.)"
)
@Component
public class MpsReqMapstructorImpl implements MpsReqMapstructor {

    @Override
    public MpsEntity toEntity(MpsReqTO dto) {
        if ( dto == null ) {
            return null;
        }

        MpsEntity mpsEntity = new MpsEntity();

        return mpsEntity;
    }

    @Override
    public List<MpsEntity> toEntity(List<MpsReqTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<MpsEntity> list = new ArrayList<MpsEntity>( dtos.size() );
        for ( MpsReqTO mpsReqTO : dtos ) {
            list.add( toEntity( mpsReqTO ) );
        }

        return list;
    }

    @Override
    public ArrayList<MpsEntity> toEntity(ArrayList<MpsReqTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        ArrayList<MpsEntity> arrayList = new ArrayList<MpsEntity>();
        for ( MpsReqTO mpsReqTO : dtos ) {
            arrayList.add( toEntity( mpsReqTO ) );
        }

        return arrayList;
    }
}
