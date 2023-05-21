package me.unryeong.vuetilserver.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class UserRepository {

    private static final Map<String, User> store = new ConcurrentHashMap<>();

    public User save(User user) {
        long size = store.size() + 1;
        user.setId(size);

        store.put(user.getUsername(), user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<User> findByUsername(String username) {
        return Optional.of(store.get(username));
    }
}
