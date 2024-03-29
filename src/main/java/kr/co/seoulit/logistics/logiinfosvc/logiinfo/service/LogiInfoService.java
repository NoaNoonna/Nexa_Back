package kr.co.seoulit.logistics.logiinfosvc.logiinfo.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.logistics.logiinfosvc.logiinfo.dto.ItemGroupResDto;
import org.springframework.ui.ModelMap;

import kr.co.seoulit.logistics.logiinfosvc.logiinfo.to.ItemGroupTO;
import kr.co.seoulit.logistics.logiinfosvc.logiinfo.to.ItemInfoTO;
import kr.co.seoulit.logistics.logiinfosvc.logiinfo.to.ItemTO;
import kr.co.seoulit.logistics.logiinfosvc.logiinfo.to.WarehouseTO;

public interface LogiInfoService {

	public ArrayList<ItemInfoTO> getItemInfoList(String searchCondition, String[] paramArray);

	public ModelMap batchItemListProcess(ArrayList<ItemTO> itemTOList);

	public ArrayList<WarehouseTO> getWarehouseInfoList();

	public void batchWarehouseInfo(ArrayList<WarehouseTO> warehouseTOList);

	public String findLastWarehouseCode();

	public ItemTO getStandardUnitPrice(String itemCode);

	public int getStandardUnitPriceBox(String itemCode);

	/*
	 * #############################################################################
	 * #############################################################################
	 */


	//품목조회
	public ArrayList<ItemGroupResDto> searchItemList();
	//품목상세조회
	public ArrayList<ItemTO> getitemInfoList(String ableSearchConditionInfo);
	//품목그룹 조회
	public  ArrayList<ItemGroupTO> getitemGroupList(HashMap<String, String> ableSearchConditionInfo);
	//품목그룹 삭제
	public void getdeleteitemgroup(HashMap<String, String> ableSearchConditionInfo);
	//일괄처리
	public void getbatchSave(ArrayList<ItemTO> itemTOList);
}
