package gateway.config;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 根据请求的HTTP Header中的env-expect对应的值，代理到不同的环境中.
 * Header中env-strategy对应 must/should，代表环境是否可信。
 */
@Component
public class EnvMetadataRule extends ZoneAvoidanceRule {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *
     * @param key
     * @return
     */
    @Override
    public Server choose(Object key) {

//        return  null;
        //1.从线程变量获取version信息
        String version = MDC.get("user_env");
        String reqId = MDC.get("req_id");
//        logger.info("version from MDC: " + version);


        //2.获取服务实例列表
        List<Server> serverList = getPredicate().getEligibleServers(this.getLoadBalancer().getAllServers(), key);

        //3.循环serverList，选择version匹配的服务并返回
        for (Server server : serverList) {
            Map<String, String> metadata = ((DiscoveryEnabledServer) server).getInstanceInfo().getMetadata();
//            System.out.println("metadata: " + metadata);
            String metaEnv = metadata.get("env");
            if (!StringUtils.isEmpty(metaEnv)) {
                if (metaEnv.equals(version)) {
                    logger.info("use from MDC: " + version + "; reqID: " + reqId);
//                    System.out.println("ok - get the env");
                    return server;
                }
            }
        }

        logger.error("not_use from MDC: " + version);

//        return serverList.get(0);
        throw new RuntimeException("not_use from MDC: " + version);
    }
}