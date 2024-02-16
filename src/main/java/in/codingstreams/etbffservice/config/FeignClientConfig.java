package in.codingstreams.etbffservice.config;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
  @Bean
  public OkHttpClient okHttpClient(){
    return new OkHttpClient();
  }
}
