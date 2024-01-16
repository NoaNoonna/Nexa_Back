package kr.co.seoulit.logistics.prodcsvc.production.to;

import kr.co.seoulit.logistics.logiinfosvc.compinfo.to.BaseTO;
import kr.co.seoulit.logistics.sys.annotation.Dataset;
import lombok.Data;

import java.io.Serializable;

@Data
@Dataset(name = "gds_mps")
public class MpsResTO extends BaseTO implements Serializable {

    private String mpsNo;
    private String mpsPlanClassification;
    private String contractDetailNo;
    private String salesPlanNo;
    private String itemCode;
    private String itemName;
    private String unitOfMps;
    private String mpsPlanDate;
    private String mpsPlanAmount;
    private String dueDateOfMps;
    private String scheduledEndDate;
    private String mrpApplyStatus;
    private String description;
    private String operationCompleted;
    private String checked;

}
