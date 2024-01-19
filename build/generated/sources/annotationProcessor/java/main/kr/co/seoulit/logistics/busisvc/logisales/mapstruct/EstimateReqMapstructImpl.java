package kr.co.seoulit.logistics.busisvc.logisales.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.busisvc.logisales.dto.EstimateReqDto;
import kr.co.seoulit.logistics.busisvc.logisales.entity.EstimateEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2024-01-18T19:57:51+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
=======
    date = "2024-01-18T20:08:42+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.20.1 (Amazon.com Inc.)"
>>>>>>> df7e1cf3d46502b24e3c48b60499a920925a2f0f
)
@Component
public class EstimateReqMapstructImpl implements EstimateReqMapstruct {

    @Override
    public EstimateEntity toEntity(EstimateReqDto dto) {
        if ( dto == null ) {
            return null;
        }

        EstimateEntity estimateEntity = new EstimateEntity();

        estimateEntity.setEstimateNo( dto.getEstimateNo() );
        estimateEntity.setEstimateRequester( dto.getEstimateRequester() );
        estimateEntity.setDescription( dto.getDescription() );
        estimateEntity.setContractStatus( dto.getContractStatus() );
        estimateEntity.setCustomerCode( dto.getCustomerCode() );
        estimateEntity.setPersonCodeInCharge( dto.getPersonCodeInCharge() );
        estimateEntity.setEstimateDate( dto.getEstimateDate() );
        estimateEntity.setEffectiveDate( dto.getEffectiveDate() );
        estimateEntity.setStatus( dto.getStatus() );

        return estimateEntity;
    }

    @Override
    public List<EstimateEntity> toEntity(List<EstimateReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<EstimateEntity> list = new ArrayList<EstimateEntity>( dtos.size() );
        for ( EstimateReqDto estimateReqDto : dtos ) {
            list.add( toEntity( estimateReqDto ) );
        }

        return list;
    }

    @Override
    public ArrayList<EstimateEntity> toEntity(ArrayList<EstimateReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        ArrayList<EstimateEntity> arrayList = new ArrayList<EstimateEntity>();
        for ( EstimateReqDto estimateReqDto : dtos ) {
            arrayList.add( toEntity( estimateReqDto ) );
        }

        return arrayList;
    }
}
