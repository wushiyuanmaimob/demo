//package com.iflytek.com.config;
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.TrustStrategy;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.ssl.SSLContexts;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//import javax.net.ssl.SSLContext;
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//
//
///**
// * Title : RestTemplateConfig
// * Description : @类注释说明写在此处@
// * Create on : 2022年02月26日
// *
// * @author department:技术中心基础架构部
// * username:pengzong
// * @version 1.0
// */
//@Configuration
//public class RestTemplateConfig {
//
//    /** 最大连接数 **/
////    @Value("${http.maxTotal}")
//    private int maxTotal = 100;
//
//    /** 并发数 **/
////    @Value("${http.defaultMaxPerRoute}")
//    private int defaultMaxPerRoute = 20;
//
//    /** 创建连接最长时间 **/
////    @Value("${http.connectTimeout}")
//    private int connectTimeout = 3000;
//
//    /** 从连接池中获取到连接的最长时间 **/
////    @Value("${http.connectionRequestTimeout}")
//    private int connectionRequestTimeout = 3000;
//
//    /** 数据传输的最长时间 **/
////    @Value("${http.socketTimeout}")
//    private int socketTimeout = 10000;
//
//    @Bean("httpRestTemplate")
//    RestTemplate getRestTemplate(ClientHttpRequestFactory requestFactory) {
//        return new RestTemplate(requestFactory);
//    }
//
//    @Bean("requestFactory")
//    public ClientHttpRequestFactory httpRequestFactory() {
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setHttpClient(httpClient());
//        //连接上服务器的超时时间
//        factory.setConnectTimeout(connectTimeout);
//        //返回数据的超时时间
//        factory.setReadTimeout(socketTimeout);
//        //从连接池中获取连接的超时时间
//        factory.setConnectionRequestTimeout(connectionRequestTimeout);
//        return factory;
//    }
//
//    @Bean
//    public HttpClient httpClient() {
//        TrustStrategy acceptingTrustStrategy = (x509Certificates, authType) -> true;
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
//        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
//        }
//        LayeredConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
//
//        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
//                .register("http", PlainConnectionSocketFactory.getSocketFactory())
//                .register("https", csf != null ? csf : SSLConnectionSocketFactory.getSocketFactory()).build();
//
//        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
//        connectionManager.setMaxTotal(maxTotal);
//        connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
//        return HttpClients.custom().setSSLSocketFactory(csf).setConnectionManager(connectionManager).build();
//    }
//}