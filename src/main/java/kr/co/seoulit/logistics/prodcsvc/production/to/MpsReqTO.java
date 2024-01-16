package kr.co.seoulit.logistics.prodcsvc.production.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class MpsReqTO implements Serializable {

    private String startDate;
    private String endDate;
    private String includeMrpApply;
}
