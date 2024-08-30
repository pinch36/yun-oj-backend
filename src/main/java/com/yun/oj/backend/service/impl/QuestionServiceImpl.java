package com.yun.oj.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.oj.backend.mapper.QuestionMapper;
import com.yun.oj.backend.model.entity.Question;
import com.yun.oj.backend.service.QuestionService;
import org.springframework.stereotype.Service;

/**
* @author ylw16
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2024-08-30 21:03:15
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService {

}




