package com.jinju.Controller;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jinju.data.dto.MemberDto;

// 예제 5.10
@RestController
@RequestMapping("/api/v1/post-api")
public class PutController {

    // 예제 5.11
    @PostMapping("/domain")
    public String postExample(){
        return "Hello Post API";
    }

    // 예제 5.12
    // http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }


    /*
    param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
    */

    // 예제 5.13
    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDTO) {
        return memberDTO.toString();
    }

}
