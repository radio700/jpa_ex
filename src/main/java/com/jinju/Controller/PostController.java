package com.jinju.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jinju.data.dto.MemberDto;




@RestController
@RequestMapping("/post")
public class PostController {
    

    //http://localhost:8080/post/domain
    @PostMapping("/domain")
    public String post(){
        return "hello";
    }

    //map으로 ... 맵은 대체로 어떤 애가 올지 모를 때 씀 걍 쓰자
    //http://localhost:8080/post/member1
    @PostMapping("/member1")
    public String postMember(@RequestBody Map<String, String> curMap){
        StringBuilder sb = new StringBuilder();

        for(String key : curMap.keySet()){
            String value = curMap.get(key);
            sb.append(key + " : "+value + "\n");
        }
        return sb.toString();
    }

    //http://localhost:8080/post/member2
    @PostMapping("/member2")
    public String PostmemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

}
