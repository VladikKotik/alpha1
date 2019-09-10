package com.vlad.alpha1.service;

import com.vlad.alpha1.model.AlphaUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlphaUserServiceTest {

    @Autowired
    private AlphaUserService alphaUserService;

    @Test
    public void getByLoginPassword() throws Exception {
        AlphaUser user = alphaUserService.getUserByLoginPassword("jora", "228");
        assertEquals("jora", user.getLogin());
    }

    @Test(expected = Exception.class)
    public void wrongLoginPassword() throws Exception {
        AlphaUser user = alphaUserService.getUserByLoginPassword("jora30", "300");
    }

    @Test
    public void banUser() throws Exception {
        AlphaUser user = alphaUserService.banUser((long) 2);
        assertEquals(true, user.isBlocked());
    }

    @Test(expected = Exception.class)
    public void banNonExistingUser() throws Exception {
        AlphaUser user = alphaUserService.banUser((long) 228);
    }

    @Test
    public void addUser() throws Exception {
        AlphaUser user = alphaUserService.addUser("jora3", "230");
        assertEquals(false, user.isBlocked());//ну то, что он вообще создался
    }

    @Test(expected = Exception.class)
    public void addExistingUser() throws Exception {
        AlphaUser user = alphaUserService.addUser("jora", "228");
    }
}
