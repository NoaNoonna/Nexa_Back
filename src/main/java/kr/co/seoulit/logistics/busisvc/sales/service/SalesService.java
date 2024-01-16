package kr.co.seoulit.logistics.busisvc.sales.service;

import kr.co.seoulit.logistics.busisvc.logisales.dto.ContractInfoDto;
import kr.co.seoulit.logistics.busisvc.logisales.dto.ContractInfoResDto;
import kr.co.seoulit.logistics.busisvc.sales.dto.*;
import kr.co.seoulit.logistics.busisvc.sales.to.DeliveryInfoEntity;
import kr.co.seoulit.logistics.busisvc.sales.to.SalesPlanEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface SalesService {

    // SalesPlanApplicationServiceImpl
    public ArrayList<ContractInfoResDto> getDeliverableContractList(HashMap<String, String> ableSearchConditionInfo);

    public ArrayList<SalesPlanEntity> getSalesPlanList(String dateSearchCondition, String startDate, String endDate);

    public HashMap<String, Object> batchSalesPlanListProcess(ArrayList<SalesPlanEntity> salesPlanEntityList);

//    public HashMap<String, Object> batchDeliveryListProcess(List<DeliveryInfoEntity> deliveryTOList);

    public HashMap<String, Object> deliver(String contractDetailNo);

    public ArrayList<DeliveryInfoResDto> getDeliveryInfoList();

    public ArrayList<ReverseResDto> getReturnAbleList(ReverseReqDto reversReqDto);

    public void insertReturnList(List<ReverseReqDto> reverseReqList);

    public ArrayList<QuarterResDto> getSalesQuaChart();
}
