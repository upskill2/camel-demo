package routes.configs;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.configs")
public class AppPropertyConfigs {

    private String name;
    private boolean sendFiles;
    private String type;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public boolean isSendFiles () {
        return sendFiles;
    }

    public void setSendFiles (boolean sendFiles) {
        this.sendFiles = sendFiles;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }
}


