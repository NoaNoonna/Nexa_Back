package kr.co.seoulit.logistics.busisvc.logisales.dto;

import kr.co.seoulit.logistics.logiinfosvc.compinfo.to.BaseTO;
import kr.co.seoulit.logistics.sys.annotation.Dataset;
import kr.co.seoulit.logistics.sys.annotation.RemoveColumn;
import lombok.Data;

import java.util.ArrayList;

@Data
@Dataset(name="gds_contractInfo")
public class ContractInfoResDto extends BaseTO {
    private String contractNo;
    private String estimateNo;
    private String contractType;
    private String contractTypeName;
    private String customerCode;
    private String customerName;
    private String estimateDate;
    private String contractDate;
    private String contractRequester;
    private String personCodeInCharge;
    private String empNameInCharge;
    private String description;
    private String deliveryCompletionStatus;
    @RemoveColumn
    private ArrayList<ContractDetailResDto> contractDetailResDtoList;
}
