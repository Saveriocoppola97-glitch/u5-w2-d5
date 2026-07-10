package save.u5_w2_d5.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary getCloudinaryUploader() {

        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "TUO_NOME_CLOUD");
        config.put("api_key", "TUA_API_KEY");
        config.put("api_secret", "TUA_API_SECRET");
        return new Cloudinary(config);
    }
}