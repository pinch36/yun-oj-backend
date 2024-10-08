package com.yun.oj.backend.controller;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yun.oj.backend.common.BaseResponse;
import com.yun.oj.backend.common.ErrorCode;
import com.yun.oj.backend.common.ResultUtils;
import com.yun.oj.backend.exception.BusinessException;
import com.yun.oj.backend.exception.ThrowUtils;

import com.yun.oj.backend.judge.model.JudgeInfo;
import com.yun.oj.backend.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yun.oj.backend.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yun.oj.backend.model.entity.QuestionSubmit;
import com.yun.oj.backend.model.entity.User;
import com.yun.oj.backend.model.vo.QuestionSubmitVO;
import com.yun.oj.backend.judge.service.JudgeService;
import com.yun.oj.backend.service.QuestionSubmitService;
import com.yun.oj.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 问题接口
 *

 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;
    @Resource
    private JudgeService judgeService;

    // region 增删改查

    /**
     * 提交
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return
     */
    @PostMapping("/submit")
    public BaseResponse<QuestionSubmitVO> addQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest, HttpServletRequest request) {
        if (questionSubmitAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        BeanUtils.copyProperties(questionSubmitAddRequest, questionSubmit);
//        questionSubmit.setCode("public class Main {\n" +
//                "    public static void main(String[] args) {\n" +
//                "        int a = Integer.parseInt(args[0]);\n" +
//                "        int b = Integer.parseInt(args[1]);\n" +
//                "        System.out.println(a + b);\n" +
//                "    }\n" +
//                "}\n");
        questionSubmitService.validQuestionSubmit(questionSubmit, true);
        User loginUser = userService.getLoginUser(request);
        questionSubmit.setUserId(loginUser.getId());
        questionSubmit.setStatus(0);
        boolean save = questionSubmitService.save(questionSubmit);
        ThrowUtils.throwIf(!save, ErrorCode.OPERATION_ERROR);
        QuestionSubmit questionSubmitResult = judgeService.judge(questionSubmit);
        QuestionSubmitVO questionSubmitVO = questionSubmitService.getQuestionSubmitVO(questionSubmitResult, request);
        return ResultUtils.success(questionSubmitVO);
    }


    /**
     * 分页获取列表（封装类）
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitVOByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                               HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, request));
    }


}
