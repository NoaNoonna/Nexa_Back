package kr.co.seoulit.logistics.busisvc.sales.to;

import kr.co.seoulit.logistics.logiinfosvc.compinfo.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class SalesPlanEntity extends BaseTO {
	@Id
	private String salesPlanNo;
	 private int unitPriceOfSales;
	 private int salesAmount;
	 private String description;
	 private String salesPlanDate;
	 private int sumPriceOfSales;
	 private String itemCode;
	 private String dueDateOfSales;
	 private String unitOfSales;
	 private String mpsApplyStatus;
	 private String itemName;

}