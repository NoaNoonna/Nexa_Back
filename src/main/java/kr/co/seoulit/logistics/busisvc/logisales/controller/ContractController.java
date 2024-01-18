package kr.co.seoulit.logistics.busisvc.logisales.controller;

import com.nexacro.java.xapi.data.PlatformData;
import kr.co.seoulit.logistics.busisvc.logisales.entity.*;
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
public class ContractController {

	@Autowired
	private LogisalesService logisalesService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	public ContractController() {
	}

	@Description(value = "수주조회")
	@RequestMapping(value = "/contract/list")
	public void searchContract(@RequestAttribute("reqData") PlatformData reqData,
							   @RequestAttribute("resData") PlatformData resData) throws Exception {

//		ContractEntity contractInfoReqDto = new ContractEntity();
		String searchCondition = reqData.getVariableList().getString("searchCondition");
		String startDate = reqData.getVariableList().getString("startDate");
		String endDate = reqData.getVariableList().getString("endDate");
		String customerCode = reqData.getVariableList().getString("customerCode");

		ArrayList<ContractEntity> contractInfoResDtoList = logisalesService.getContractList(searchCondition,startDate,endDate,customerCode);

		List<ContractDetailEntity> contractDetailResDtoList = new ArrayList<>();

		for (ContractEntity contractInfoResDto : contractInfoResDtoList) {
			for (ContractDetailEntity contractDetailResDto : contractInfoResDto.getContractDetailEntityList()) {
				contractDetailResDtoList.add(contractDetailResDto);
			}
		}

		datasetBeanMapper.beansToDataset(resData, contractInfoResDtoList, ContractEntity.class);
		datasetBeanMapper.beansToDataset(resData, contractDetailResDtoList, ContractDetailEntity.class);

	}

	@Description(value = "수주가능한 견적조회")
	@RequestMapping(value = "/estimate/list/contractavailable")
	public void searchEstimateInContractAvailable(@RequestAttribute("reqData") PlatformData reqData,
												  @RequestAttribute("resData") PlatformData resData) throws Exception {

		String startDate = reqData.getVariable("startDate").getString();
		String endDate = reqData.getVariable("endDate").getString();

		ArrayList<EstimateEntity> estimateListInContractAvailable = logisalesService.getEstimateListInContractAvailable(startDate,endDate);

		List<EstimateDetailEntity> estimateDetailList = new ArrayList<>();

		for (EstimateEntity estimateResDto : estimateListInContractAvailable) {
			for (EstimateDetailEntity estimateDetailResDto : estimateResDto.getEstimateDetailEntityList()) {
				estimateDetailList.add(estimateDetailResDto);
			}
		}

		datasetBeanMapper.beansToDataset(resData, estimateListInContractAvailable, EstimateEntity.class);
		datasetBeanMapper.beansToDataset(resData, estimateDetailList, EstimateDetailEntity.class);

	}

	@Description(value = "수주등록")
	@RequestMapping(value = "/contract/new")
	public void addNewContract(@RequestAttribute("reqData") PlatformData reqData,
							   @RequestAttribute("resData") PlatformData resData) throws Exception {

		ContractEntity contractReqDto = datasetBeanMapper.datasetToBean(reqData, ContractEntity.class);
		contractReqDto.setContractDate(reqData.getVariable("contractDate").getString());
		contractReqDto.setPersonCodeInCharge(reqData.getVariable("personCodeInCharge").getString());

		List<ContractDetailEntity> contractDetailReqDtoList = datasetBeanMapper.datasetToBeans(reqData, ContractDetailEntity.class);
		contractReqDto.setContractDetailEntityList(contractDetailReqDtoList);

		HashMap<String, Object> map = logisalesService.addNewContract(contractReqDto);

		resData.getVariableList().add("g_procedureCode", map.get("errorCode"));
		resData.getVariableList().add("g_procedureMsg", map.get("errorMsg"));
	}

	@Description(value = "견적삭제")
	@RequestMapping(value = "/estimate/list/cancelEstimate")
	public void deleteEstimate(@RequestAttribute("reqData") PlatformData reqData,
							   @RequestAttribute("resData") PlatformData resData) throws Exception {

		EstimateEntity estimateReqDto = new EstimateEntity();
		List<EstimateDetailEntity> estimateDetailReqDtoList = datasetBeanMapper.datasetToBeans(reqData, EstimateDetailEntity.class);
		estimateReqDto.setEstimateNo(reqData.getVariableList().getString("estimateNo"));
		estimateReqDto.setEstimateDetailEntityList(estimateDetailReqDtoList);
		logisalesService.cancelEstimate(estimateReqDto);
	}
}
