package pe.upc.edu.bibflipbackend.branching.interfaces.rest.transform;

import pe.upc.edu.bibflipbackend.branching.domain.model.aggregates.Headquarter;
import pe.upc.edu.bibflipbackend.branching.interfaces.rest.resources.HeadquarterScheduleResource;

import java.time.format.DateTimeFormatter;

public class HeadquarterScheduleResourceFromEntityAssembler {
    public static HeadquarterScheduleResource toResourceFromEntity(Headquarter entity) {
        return new HeadquarterScheduleResource(
                entity.getOpeningTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                entity.getClosingTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                entity.getIntervalMinutes()
        );
    }
}

