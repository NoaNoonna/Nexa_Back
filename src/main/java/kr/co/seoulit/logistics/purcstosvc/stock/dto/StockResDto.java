package kr.co.seoulit.logistics.purcstosvc.stock.dto;

import kr.co.seoulit.logistics.logiinfosvc.compinfo.to.BaseTO;
import kr.co.seoulit.logistics.sys.annotation.Dataset;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Dataset(name="gds_stock")
public class StockResDto extends BaseTO implements Serializable {
    private String warehouseCode;
    @Id
    private String itemCode;
    private String itemName;
    private String unitOfStock;
    private String safetyAllowanceAmount;
    private String stockAmount;
    private String orderAmount;
    private String inputAmount;
    private String totalStockAmount;
}
