// package com.jinju.Controller;

// import java.util.ArrayList;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// public class testContoller {

//     private final Logger log = LoggerFactory.getLogger(testContoller.class);

//     @RequestMapping(value="/param1")
//     public void m05(Human human) {
//         log.info("dto: "+ human);	//DTO로 전달
//     }
//     @RequestMapping(value="/param2")
//     public void m06(@RequestParam String name, @RequestParam int age) {
//         log.info("파람이름: "+name);	//파라미터이름으로 전달
//         log.info("파람나이: "+age);	//뷰에서 넘겨주는 파라미터의 이름과 변수 이름이 같아야한다
//     }
//     @RequestMapping("/param3")
//     public void m07(@RequestParam ArrayList<String> names){
//         log.info("m07() names: " + names);	//동일한 파라미터에 여러 데이터를 전달했을 때, 배열로 받을 수 있다 
//     }
//     @RequestMapping("/param4")
//     public void m08(@RequestParam("ns") ArrayList<String> names){
//         log.info("m08() names: " + names);	//(흔하지 않음)넘어오는 파라미터 이름과 변수이름이 다를 때, 이렇게 받을 수 있다. 
//     }
//     @RequestMapping("/param5")
//     public void m09(@RequestParam String[] names){
//         log.info("m09() names: " + names);	//동일한 파라미터에 여러 데이터를 전달했을 때, 배열로 받을 수 있다
//         for(String name: names) log.info("name: "+name);
//     }
//     @RequestMapping("/param6")
//     public void m10(HumanList hlist) {
//         log.info("배열 안의 내용을 출력 : "+hlist); 	//겟메소드를 쓰지 않고, 배열안의 내용을 출력해줄수 있는 기법. ****
//     }
//     @RequestMapping(value="/param7")
//     public void m011(Human human, @RequestParam int page) {
//         log.info("dto: "+ human);	//DTO로 전달 + DTO에 없는 변수
//         log.info("page: "+ page);
//     }
//     @RequestMapping("/param8")
//     public void m12(ToDoDTO dto)  {
//         log.info("m12() dto.getCdate(): " + dto.getCdate());	//시간데이터의 전달 ToDoDTO에서 패턴어노테이션
//     }
// }
