package kr.co.seoulit.logistics.busisvc.logisales.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.logistics.busisvc.logisales.entity.EstimateDetailEntity;
import kr.co.seoulit.logistics.busisvc.logisales.entity.EstimateEntity;
import kr.co.seoulit.logistics.busisvc.logisales.service.LogisalesService;
import kr.co.seoulit.logistics.sys.util.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/logisales/*")
public class EstimateController {

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;
    @Autowired
    private LogisalesService logisalesService;

    @Description(value = "견적조회/수정 : 견적조회")
    @RequestMapping(value = "/estimate/list")
    public void searchEstimateInfo(@RequestAttribute("reqData") PlatformData reqData,
                                   @RequestAttribute("resData") PlatformData resData) throws Exception {
//        MaBatis
        String startDate = reqData.getVariable("startDate").getString();
        String endDate = reqData.getVariable("endDate").getString();
        String dateSearchCondition = reqData.getVariable("dateSearchCondition").getString();

        ArrayList<EstimateEntity> estimateResDtoList = logisalesService.getEstimateList(startDate, endDate, dateSearchCondition);
        ArrayList<EstimateDetailEntity> estimateDetailResDtoList = new ArrayList<>();

        for (EstimateEntity estimateResDto : estimateResDtoList) { // estimate 개수만큼 돌려서
            for (EstimateDetailEntity estimateDetailResDto : estimateResDto.getEstimateDetailEntityList()) {
                estimateDetailResDtoList.add(estimateDetailResDto); // 빈 디테일리스트에 estimateResDto의 EstimateDetailList를 넣어줌
            }
        }

        datasetBeanMapper.beansToDataset(resData, estimateResDtoList, EstimateEntity.class);
        datasetBeanMapper.beansToDataset(resData, estimateDetailResDtoList, EstimateDetailEntity.class);

//        JPA
//        EstimateReqDto estimateReqDto = new EstimateReqDto();
//        estimateReqDto.setDateSearchCondition(reqData.getVariable("dateSearchCondition").getString());
//        estimateReqDto.setStartDate(reqData.getVariable("startDate").getString());
//        estimateReqDto.setEndDate(reqData.getVariable("endDate").getString());
//
//        ArrayList<EstimateEntity> estimateEntityList = logisalesService.getEstimateList(estimateReqDto);
//        ArrayList<EstimateDetailResDto> estimateDetailResDtoList = new ArrayList<>();
//
//        for (EstimateEntity estimateEntity : estimateEntityList) {
//            ArrayList<EstimateDetailResDto> estimateDetailResDtos =
//                    (ArrayList<EstimateDetailResDto>) estimateDetailResMapstruct.toDto(estimateEntity.getEstimateDetailEntityList());
//            estimateDetailResDtoList.addAll(estimateDetailResDtos);
//        }
//        ArrayList<EstimateResDto> estimateResDtoList = estimateResMapstruct.toDto(estimateEntityList);
//
//        datasetBeanMapper.beansToDataset(resData, estimateResDtoList, EstimateResDto.class);
//        datasetBeanMapper.beansToDataset(resData, estimateDetailResDtoList, EstimateDetailResDto.class);
    }

    @Description(value = "견적등록 : 일괄저장")
    @RequestMapping(value = "/estimate/new")
    public void addNewEstimate(@RequestAttribute("reqData") PlatformData reqData,
                               @RequestAttribute("resData") PlatformData resData ) throws Exception {

        EstimateEntity newEstimateReqDto = datasetBeanMapper.datasetToBean(reqData, EstimateEntity.class);
        List<EstimateDetailEntity> newEstimateDetailReqDto = datasetBeanMapper.datasetToBeans(reqData, EstimateDetailEntity.class);

        newEstimateReqDto.setEstimateDetailEntityList(newEstimateDetailReqDto);
        HashMap<String, Object> resultList = logisalesService.addNewEstimate(newEstimateReqDto);

        EstimateEntity estimateResDto = new EstimateEntity();
        estimateResDto.setEstimateNo(resultList.get("newEstimateNo").toString());

        resData.getVariableList().add("EstimateDtNo", resultList.get("newEstimateDetailNo").toString());
        datasetBeanMapper.beanToDataset(resData, estimateResDto, EstimateEntity.class);

        /*
        EstimateEntity newEstimateEntity = datasetBeanMapper.datasetToBean(reqData, EstimateEntity.class);
        List<EstimateDetailEntity> newEstimateDeatailEntity = datasetBeanMapper.datasetToBeans(reqData, EstimateDetailEntity.class);
        String estimateDate = newEstimateEntity.getEstimateDate();

        newEstimateEntity.setEstimateDetailEntityList(newEstimateDeatailEntity);
        // HashMap<String, Object> resultList =
        logisalesService.addNewEstimate(estimateDate, newEstimateEntity);

        // EstimateTO estimateTO = new EstimateTO();
        // estimateTO.setEstimateNo(resultList.get("newEstimateNo").toString());

        // resData.getVariableList().add("EstimateDtNo", resultList.get("INSERT").toString());
        // datasetBeanMapper.beanToDataset(resData, estimateTO, EstimateTO.class);
        */
    }

    @Description(value = "견적조회/수정 : 일괄저장")
    @RequestMapping(value = "/estimatedetail/batch")
    public void batchListProcess(@RequestAttribute("reqData") PlatformData reqData) throws Exception {

        ArrayList<EstimateDetailEntity> estimateDetailReqDtos =
                (ArrayList<EstimateDetailEntity>) datasetBeanMapper.datasetToBeans(reqData, EstimateDetailEntity.class);

        logisalesService.batchEstimateDetailListProcess(estimateDetailReqDtos);
    }
}
