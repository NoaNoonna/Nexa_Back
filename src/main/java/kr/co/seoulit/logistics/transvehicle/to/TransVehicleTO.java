package kr.co.seoulit.logistics.transvehicle.to;

import kr.co.seoulit.logistics.logiinfosvc.compinfo.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TransVehicleTO extends BaseTO{
    private String vehicleNumber;
    private String type;
    private String manufacturingCompany;
    private String yearOfManufacture;
    private String loadCapacity;
    private String maintenanceDate;
    private String operator;
    private String fuelType;
    private String transportationStatus;
}