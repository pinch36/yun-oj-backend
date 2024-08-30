package com.yun.oj.backend.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yun.oj.backend.model.dto.question.QuestionQueryRequest;
import com.yun.oj.backend.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.oj.backend.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author ylw16
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2024-08-30 21:03:15
*/
public interface QuestionService extends IService<Question> {

    void validQuestion(Question question, boolean b);

    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    Wrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}
