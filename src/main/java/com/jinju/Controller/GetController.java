package com.jinju.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jinju.data.dto.MemberDto;

@RestController
@RequestMapping("/get")

public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    @GetMapping("/hello")
    public String hello(){
        LOGGER.warn("get hello 호출 됨");
        return "hello world";
    }

    //http://localhost:8080/get/name
    @GetMapping(value = "/name")
    public String getName(){
        return "flature";
    }

    //http://localhost:8080/get/var/qwerqw
    @GetMapping(value = "/var/{var}")
    public String getVar(@PathVariable String var){
        LOGGER.info("파라미터 값 : "+var);//디버깅 할 때 로거로 쓸 수 있다
        return var;
    }

    //http://localhost:8080/get/var/qwerqw -> 변수 2개가 일치 하지 않는다면 요리 쓴다
    @GetMapping(value = "/var2/{jawsbar}")//Value value
    public String getVar2(@PathVariable("jawsbar") String var){
        return var;
    }

    //map 형태
    //http://localhost:8080/get/req1?name=jawsbar&email=radio700@hanmail.net&organ=kai
    @GetMapping(value = "/req1")
    public String getReqPar1(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String organ
        ){
        return name + " " + email + " " + organ;
    }


    //map 형태2
    //http://localhost:8080/get/req2?key1=val1&key2=val2&key3=val3
    @GetMapping(value = "/req2")
    public String getReqPar2(@RequestParam Map<String, String> param){

        StringBuilder sb = new StringBuilder();
        for(String key : param.keySet()){
            String value = param.get(key);
            sb.append(key+" : "+value+"\n");
        }
        return sb.toString();
    }
    

    //dto형태
    //http://localhost:8080/get/req3?name=jawsbar&email=radio700@hanmail.net&organ=kaier
    @GetMapping(value = "/req3")
    public String getReqPar3(MemberDto memberDto){
        //return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrgan();
        return memberDto.toString();
    }

}
