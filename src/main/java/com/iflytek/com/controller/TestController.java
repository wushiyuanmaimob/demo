//package com.iflytek.com.controller;
//
//import org.apache.http.protocol.HTTP;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@RequestMapping("/test")
//public class TestController {
//    private final RestTemplate restTemplate;
//
//    public TestController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @GetMapping("/gm")
//    public void testGM() {
//        // 设置请求头
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        // 构造请求体
//        String requestBody = "{\"requestId\":\"20230919171153473667818617137234\", \"resultCode\":\"1000\", \"clusterId\":\"20230919171153473667818617137234\", \"errorMsg\":\"操作成功\"}";
//
//        // 构造HttpEntity对象，包含请求头和请求体
//        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//
//        // 发送POST请求，并接收响应结果
//        String url = "https://idp.ah.cegn.cn:443/yth-cm/extend/cloudDbCallBack/open/enmoCallBack";
////        String url = "https://xc-pro.iflytek.work:443/yth-cm/extend/cloudDbCallBack/open/enmoCallBack";
//
////        String url = "https://idp.ah.cegn.cn:443/yth-cm/extend/open/vminstance/getVminstanceList";
////        String url = "https://xc-pro.iflytek.work:443/yth-cm/extend/open/vminstance/getVminstanceList";
//
////        String url = "https://idp.ah.cegn.cn:443/yth-cm/extend/manageApp/database/get";
////        String url = "https://xc-pro.iflytek.work:443/yth-cm/extend/manageApp/database/get";
//
//        String response = restTemplate.postForObject(url, entity, String.class);
////        String response = restTemplate.getForObject(url, String.class);
//
//        // 输出响应结果
//        System.out.println(response);
//    }
//}
