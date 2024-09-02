package com.yun.oj.backend.utils;

import com.yun.oj.backend.judge.codesandbox.CodeSandbox;
import com.yun.oj.backend.judge.model.JudgeInfo;
import com.yun.oj.backend.judge.model.ExecuteCodeRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/01/7:00
 * @Description:
 */
public class JudgeUtils {
    public static JudgeInfo judge(ExecuteCodeRequest executeCodeRequest) {
        try{
//            CodeSandbox codeSandBox = new CodeSandbox();
//            codeSandBox.setExecuteCodeRequest(executeCodeRequest);
//            JudgeInfo judgeInfo = codeSandBox.judge();
//            return judgeInfo;
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
