package com.study.es;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * Created by quchengguo on 2018/6/14.
 *
 * 学习网址：https://blog.csdn.net/lihao__/article/details/78261890
 */
public class EsDemo {
    public static void main(String[] args) throws Exception{
        // 1.获取client
        Settings settings = Settings.builder().put("cluster.name", "my-es-cluster").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        // 2.查询数据 index:库 tyep:表 id:id
        GetResponse response = client.prepareGet("megacorp", "employee", "1").get();
        System.out.println("查询id为1的结果:\n" + response);

        // 3.查询所有数据
        System.out.println("查询所有数据:");
        allquery(client);

        // 关闭资源
        client.close();
    }

    /**
     * 查询所有数据
     * @param client
     */
    public static void allquery(TransportClient client) throws Exception{
        QueryBuilder qb = matchAllQuery();
        SearchResponse response = client.prepareSearch("megacorp").setTypes("employee").setSize(3).setQuery(qb).get();

        System.out.println("length: "+response.getHits().getHits().length );
        if(response.getHits().getTotalHits() != 0) {
            for (SearchHit hit : response.getHits().getHits()) {
                System.out.println(hit.getSourceAsString());
            }
        }
    }
}
