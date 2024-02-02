package kr.co.seoulit.logistics.busisvc.sales.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.seoulit.logistics.logiinfosvc.compinfo.to.BaseTO;
import kr.co.seoulit.logistics.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="RELEASE")
@Dataset(name="gds_releaseInfo")
public class ReleaseInfoEntity extends BaseTO implements Serializable {

	@Id
    private String releaseNo;
    private String contractDetailNo;
    private String customerName;
    private String itemCode;
    private String itemName;
    private String registerDate;
    private String dueDate;
    private String plannedReleaseDate;
    private String unitOfStock;
    private String releaseAmount;
    private String personInCharge;
    private String warehouseCode;
    private String inspectionStatus;

}
