package RememberPassword;

import javax.servlet.http.Cookie;

/**
 * Created by quchengguo on 2018/3/26.
 */
public class CookieUtils {
    private CookieUtils () {}

    /*
	 * 根据指定的cookie名称返回其对应的cookie对象
	 * 		参数：
	 * 			1.Cookie[]
	 * 			2.cookie的名称
	 * 		返回值：
	 * 			1.如果查找到了想要的cookie对象，返回这个cookie对象
	 * 			2.如果没有查找到想要的cookie对象，返回null
	 */
    public static Cookie getCookie(Cookie[] cs, String name){
        if(cs != null){
            for(int i = 0; i < cs.length; i++){
                if(cs[i].getName().equals(name)){
                    return cs[i];
                }
            }
        }
        return null;
    }
}
