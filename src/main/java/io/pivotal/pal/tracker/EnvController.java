package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String cfInstanceIndex;
    private String cfInstanceAddr;

    /**
     * Construtor environment variables NOT SET init
     * @param port
     * @param memoryLimit
     * @param cfInstanceIndex
     * @param cfInstanceAddr
     */
    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memoryLimit,
                         @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
                         @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddr
                         )
    {
        this.port=port;
        this.memoryLimit=memoryLimit;
        this.cfInstanceIndex=cfInstanceIndex;
        this.cfInstanceAddr=cfInstanceAddr;
    }

    /**
     * getEnv from JUnit Test
     * gets environment variables from environment
     * @return
     */
    @GetMapping("/env")
    public Map<String, String> getEnv() {

        HashMap<String, String> envr = new HashMap<>();
        envr.put("PORT",this.port);
        envr.put("MEMORY_LIMIT",this.memoryLimit);
        envr.put("CF_INSTANCE_INDEX",this.cfInstanceIndex);
        envr.put("CF_INSTANCE_ADDR",this.cfInstanceAddr);

        return envr;
        }

}
