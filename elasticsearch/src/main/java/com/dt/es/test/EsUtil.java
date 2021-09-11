package com.dt.es.test;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class EsUtil {

    final static String host = "127.0.0.1";

    final static Integer port = 9200;

    final static String scheme = "http";

    final static String userName = "xxxx";

    final static String password = "xxxx";

    public static RestHighLevelClient getClient(){

        // 创建ES客户端
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port, scheme));
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName,password));
        builder.setHttpClientConfigCallback(f -> f.setDefaultCredentialsProvider(credentialsProvider));
        RestHighLevelClient esClient = new RestHighLevelClient(builder);
        return esClient;
    }


}
