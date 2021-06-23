package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//스프링부트 테스트와 JUnit 사이의 연결자 역할, SpringRunner라는 스프링 실행자 사용
@RunWith(SpringRunner.class)
//여러 스프링 테스트 중 Web에 집중, 컨트롤러만 사용
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    //private MockMvc mvc -> 웹 API 테스트 사용, 스프링 MVC 테스트의 시작점, HTTP GET, POST 등 API 테스트
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                //status 상태 검증, 200인지 아닌지 검증
                .andExpect(status().isOk())
                //응답 본문의 내용 검증
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        //jsonPath -> JSON 응답값을 필드별로 검증할 수 있는 메소드. $를 기준으로 필드명 명시
        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
