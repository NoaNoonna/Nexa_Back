package kr.co.seoulit.logistics.busisvc.sales.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.logistics.busisvc.logisales.dto.ContractDetailResDto;
import kr.co.seoulit.logistics.busisvc.logisales.dto.ContractInfoResDto;
import kr.co.seoulit.logistics.busisvc.sales.dto.*;
import kr.co.seoulit.logistics.busisvc.sales.service.SalesService;
import kr.co.seoulit.logistics.busisvc.sales.to.ReleaseInfoTO;
import kr.co.seoulit.logistics.sys.util.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/sales/*")
public class ReleaseController {

    @Autowired
    private SalesService salesService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

//    ModelMap map = null;
//    private static Gson gson = new GsonBuilder().serializeNulls().create();

    @Description(value = "출고가능수주조회")
    @RequestMapping(value = "/release/list/contractAvailable")
    public void searchReleaseContractList(@RequestAttribute("reqData") PlatformData reqData,
                                          @RequestAttribute("resData") PlatformData resData) throws Exception {

        HashMap<String, String> map = new HashMap<>();
        map.put("searchCondition", reqData.getVariable("searchCondition").getString());
        map.put("startDate", reqData.getVariable("startDate").getString());
        map.put("endDate", reqData.getVariable("endDate").getString());
        map.put("customerCode", reqData.getVariable("customerCode").getString());

        ArrayList<ContractInfoResDto> releaseInfoResDtoList = salesService.getReleaseContractList(map);

        ArrayList<ContractDetailResDto> releaseContractDetailList = new ArrayList<>();
        for (ContractInfoResDto contract : releaseInfoResDtoList) {
            for (ContractDetailResDto contractDetailResDto : contract.getContractDetailResDtoList()) {
                releaseContractDetailList.add(contractDetailResDto);
            }
        }

        datasetBeanMapper.beansToDataset(resData, releaseInfoResDtoList, ContractInfoResDto.class);
        datasetBeanMapper.beansToDataset(resData, releaseContractDetailList, ContractDetailResDto.class);
    }

    @Description(value = "출고등록")
    @RequestMapping(value = "/releaseRegist")
    public void releaseRegist(@RequestAttribute("reqData") PlatformData reqData,
                             @RequestAttribute("resData") PlatformData resData) throws Exception {

        String contractDetailNo = reqData.getVariable("contractDetailNo").getString();
//        ArrayList<OutputInfoReqDto> outputInfoReqDtoList = salesService.insertOutputInfoList();
//        datasetBeanMapper.datasetToBean(reqData, outputInfoReqDtoList, OutputInfoReqDto.class);
        HashMap<String, Object> resultMap = salesService.releaseRegist(contractDetailNo);
        resData.getVariableList().add("g_procedureMsg", resultMap.get("errorMsg"));
    }

    @Description(value = "출고현황조회")
    @RequestMapping(value = "/releaseRegist/list")
    public void searchReleaseInfoList(@RequestAttribute("reqData") PlatformData reqData,
                                      @RequestAttribute("resData") PlatformData resData) throws Exception {

       ArrayList<ReleaseInfoResDto> releaseInfoResDtoList = salesService.getReleaseInfoList();
        datasetBeanMapper.beansToDataset(resData, releaseInfoResDtoList, ReleaseInfoResDto.class);
    }

    @Description(value = "출고현황수정 : 저장")
    @RequestMapping(value = "/update/releaseInfo")
    public void updateReleaseInfo(@RequestAttribute("reqData") PlatformData reqData,
                                  @RequestAttribute("resData") PlatformData resData) throws Exception {

        String releaseNo = reqData.getVariableList().getString("releaseNo");

        ArrayList<ReleaseInfoTO> releaseInfoList = (ArrayList<ReleaseInfoTO>) datasetBeanMapper.datasetToBeans(reqData, ReleaseInfoTO.class);
            salesService.updateReleaseInfo(releaseInfoList);
    }

    @Description(value = "출고현황삭제")
    @RequestMapping(value = "/delete/releaseInfo")
    public void deleteReleaseInfo(@RequestAttribute("reqData") PlatformData reqData,
                                  @RequestAttribute("resData") PlatformData resData) throws Exception {


        String releaseNo = reqData.getVariable("releaseNo").getString();

        System.out.println("releaseNo = " + releaseNo);

        salesService.deleteReleaseInfo(releaseNo);
    }
}
