package extranet;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@LoginConfig(authMethod = "MP-JWT", realmName = "extranet")
@ApplicationPath("/extranet")
@ApplicationScoped
public class ExtranetApplication extends Application {

}
