package by.wms.server.Entity.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestStatus {

    PROCESSING("processing"),
    ACCEPTED("accepted"),
    DENIED("denied"),
    ;

    private final String name;
}
