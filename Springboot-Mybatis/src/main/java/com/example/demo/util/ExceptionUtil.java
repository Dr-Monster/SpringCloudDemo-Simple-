package com.example.demo.util;

/**
 * @author yangle
 * @date 2017/11/28
 */
public class ExceptionUtil {
    /**
     * <p>
     * 将异常堆栈信息以字符串的格式返回
     * </p>
     *
     * @param e 异常对象
     * @return
     */
    public static String createStackTrackMessage(Exception e) {
        StringBuilder messsage = new StringBuilder();
        if (e != null) {
            messsage.append(e.getClass()).append(": ").append(e.getMessage()).append("\n");
            StackTraceElement[] elements = e.getStackTrace();
            for (StackTraceElement stackTraceElement : elements) {
                messsage.append("\t").append(stackTraceElement.toString()).append("\n");
            }
        }
        return messsage.toString();
    }
    private ExceptionUtil(){}
}
