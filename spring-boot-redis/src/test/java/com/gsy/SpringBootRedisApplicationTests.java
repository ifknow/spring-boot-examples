package com.gsy;

import com.gsy.poio.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testRedisInsertObject() {
        User user = new User(UUID.randomUUID().toString(), "李四", 18);
        redisTemplate.opsForValue().set(user.getId(), user);
    }

}
