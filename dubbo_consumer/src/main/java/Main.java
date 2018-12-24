import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.api.service.DemoService;
import com.mob.applink.interfaces.AppConfServer;
import com.mob.applink.vo.ConfParamsVo;
import jdk.Exported;
import org.apache.thrift.TException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {
    @Reference
    AppConfServer server;
    public static void main(String[] args) throws TException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:springmvc.xml" });

        context.start();
//        DemoService demoService = (DemoService) context.getBean("demoService");
        AppConfServer.Iface AppConfServer = (AppConfServer.Iface) context.getBean("AppConfServer");

        ConfParamsVo confParamsVo=new ConfParamsVo();
        confParamsVo.setAppkey("moba6b6c6d6");
        confParamsVo.setApppkg("qweqwe0");
        System.out.println(AppConfServer.getConf(confParamsVo));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
