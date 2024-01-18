package kr.co.seoulit.logistics.busisvc.logisales.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.logistics.busisvc.logisales.entity.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContractMapper {

	public ArrayList<EstimateEntity> selectEstimateListInContractAvailable(String startDate, String endDate);

	public ArrayList<ContractEntity> selectContractList(String searchCondition, String startDate, String endDate, String customerCode);
	
	public ArrayList<ContractEntity> selectDeliverableContractList(HashMap<String, String> ableSearchConditionInfo);
	
	public int selectContractCount(String contractDate);

	public void insertContract(ContractEntity TO);

	public void updateContract(ContractEntity TO);

	public void deleteContract(ContractEntity TO);
	
	
	//ContractDetail
	public ArrayList<ContractDetailEntity> selectContractDetailList(String contractNo);
	
	public ArrayList<ContractEntity> selectDeliverableContractListByCondition(HashMap<String,String> map);
	
	public ArrayList<ContractDetailEntity> selectDeliverableContractDetailList(String contractNo);
	
	public int selectContractDetailCount(String contractNo);

	public ArrayList<ContractDetailEntity> selectContractDetailListInMpsAvailable(
			HashMap<String, String> map);

	public void changeMpsStatusOfContractDetail(HashMap<String, String> map);

	public void deleteContractDetail(ContractDetailEntity TO);
	
	public void insertContractDetail(HashMap<String,Object>  workingContractList);

}
