package kr.co.seoulit.logistics.purcstosvc.stock.entity;

import kr.co.seoulit.logistics.logiinfosvc.compinfo.to.BaseTO;
import kr.co.seoulit.logistics.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="BOM")
@Dataset(name="gds_bom")
@EqualsAndHashCode(callSuper = false)
public class BOMEntity extends BaseTO {

    private String parentItemCode;
    @Id
    private String itemCode;
    private String no;
    private String netAmount;
    private String description;

}
