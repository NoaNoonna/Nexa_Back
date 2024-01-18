package kr.co.seoulit.logistics.busisvc.logisales.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.logistics.busisvc.logisales.entity.*;

public interface LogisalesService {

	
	// EstimateApplicationServiceImpl
	public ArrayList<EstimateEntity> getEstimateList(String startDate,String endDate,String dateSearchCondition);

	public ArrayList<EstimateDetailEntity> getEstimateDetailList(EstimateEntity estimateReqDto);
	
	public HashMap<String, Object> addNewEstimate(EstimateEntity estimateReqDto);
	
	public HashMap<String, Object> removeEstimate(String estimateNo, String status);

	public void batchEstimateDetailListProcess(ArrayList<EstimateDetailEntity> estimateDetailReqDtos);
	
	
	// ContractApplicationServiceImpl
//	public ArrayList<ContractInfoResDto> getContractList(ContractInfoReqDto contractInfoReqDto);
	public ArrayList<ContractEntity> getContractList(String searchCondition,String startDate,String endDate,String customerCode);

	public ArrayList<ContractDetailEntity> getContractDetailList(String estimateNo);
	
	public ArrayList<EstimateEntity> getEstimateListInContractAvailable(String startDate,String endDate);

	public HashMap<String, Object> addNewContract(ContractEntity contractReqDto);

	public HashMap<String, Object> batchContractDetailListProcess(ArrayList<ContractDetailEntity> contractDetailEntityList);
	
	public void changeContractStatusInEstimate(String estimateNo , String contractStatus);

	public void cancelEstimate(EstimateEntity estimateReqDto);
	
}
