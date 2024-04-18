package by.wms.server.Entity.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UsersTitle {

    DIRECTOR("director"),
    RECEIVER("receiver"),
    SUPPLIER("supplier"),
    RECIPIENT("recipient"),
    ;

    private final String title;

}
