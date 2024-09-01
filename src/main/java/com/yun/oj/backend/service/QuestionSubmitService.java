package com.yun.oj.backend.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yun.oj.backend.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yun.oj.backend.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.oj.backend.model.vo.QuestionSubmitVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author ylw16
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-08-31 07:10:50
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    void validQuestionSubmit(QuestionSubmit questionSubmit, boolean b);

    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, HttpServletRequest request);

    Wrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, HttpServletRequest request);
}
