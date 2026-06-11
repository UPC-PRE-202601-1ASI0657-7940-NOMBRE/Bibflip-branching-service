package pe.upc.edu.bibflipbackend.branching.application.internal.feignclient;

import java.util.List;

public record UserDTO(
        Long id,
        String username,
        List<String> roles,
        String email
) {
}