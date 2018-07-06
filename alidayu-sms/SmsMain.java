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
             if("OK".equalsIgnoreCase(sendSmsResponse.getCode())){
                System.out.println("发送成功");
            }else {
                System.out.println("发送失败，失败原因：" +  sendSmsResponse.getMessage());
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
