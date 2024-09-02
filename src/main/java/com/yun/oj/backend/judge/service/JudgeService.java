package com.yun.oj.backend.judge.service;

import com.yun.oj.backend.judge.model.JudgeInfo;
import com.yun.oj.backend.model.entity.QuestionSubmit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/01/6:55
 * @Description:
 */
public interface JudgeService {
    JudgeInfo judge(QuestionSubmit questionSubmit);
}
