package eu.kielczewski.example;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * Created by quanzongwei(207127) on 2016/11/24 0024.
 */
public class MyMongoClient {
    public static void main(String[] args) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("runoob");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("person");
            System.out.println(collection.count());
            Document document = new Document("name", "zhangsan_changed").append("interests", "piano");

            collection.insertOne(document);
            collection.updateMany(Filters.eq("name","zhangsan"),new Document("$set",document));
            collection.deleteOne(Filters.eq("name", "zhangsan_changed"));
            //这三个可以连着用,注意文档由码号:转变为了,变成了java 的键值结构,可json是一样的
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> iterator = findIterable.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            MyMongoClient myMongoClient = new MyMongoClient();
            Class<? extends MyMongoClient> clazz = myMongoClient.getClass();
            System.out.println(clazz.getClassLoader());
            System.out.println(clazz.getClassLoader().getParent());
            System.out.println(clazz.getClassLoader().getParent().getParent());

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void main2(String[] args) {
        try {
            // 连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            // ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            // MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName",
                    "password".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            // 通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs, credentials);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
