package com.yun.oj.backend.judge.codesandbox;

import com.yun.oj.backend.judge.model.ExecuteCodeRequest;
import com.yun.oj.backend.judge.model.ExecuteCodeResponse;

/**
 * Created with IntelliJ IDEA.
 * @Author: __yun
 * @Date: 2024/09/02/20:13
 * @Description: 
 */public interface CodeSandbox {
     ExecuteCodeResponse execute(ExecuteCodeRequest executeCodeRequest);
}
