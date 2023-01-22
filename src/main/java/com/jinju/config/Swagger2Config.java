// package com.jinju.config;

// import org.springdoc.core.GroupedOpenApi;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;

// @Configuration
// public class Swagger2Config {

//     @Bean
//     public GroupedOpenApi publicApi() {
//         return GroupedOpenApi.builder()
//                 .group("v1-definition")
//                 .pathsToMatch("/**")
//                 .build();
//     }
//     @Bean
//     public OpenAPI springShopOpenAPI() {
//         return new OpenAPI()
//                 .info(new Info().title("프로젝트제목 OPEN API")
//                         .description(" 프로젝트 API 명세서입니다.")
//                         .version("v0.0.1"));
//     }
// }
