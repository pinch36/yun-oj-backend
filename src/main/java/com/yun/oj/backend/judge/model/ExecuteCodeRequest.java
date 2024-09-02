package com.yun.oj.backend.judge.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/02/10:20
 * @Description:
 */
@Data
@Builder
public class ExecuteCodeRequest {
    private String code;
    private List<String> input;
    private String language;
}
