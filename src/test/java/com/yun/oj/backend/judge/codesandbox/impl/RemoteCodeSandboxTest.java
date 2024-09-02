package com.yun.oj.backend.judge.codesandbox.impl;

import com.yun.oj.backend.judge.model.ExecuteCodeRequest;
import com.yun.oj.backend.judge.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/09/03/7:39
 * @Description:
 */
@SpringBootTest
@Slf4j
class RemoteCodeSandboxTest {
    @Resource
    private RemoteCodeSandbox remoteCodeSandbox;

    @Test
    void execute() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1 2");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .language("java")
                .input(list)
                .code("public class Main {\n" +
                        "    public static void main(String[] args) {\n" +
                        "        int a = Integer.parseInt(args[0]);\n" +
                        "        int b = Integer.parseInt(args[1]);\n" +
                        "        System.out.println(\"结果:\" + (a + b));\n" +
                        "    }\n" +
                        "}\n").build();
        ExecuteCodeResponse execute = remoteCodeSandbox.execute(executeCodeRequest);
        log.info("运行结果：{}", execute);
    }
}