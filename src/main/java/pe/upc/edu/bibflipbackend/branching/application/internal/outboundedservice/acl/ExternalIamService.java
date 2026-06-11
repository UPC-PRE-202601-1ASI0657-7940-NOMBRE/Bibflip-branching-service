package pe.upc.edu.bibflipbackend.branching.application.internal.outboundedservice.acl;

//import pe.upc.edu.bibflipbackend.iam.interfaces.acl.IamContextFacade;
import feign.FeignException;
import org.springframework.stereotype.Service;
import pe.upc.edu.bibflipbackend.branching.application.internal.feignclient.IAMClient;
import pe.upc.edu.bibflipbackend.branching.application.internal.feignclient.UserDTO;

@Service
public class ExternalIamService {

    private final IAMClient iamClient;

    public ExternalIamService(IAMClient iamClient) {
        this.iamClient = iamClient;
    }

    public boolean userExists(Long userId) {
        try {
            iamClient.getUserById(userId);
            return true;
        } catch (FeignException.NotFound exception) {
            return false;
        }
    }

    public UserDTO getUserById(Long userId) {
        return iamClient.getUserById(userId);
    }

    public String getUsername(Long userId) {
        return getUserById(userId).username();
    }

    public String getMainRole(Long userId) {
        var user = getUserById(userId);

        if (user.roles() == null || user.roles().isEmpty()) {
            return null;
        }

        return user.roles().get(0);
    }

    public boolean userHasRole(Long userId, String role) {
        var user = getUserById(userId);

        if (user.roles() == null) {
            return false;
        }

        return user.roles().contains(role);
    }

    public boolean isSupervisor(Long userId) {
        return userHasRole(userId, "ROLE_SUPERVISOR");
    }

    public boolean isAdmin(Long userId) {
        return userHasRole(userId, "ROLE_ADMIN");
    }
}