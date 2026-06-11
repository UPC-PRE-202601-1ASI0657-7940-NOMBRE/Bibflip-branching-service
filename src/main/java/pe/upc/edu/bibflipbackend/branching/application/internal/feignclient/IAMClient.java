package pe.upc.edu.bibflipbackend.branching.application.internal.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${feign.client.iam.name}")
public interface IAMClient {

    @GetMapping("/api/v1/users/{userId}")
    UserDTO getUserById(@PathVariable("userId")  Long userId);
}
