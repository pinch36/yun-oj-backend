package com.yun.oj.backend.judge.manager;

import com.yun.oj.backend.judge.model.JudgeContext;
import com.yun.oj.backend.judge.model.JudgeInfo;
import com.yun.oj.backend.judge.strategy.DefaultJudgeStrategy;
import com.yun.oj.backend.judge.strategy.JavaJudgeStrategy;
import com.yun.oj.backend.judge.strategy.JudgeStrategy;
import com.yun.oj.backend.model.entity.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/03/19:39
 * @Description:
 */
@Component
@Slf4j
public class JudgeManager {
     public JudgeInfo judge(JudgeContext judgeContext){
         String language = judgeContext.getQuestionSubmit().getLanguage();
         JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
         switch (language){
             case "java":
                 judgeStrategy = new JavaJudgeStrategy();
                 break;
         }
         return judgeStrategy.judge(judgeContext);
     }
}
