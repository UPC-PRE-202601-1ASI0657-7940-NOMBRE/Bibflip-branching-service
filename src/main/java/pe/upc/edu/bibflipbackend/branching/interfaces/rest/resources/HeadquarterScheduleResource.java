package pe.upc.edu.bibflipbackend.branching.interfaces.rest.resources;

public record HeadquarterScheduleResource(
        String openingTime,
        String closingTime,
        Integer intervalMinutes
) {
}

