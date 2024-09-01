package com.yun.oj.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.oj.backend.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yun.oj.backend.model.entity.Question;
import com.yun.oj.backend.model.entity.QuestionSubmit;
import com.yun.oj.backend.model.entity.User;
import com.yun.oj.backend.model.vo.QuestionSubmitVO;
import com.yun.oj.backend.model.vo.QuestionVO;
import com.yun.oj.backend.model.vo.UserVO;
import com.yun.oj.backend.service.QuestionService;
import com.yun.oj.backend.service.QuestionSubmitService;
import com.yun.oj.backend.mapper.QuestionSubmitMapper;
import com.yun.oj.backend.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
* @author ylw16
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2024-08-31 07:10:50
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{
    @Resource
    private UserService userService;
    @Resource
    private QuestionService questionService;

    @Override
    public void validQuestionSubmit(QuestionSubmit questionSubmit, boolean b) {

    }

    @Override
    public QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, HttpServletRequest request) {
        QuestionSubmitVO questionSubmitVO = QuestionSubmitVO.objToVo(questionSubmit);
        Long questionId = questionSubmitVO.getQuestionId();
        Question question = null;
        if (questionId != null && questionId > 0) {
            question = questionService.getById(questionId);
        }
        QuestionVO questionVO = questionService.getQuestionVO(question,request);
        questionSubmitVO.setUserVO(questionVO.getUserVO());
        questionSubmitVO.setQuestionVO(questionVO);
        return questionSubmitVO;
    }

    @Override
    public Wrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest) {
        return null;
    }

    @Override
    public Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, HttpServletRequest request) {
        return null;
    }
}




