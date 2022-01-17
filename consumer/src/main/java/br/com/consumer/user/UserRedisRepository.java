package br.com.consumer.user;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class UserRedisRepository {

    public static final String KEY = "REDISUSER";
    private RedisTemplate<String,UserRedis> redisTemplate;
    private HashOperations hashOperations;

    public UserRedisRepository(RedisTemplate<String, UserRedis> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    /*Getting all Items from tSable*/
    public List<Object> getAllUsers(){
        Map<String,UserRedis> users = hashOperations.entries(KEY);
        List<Object> userRedisList = UserRedis.retornaListaUsuarios(users);

        return userRedisList;
    }

    /*Getting a specific item by item id from table*/
    public UserRedis getUser(String userId){
        return (UserRedis) hashOperations.get(KEY,userId);
    }

    /*Adding an item into redis database*/
    public void addUser(UserRedis user){
        hashOperations.put(KEY,user.getId(),user);
    }

    /*delete an item from database*/
    public void deleteItem(String id){
        hashOperations.delete(KEY,id);
    }

    /*update an item from database*/
    public void updateItem(UserRedis user){
        addUser(user);
    }
}