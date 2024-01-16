package kr.co.seoulit.logistics.prodcsvc.quality.repository;

import java.util.ArrayList;
import java.util.List;

import kr.co.seoulit.logistics.prodcsvc.quality.Entity.WorkOrderInfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import kr.co.seoulit.logistics.prodcsvc.quality.to.WorkOrderInfoTO;


public interface WorkOrderInfoRepository extends CrudRepository<WorkOrderInfoTO, String> {

	@Query(value = "select w FROM WorkOrderInfoEntity w WHERE w.operationCompleted IS NULL")
	ArrayList<WorkOrderInfoEntity> findByOperationCompletedIsNull();

}
