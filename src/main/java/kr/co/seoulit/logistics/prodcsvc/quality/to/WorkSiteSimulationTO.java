package kr.co.seoulit.logistics.prodcsvc.quality.to;

import kr.co.seoulit.logistics.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Dataset(name="gds_workSiteSimulation")
public class WorkSiteSimulationTO {

	private String workOrderNo;
	private String mrpNo;
	private String mpsNo;
	private String workSiteName;
	private String wdItem;
	private String parentItemCode;
	private String parentItemName;
	private String itemClassIfication;
	private String itemCode;
	private String itemName;
	private String requiredAmount;

}
