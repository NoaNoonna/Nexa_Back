package kr.co.seoulit.logistics.busisvc.logisales.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.busisvc.logisales.dto.ContractResDto;
import kr.co.seoulit.logistics.busisvc.logisales.entity.ContractEntity;
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
public class ContractResMapstructImpl implements ContractResMapstruct {

    @Override
    public ContractEntity toEntity(ContractResDto dto) {
        if ( dto == null ) {
            return null;
        }

        ContractEntity contractEntity = new ContractEntity();

        contractEntity.setStatus( dto.getStatus() );
        contractEntity.setContractNo( dto.getContractNo() );
        contractEntity.setContractType( dto.getContractType() );
        contractEntity.setEstimateNo( dto.getEstimateNo() );
        contractEntity.setContractDate( dto.getContractDate() );
        contractEntity.setDescription( dto.getDescription() );
        contractEntity.setContractRequester( dto.getContractRequester() );
        contractEntity.setCustomerCode( dto.getCustomerCode() );
        contractEntity.setPersonCodeInCharge( dto.getPersonCodeInCharge() );

        return contractEntity;
    }

    @Override
    public List<ContractEntity> toEntity(List<ContractResDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ContractEntity> list = new ArrayList<ContractEntity>( dtos.size() );
        for ( ContractResDto contractResDto : dtos ) {
            list.add( toEntity( contractResDto ) );
        }

        return list;
    }

    @Override
    public ArrayList<ContractEntity> toEntity(ArrayList<ContractResDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        ArrayList<ContractEntity> arrayList = new ArrayList<ContractEntity>();
        for ( ContractResDto contractResDto : dtos ) {
            arrayList.add( toEntity( contractResDto ) );
        }

        return arrayList;
    }
}
