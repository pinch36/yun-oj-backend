package com.yun.oj.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.oj.backend.constant.CommonConstant;
import com.yun.oj.backend.mapper.QuestionMapper;
import com.yun.oj.backend.model.dto.question.QuestionQueryRequest;
import com.yun.oj.backend.model.entity.Question;
import com.yun.oj.backend.model.vo.QuestionVO;
import com.yun.oj.backend.service.QuestionService;
import com.yun.oj.backend.utils.SqlUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ylw16
 * @description 针对表【question(题目)】的数据库操作Service实现
 * @createDate 2024-08-30 21:03:15
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
        implements QuestionService {

    @Override
    public void validQuestion(Question question, boolean b) {
        return;
    }

    @Override
    public QuestionVO getQuestionVO(Question question, HttpServletRequest request) {
        QuestionVO questionVO = new QuestionVO();
        questionVO.setFavourNum(question.getFavourNum());
        questionVO.setContent(question.getContent());
        questionVO.setTags(question.getTags());
        questionVO.setAcceptedNum(question.getAcceptedNum());
        questionVO.setCreateTime(question.getCreateTime());
        questionVO.setJudgeCase(question.getJudgeCase());
        questionVO.setTitle(question.getTitle());
        questionVO.setThumbNum(questionVO.getThumbNum());
        questionVO.setUpdateTime(question.getUpdateTime());
        questionVO.setUserId(questionVO.getUserId());
        questionVO.setSubmitNum(questionVO.getSubmitNum());
        return questionVO;
    }

    @Override
    public Wrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        if (questionQueryRequest == null) {
            return queryWrapper;
        }
        Long id = questionQueryRequest.getId();
        String title = questionQueryRequest.getTitle();
        Long userId = questionQueryRequest.getUserId();
        String sortField = questionQueryRequest.getSortField();
        String sortOrder = questionQueryRequest.getSortOrder();
        String tags = questionQueryRequest.getTags();
        // 拼接查询条件
        queryWrapper.like(StringUtils.isNotBlank(title), "title", title);
        queryWrapper.like(StringUtils.isNotBlank(tags),"tags", tags);
        queryWrapper.eq(ObjectUtils.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq("isDelete", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

    @Override
    public Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request) {
        Page<QuestionVO> questionVOPage = new Page<>(questionPage.getCurrent(), questionPage.getSize());
        List<QuestionVO> questionVOList = questionPage.getRecords().stream().map(question -> getQuestionVO(question, request)).collect(Collectors.toList());
        questionVOPage.setRecords(questionVOList);
        return questionVOPage;
    }
}




