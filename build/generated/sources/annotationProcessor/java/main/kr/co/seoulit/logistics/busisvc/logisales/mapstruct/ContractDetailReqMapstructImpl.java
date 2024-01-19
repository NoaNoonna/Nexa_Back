package kr.co.seoulit.logistics.busisvc.logisales.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.busisvc.logisales.dto.ContractDetailReqDto;
import kr.co.seoulit.logistics.busisvc.logisales.entity.ContractDetailEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2024-01-18T19:57:50+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
=======
    date = "2024-01-18T20:08:42+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.20.1 (Amazon.com Inc.)"
>>>>>>> df7e1cf3d46502b24e3c48b60499a920925a2f0f
)
@Component
public class ContractDetailReqMapstructImpl implements ContractDetailReqMapstruct {

    @Override
    public ContractDetailEntity toEntity(ContractDetailReqDto dto) {
        if ( dto == null ) {
            return null;
        }

        ContractDetailEntity contractDetailEntity = new ContractDetailEntity();

        contractDetailEntity.setStatus( dto.getStatus() );
        contractDetailEntity.setContractDetailNo( dto.getContractDetailNo() );
        contractDetailEntity.setContractNo( dto.getContractNo() );
        contractDetailEntity.setItemCode( dto.getItemCode() );
        contractDetailEntity.setItemName( dto.getItemName() );
        contractDetailEntity.setUnitOfContract( dto.getUnitOfContract() );
        contractDetailEntity.setDueDateOfContract( dto.getDueDateOfContract() );
        contractDetailEntity.setEstimateAmount( dto.getEstimateAmount() );
        contractDetailEntity.setStockAmountUse( dto.getStockAmountUse() );
        contractDetailEntity.setProductionRequirement( dto.getProductionRequirement() );
        contractDetailEntity.setUnitPriceOfContract( dto.getUnitPriceOfContract() );
        contractDetailEntity.setSumPriceOfContract( dto.getSumPriceOfContract() );
        contractDetailEntity.setProcessingStatus( dto.getProcessingStatus() );
        contractDetailEntity.setOperationCompletedStatus( dto.getOperationCompletedStatus() );
        contractDetailEntity.setDeliveryCompletionStatus( dto.getDeliveryCompletionStatus() );
        contractDetailEntity.setDescription( dto.getDescription() );
        contractDetailEntity.setChecked( dto.getChecked() );

        return contractDetailEntity;
    }

    @Override
    public List<ContractDetailEntity> toEntity(List<ContractDetailReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ContractDetailEntity> list = new ArrayList<ContractDetailEntity>( dtos.size() );
        for ( ContractDetailReqDto contractDetailReqDto : dtos ) {
            list.add( toEntity( contractDetailReqDto ) );
        }

        return list;
    }

    @Override
    public ArrayList<ContractDetailEntity> toEntity(ArrayList<ContractDetailReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        ArrayList<ContractDetailEntity> arrayList = new ArrayList<ContractDetailEntity>();
        for ( ContractDetailReqDto contractDetailReqDto : dtos ) {
            arrayList.add( toEntity( contractDetailReqDto ) );
        }

        return arrayList;
    }
}
