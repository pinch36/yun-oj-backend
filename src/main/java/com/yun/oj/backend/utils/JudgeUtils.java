package com.yun.oj.backend.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/01/7:00
 * @Description:
 */
public class JudgeUtils {
    public static boolean judge(String code) {
        try{
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
