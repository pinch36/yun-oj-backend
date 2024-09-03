package com.yun.oj.backend.judge.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/02/10:03
 * @Description:
 */
@Data
public class JudgeInfo {
   private Long timeout;
   private Long memory;
   private String result;
}
