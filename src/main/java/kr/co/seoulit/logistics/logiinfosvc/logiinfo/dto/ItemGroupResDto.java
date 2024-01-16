package kr.co.seoulit.logistics.logiinfosvc.logiinfo.dto;

import kr.co.seoulit.logistics.sys.annotation.Dataset;
import lombok.Data;

import java.io.Serializable;


@Data
@Dataset(name="ds_itemGroup")
public class ItemGroupResDto implements Serializable {
    private String itemGroupCode;
    private String description;
    private String itemGroupName;

}
