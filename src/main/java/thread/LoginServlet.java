package thread;

import java.util.concurrent.TimeUnit;

/**
 * 本类模拟一个Servlet组件
 */
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username, String password){
        try {
            usernameRef = username;
            passwordRef = password;

            if("a".equals(usernameRef)){
                TimeUnit.SECONDS.sleep(5);
            }
            passwordRef = password;
            System.out.println("username:"+usernameRef+" passwordRef:"+passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
