package com.vlad.alpha1.controller;

import com.vlad.alpha1.service.AlphaUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest()
//@ContextConfiguration("/applicationContext.xml")
public class AlphaControllerTest {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private AlphaUserService alphaUserService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(this.context).build();
    }

    @Test
    public void getUserByLoginPassword() throws Exception {
        mockMvc.perform(get("/auth?login=jora&password=228"))
                .andDo(print())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.login", is("jora")))
                .andExpect(jsonPath("$.password", is("228")));
    }

    @Test(expected = Exception.class)
    public void getNonExistingUser() throws Exception {
        mockMvc.perform(get("/auth?login=jora5&password=250"))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void addUser() throws Exception {
        mockMvc.perform(post("/add?login=jora3&password=230"))
                .andDo(print())
                .andExpect(jsonPath("$.login", is("jora3")))
                .andExpect(jsonPath("$.password", is("230")));
    }

    @Test(expected = Exception.class)
    public void addExistingUser() throws Exception {
        mockMvc.perform(post("/add?login=jora&password=228"))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void banUser() throws Exception {
        mockMvc.perform(put("/ban?id=2"))
                .andDo(print())
                .andExpect(jsonPath("$.login", is("jora2")))
                .andExpect(jsonPath("$.blocked", is(true)));

    }

    @Test(expected = Exception.class)
    public void banWrongUser() throws Exception {
        mockMvc.perform(put("/ban?id=228"))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void updateUser() throws Exception {
        mockMvc.perform(put("/upd?oldlogin=jora2&oldpassword=229&newlogin=jora4&newpassword=244"))
                .andDo(print())
                .andExpect(jsonPath("$.login", is("jora4")))
                .andExpect(jsonPath("$.password", is("244")));
    }

    @Test(expected = Exception.class)
    public void updateNonExistingUser() throws Exception {
        mockMvc.perform(put("/upd?oldlogin=jora4&oldpassword=228&newlogin=jora4&newpassword=244"))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist());
    }
}
