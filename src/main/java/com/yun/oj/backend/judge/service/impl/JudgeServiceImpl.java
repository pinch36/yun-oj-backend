package com.yun.oj.backend.judge.service.impl;

import com.yun.oj.backend.common.ErrorCode;
import com.yun.oj.backend.exception.BusinessException;
import com.yun.oj.backend.judge.model.JudgeInfo;
import com.yun.oj.backend.judge.model.ExecuteCodeRequest;
import com.yun.oj.backend.model.entity.Question;
import com.yun.oj.backend.model.entity.QuestionSubmit;
import com.yun.oj.backend.judge.service.JudgeService;
import com.yun.oj.backend.service.QuestionService;
import com.yun.oj.backend.service.QuestionSubmitService;
import com.yun.oj.backend.utils.JudgeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

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
    @Resource
    private QuestionService questionService;

    @Override
    public JudgeInfo judge(QuestionSubmit questionSubmit) {
        log.info("判题..");
        update(questionSubmit.getId(),1,"更新提交状态为判题中失败");
        Question question = questionService.getById(questionSubmit.getQuestionId());
        try {
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .input(Collections.singletonList(question.getJudgeCase()))
                    .code(questionSubmit.getCode())
                    .language(questionSubmit.getLanguage())
                    .build();
            JudgeInfo judgeInfo = JudgeUtils.judge(executeCodeRequest);
            update(questionSubmit.getId(),2,"更新提交状态为判题成功失败");
            return judgeInfo;
        } catch (Exception e) {
            update(questionSubmit.getId(),3,"更新提交状态为判题失败失败");
            log.error("判题异常:", e);
            throw new RuntimeException(e);
        }
    }
    private void update(Long questionSubmitId, Integer status, String message){
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(status);
        boolean update = questionSubmitService.updateById(questionSubmitUpdate);
        if (!update) {
            questionSubmitUpdate.setStatus(3);
            update = questionSubmitService.updateById(questionSubmitUpdate);
            if (!update){
                throw new BusinessException(ErrorCode.SYSTEM_ERROR,"更新提交状态为判题失败失败");
            }
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,message);
        }
    }
}
