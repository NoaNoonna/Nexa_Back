package kr.co.seoulit.logistics.purcstosvc.purchase.to;

import kr.co.seoulit.logistics.sys.annotation.Dataset;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name="ORDER_DIALOG_TEMP")
@Dataset(name="gds_orderDialogTemp")
public class OrderDialogTempTO {

	private String mrpGatheringNo;
	private String itemCode;
	private String itemName;
	private String unitOfMrp;
	private String requiredAmount;
	private String stockAmount;
	private String calculatedRequiredAmount;
	private String standardUnitPrice;
	private String sumPrice;

}
