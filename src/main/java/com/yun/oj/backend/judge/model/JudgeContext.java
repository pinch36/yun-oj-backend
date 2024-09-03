package com.yun.oj.backend.judge.model;

import com.yun.oj.backend.model.dto.question.JudgeCase;
import com.yun.oj.backend.model.entity.Question;
import com.yun.oj.backend.model.entity.QuestionSubmit;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/03/19:16
 * @Description:
 */
@Data
@Builder
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> input;

    private List<String> output;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
