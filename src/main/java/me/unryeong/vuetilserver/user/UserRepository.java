package me.unryeong.vuetilserver.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class UserRepository {

    private static final Map<Long, User> store = new ConcurrentHashMap<>();

    public User save(User user) {
        long size = store.size() + 1;
        user.setId(size);

        store.put(user.getId(), user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}
