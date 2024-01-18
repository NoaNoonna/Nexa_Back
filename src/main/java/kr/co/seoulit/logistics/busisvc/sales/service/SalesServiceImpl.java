package kr.co.seoulit.logistics.busisvc.sales.service;

import kr.co.seoulit.logistics.busisvc.logisales.entity.ContractEntity;
import kr.co.seoulit.logistics.busisvc.logisales.mapper.ContractMapper;
import kr.co.seoulit.logistics.busisvc.sales.dto.*;
import kr.co.seoulit.logistics.busisvc.sales.mapper.DeliveryMapper;
import kr.co.seoulit.logistics.busisvc.sales.mapper.SalesPlanMapper;
import kr.co.seoulit.logistics.busisvc.sales.to.SalesPlanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private SalesPlanMapper salesPlanMapper;
    @Autowired
    private DeliveryMapper deliveryMapper;


    @Override
    public ArrayList<ContractEntity> getDeliverableContractList(HashMap<String, String> map) {

        ArrayList<ContractEntity> contractInfoResDtoList = contractMapper.selectDeliverableContractList(map);
        for (ContractEntity bean : contractInfoResDtoList) { // 해당 수주의 수주상세 리스트 세팅

            bean.setContractDetailEntityList(contractMapper.selectDeliverableContractDetailList(bean.getContractNo()));

        }

        return contractInfoResDtoList;
    }


    @Override
    public ArrayList<SalesPlanEntity> getSalesPlanList(String dateSearchCondition, String startDate, String endDate) {

        ArrayList<SalesPlanEntity> salesPlanEntityList = null;

        HashMap<String, String> map = new HashMap<>();

        map.put("dateSearchCondition", dateSearchCondition);
        map.put("startDate", startDate);
        map.put("endDate", endDate);

        salesPlanEntityList = salesPlanMapper.selectSalesPlanList(map);

        return salesPlanEntityList;
    }

    @Override
    public ModelMap batchSalesPlanListProcess(ArrayList<SalesPlanEntity> salesPlanEntityList) {

        ModelMap resultMap = new ModelMap();

        ArrayList<String> insertList = new ArrayList<>();
        ArrayList<String> updateList = new ArrayList<>();
        ArrayList<String> deleteList = new ArrayList<>();

        for (SalesPlanEntity bean : salesPlanEntityList) {

            String status = bean.getStatus();

            switch (status) {

                case "INSERT":

                    String newSalesPlanNo = getNewSalesPlanNo(bean.getSalesPlanDate());

                    bean.setSalesPlanNo(newSalesPlanNo);

                    salesPlanMapper.insertSalesPlan(bean);

                    insertList.add(newSalesPlanNo);

                    break;

                case "UPDATE":

                    salesPlanMapper.updateSalesPlan(bean);

                    updateList.add(bean.getSalesPlanNo());

                    break;

                case "DELETE":

                    salesPlanMapper.deleteSalesPlan(bean);

                    deleteList.add(bean.getSalesPlanNo());

                    break;

            }

        }

        resultMap.put("INSERT", insertList);
        resultMap.put("UPDATE", updateList);
        resultMap.put("DELETE", deleteList);

        return resultMap;
    }

    public String getNewSalesPlanNo(String salesPlanDate) {

        StringBuffer newEstimateNo = null;

        int newNo = salesPlanMapper.selectSalesPlanCount(salesPlanDate);

        newEstimateNo = new StringBuffer();

        newEstimateNo.append("SA");
        newEstimateNo.append(salesPlanDate.replace("-", ""));
        newEstimateNo.append(String.format("%02d", newNo)); // 2자리 숫자

        return newEstimateNo.toString();
    }

    @Override
    @Cacheable("getDeliveryInfoList") // radis 설정
    public ArrayList<DeliveryInfoResDto> getDeliveryInfoList() {

        ArrayList<DeliveryInfoResDto> deliveryInfoResDtoList = null;
        deliveryInfoResDtoList = deliveryMapper.selectDeliveryInfoList();

        return deliveryInfoResDtoList;
    }

    /*
    @Override
    public ModelMap batchDeliveryListProcess(List<DeliveryInfoEntity> deliveryTOList) {

        ModelMap resultMap = new ModelMap();

        ArrayList<String> insertList = new ArrayList<>();
        ArrayList<String> updateList = new ArrayList<>();
        ArrayList<String> deleteList = new ArrayList<>();

        for (DeliveryInfoEntity bean : deliveryTOList) {

            String status = bean.getStatus();

            switch (status.toUpperCase()) {

                case "INSERT":

                    String newDeliveryNo = "새로운";

                    bean.setDeliveryNo(newDeliveryNo);
                    deliveryMapper.insertDeliveryResult(bean);
                    insertList.add(newDeliveryNo);

                    break;

                case "UPDATE":

                    deliveryMapper.updateDeliveryResult(bean);

                    updateList.add(bean.getDeliveryNo());

                    break;

                case "DELETE":

                    deliveryMapper.deleteDeliveryResult(bean);

                    deleteList.add(bean.getDeliveryNo());

                    break;

            }

        }

        resultMap.put("INSERT", insertList);
        resultMap.put("UPDATE", updateList);
        resultMap.put("DELETE", deleteList);

        return resultMap;
    }
    */

    @Override
    public HashMap<String, Object> deliver(String contractDetailNo) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("contractDetailNo", contractDetailNo);

        deliveryMapper.deliver(map);

        HashMap<String, Object> resultMap = new ModelMap();
        resultMap.put("errorCode", map.get("ERROR_CODE"));
        resultMap.put("errorMsg", map.get("ERROR_MSG"));

        return resultMap;
    }

    @Override
    public ArrayList<ReverseResDto> getReturnAbleList(ReverseReqDto reverseReqDto) {

        ArrayList<ReverseResDto> ReturnAbleList = null;

        ReturnAbleList = deliveryMapper.selectReturnAbleList(reverseReqDto);

        return ReturnAbleList;
    }

    @Override
    public void insertReturnList(List<ReverseReqDto> reverseReqDtoList) {

        for (ReverseReqDto reverseReqDto : reverseReqDtoList) {
            if ("1".equals(reverseReqDto.getChecked())) {
                HashMap<String, String> map = new HashMap<>();
                map.put("deliveryNO", reverseReqDto.getDeliveryNO());
                map.put("itemCode", reverseReqDto.getItemCode());
                map.put("returnUnit", reverseReqDto.getReturnUnit());
                deliveryMapper.insertReturnList(map);
            }
        }
    }

    @Override
    public ArrayList<QuarterResDto> getSalesQuaChart() {

        return deliveryMapper.selectSalesQuaChart();
    }

}
