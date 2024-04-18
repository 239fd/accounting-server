package by.wms.server.DTO;

import by.wms.server.Entity.Users;
import lombok.Data;

import java.util.Date;

@Data
public class RequestDTO {

    private String status;
    private Date date;
    private Users users;


}
