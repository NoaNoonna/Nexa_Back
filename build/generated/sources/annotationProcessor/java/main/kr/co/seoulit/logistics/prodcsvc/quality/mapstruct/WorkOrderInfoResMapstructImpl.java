package kr.co.seoulit.logistics.prodcsvc.quality.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.co.seoulit.logistics.prodcsvc.quality.Entity.WorkOrderInfoEntity;
import kr.co.seoulit.logistics.prodcsvc.quality.to.WorkOrderInfoResTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-18T19:57:51+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class WorkOrderInfoResMapstructImpl implements WorkOrderInfoResMapstruct {

    @Override
    public WorkOrderInfoResTO toDto(WorkOrderInfoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        WorkOrderInfoResTO workOrderInfoResTO = new WorkOrderInfoResTO();

        workOrderInfoResTO.setWorkOrderNo( entity.getWorkOrderNo() );
        workOrderInfoResTO.setMrpNo( entity.getMrpNo() );
        workOrderInfoResTO.setMrpGatheringNo( entity.getMrpGatheringNo() );
        workOrderInfoResTO.setItemClassification( entity.getItemClassification() );
        workOrderInfoResTO.setItemCode( entity.getItemCode() );
        workOrderInfoResTO.setItemName( entity.getItemName() );
        workOrderInfoResTO.setUnitOfMrp( entity.getUnitOfMrp() );
        workOrderInfoResTO.setRequiredAmount( entity.getRequiredAmount() );
        workOrderInfoResTO.setWorkSiteCode( entity.getWorkSiteCode() );
        workOrderInfoResTO.setWorkSiteName( entity.getWorkSiteName() );
        workOrderInfoResTO.setProductionProcessCode( entity.getProductionProcessCode() );
        workOrderInfoResTO.setProductionProcessName( entity.getProductionProcessName() );
        workOrderInfoResTO.setInspectionStatus( entity.getInspectionStatus() );
        workOrderInfoResTO.setProductionStatus( entity.getProductionStatus() );
        workOrderInfoResTO.setCompletionStatus( entity.getCompletionStatus() );
        workOrderInfoResTO.setChecked( entity.getChecked() );
        workOrderInfoResTO.setActualCompletionAmount( entity.getActualCompletionAmount() );

        return workOrderInfoResTO;
    }

    @Override
    public List<WorkOrderInfoResTO> toDto(List<WorkOrderInfoEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<WorkOrderInfoResTO> list = new ArrayList<WorkOrderInfoResTO>( entities.size() );
        for ( WorkOrderInfoEntity workOrderInfoEntity : entities ) {
            list.add( toDto( workOrderInfoEntity ) );
        }

        return list;
    }

    @Override
    public ArrayList<WorkOrderInfoResTO> toDto(ArrayList<WorkOrderInfoEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        ArrayList<WorkOrderInfoResTO> arrayList = new ArrayList<WorkOrderInfoResTO>();
        for ( WorkOrderInfoEntity workOrderInfoEntity : entities ) {
            arrayList.add( toDto( workOrderInfoEntity ) );
        }

        return arrayList;
    }
}
