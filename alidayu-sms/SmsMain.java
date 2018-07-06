package storm.study.smstest;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

/**
 * Created by quchengguo on 2018/7/6.
 */
public class SmsMain {
    public static void main(String[] args) {
        SmsUtil smsUtil = new SmsUtil();
        try {
            SendSmsResponse sendSmsResponse = smsUtil.sendSms("发送给谁的手机号", "模板code", "小屈", "{\"code\":\"123456\"}");
            System.out.println(sendSmsResponse.getCode());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
