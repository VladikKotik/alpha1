package com.vlad.alpha1.Controller;

import com.vlad.alpha1.Model.AlphaUser;
import com.vlad.alpha1.repositories.AlphaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
//
//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){
//        return new Greeting(counter.incrementAndGet(),String.format(template,name));
//    }

    @Autowired
    private AlphaUserRepository alphaUserRepository;
    public void initData() {
        AlphaUser user1 = new AlphaUser("jora","228");
        AlphaUser user2 = new AlphaUser("jora2","229");
        alphaUserRepository.save(user1);
        alphaUserRepository.save(user2);


    }

    //  @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    //    public Collection<Product> findAll() {
    //        return productService.findAll();
    //    }

    @RequestMapping("/users")
    public List<AlphaUser> findAll(){
        initData();
        return alphaUserRepository.findAll();
    }


    @RequestMapping("/userjora")
    public AlphaUser findjora(){
        //initData();
        //return alphaUserRepository.findAll();
        return alphaUserRepository.findByLoginAndPassword("jora","228");
    }
}
