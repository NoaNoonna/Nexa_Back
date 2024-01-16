package kr.co.seoulit.logistics.logiinfosvc.logiinfo.dto;


import kr.co.seoulit.logistics.logiinfosvc.compinfo.to.BaseTO;
import kr.co.seoulit.logistics.sys.annotation.Dataset;
import lombok.Data;

@Data
@Dataset(name="gds_itemGroup")
public class ItemGroupReqDto extends BaseTO {

    private String itemGroupCode;
    private String description;
    private String itemGroupName;


}
