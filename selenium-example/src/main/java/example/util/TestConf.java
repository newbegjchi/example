package example.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Map;

public class TestConf {

    private static final Config BASE_CONF = ConfigFactory.load();
    private static final ObjectMapper MAPPER = buildMapper();
    private static final TestConf EXTERNAL_CONF = buildConfSingleton(BASE_CONF);
    private String baseUrl;
    private String userName;
    private String password;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static TestConf getBaseConf() {
        return EXTERNAL_CONF;
    }

    private static ObjectMapper buildMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    private static TestConf buildConfSingleton(Config config){
        Map<String, Object> unwrapped = config.root().unwrapped();
        TestConf testConf = MAPPER.convertValue(unwrapped, TestConf.class);
        return testConf;
    }


}
