package com.yun.oj.backend.service.impl;

import com.yun.oj.backend.model.entity.QuestionSubmit;
import com.yun.oj.backend.service.JudgeService;
import com.yun.oj.backend.service.QuestionSubmitService;
import com.yun.oj.backend.utils.JudgeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/01/6:56
 * @Description:
 */
@Service
@Slf4j
public class JudgeServiceImpl implements JudgeService {
    @Resource
    private QuestionSubmitService questionSubmitService;

    @Override
    public boolean judge(QuestionSubmit questionSubmit) {
        log.info("判题..");
        questionSubmit.setStatus(1);
        try {
            boolean judge = JudgeUtils.judge(questionSubmit.getCode());
            if (!judge) {
                questionSubmit.setStatus(3);
                return false;
            }
            questionSubmit.setStatus(2);
            return true;
        } catch (Exception e) {
            questionSubmit.setStatus(3);
            log.error("判题异常:{}", e);
            throw new RuntimeException(e);
        }
    }
}
