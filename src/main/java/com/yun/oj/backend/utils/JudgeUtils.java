package com.yun.oj.backend.utils;

import cn.hutool.http.HttpUtil;
import com.yun.oj.backend.judge.codesandbox.CodeSandbox;
import com.yun.oj.backend.judge.codesandbox.impl.RemoteCodeSandbox;
import com.yun.oj.backend.judge.model.JudgeInfo;
import com.yun.oj.backend.judge.model.ExecuteCodeRequest;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/01/7:00
 * @Description:
 */
public class JudgeUtils {
    @Resource
    private RemoteCodeSandbox remoteCodeSandbox;
    public static JudgeInfo judge(ExecuteCodeRequest executeCodeRequest) {
        try{

//            JudgeInfo judgeInfo = codeSandBox.judge();
//            return judgeInfo;
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
