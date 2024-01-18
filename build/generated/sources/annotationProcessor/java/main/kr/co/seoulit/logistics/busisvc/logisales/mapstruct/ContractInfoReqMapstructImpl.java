package kr.co.seoulit.logistics.busisvc.logisales.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.busisvc.logisales.dto.ContractInfoDto;
import kr.co.seoulit.logistics.busisvc.logisales.dto.ContractInfoReqDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T20:08:42+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.20.1 (Amazon.com Inc.)"
)
@Component
public class ContractInfoReqMapstructImpl implements ContractInfoReqMapstruct {

    @Override
    public ContractInfoDto toEntity(ContractInfoReqDto dto) {
        if ( dto == null ) {
            return null;
        }

        ContractInfoDto contractInfoDto = new ContractInfoDto();

        contractInfoDto.setStatus( dto.getStatus() );
        contractInfoDto.setContractNo( dto.getContractNo() );
        contractInfoDto.setEstimateNo( dto.getEstimateNo() );
        contractInfoDto.setContractType( dto.getContractType() );
        contractInfoDto.setContractTypeName( dto.getContractTypeName() );
        contractInfoDto.setCustomerCode( dto.getCustomerCode() );
        contractInfoDto.setCustomerName( dto.getCustomerName() );
        contractInfoDto.setEstimateDate( dto.getEstimateDate() );
        contractInfoDto.setContractDate( dto.getContractDate() );
        contractInfoDto.setContractRequester( dto.getContractRequester() );
        contractInfoDto.setPersonCodeInCharge( dto.getPersonCodeInCharge() );
        contractInfoDto.setEmpNameInCharge( dto.getEmpNameInCharge() );
        contractInfoDto.setDescription( dto.getDescription() );
        contractInfoDto.setDeliveryCompletionStatus( dto.getDeliveryCompletionStatus() );

        return contractInfoDto;
    }

    @Override
    public List<ContractInfoDto> toEntity(List<ContractInfoReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ContractInfoDto> list = new ArrayList<ContractInfoDto>( dtos.size() );
        for ( ContractInfoReqDto contractInfoReqDto : dtos ) {
            list.add( toEntity( contractInfoReqDto ) );
        }

        return list;
    }

    @Override
    public ArrayList<ContractInfoDto> toEntity(ArrayList<ContractInfoReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        ArrayList<ContractInfoDto> arrayList = new ArrayList<ContractInfoDto>();
        for ( ContractInfoReqDto contractInfoReqDto : dtos ) {
            arrayList.add( toEntity( contractInfoReqDto ) );
        }

        return arrayList;
    }
}
