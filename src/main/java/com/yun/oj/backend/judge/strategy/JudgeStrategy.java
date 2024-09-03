package com.yun.oj.backend.judge.strategy;

import com.yun.oj.backend.judge.model.JudgeContext;
import com.yun.oj.backend.judge.model.JudgeInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/03/19:16
 * @Description:
 */
public interface JudgeStrategy {
    JudgeInfo judge(JudgeContext judgeContext);
}
