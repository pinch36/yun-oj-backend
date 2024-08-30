package com.yun.oj.backend.model.dto.question;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *

 */
@Data
public class QuestionUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 题目提交数
     */
    private Integer submitNum;

    /**
     * 题目通过数
     */
    private Integer acceptedNum;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    private static final long serialVersionUID = 1L;
}