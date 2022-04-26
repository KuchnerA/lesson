package ru.learnUp.feb.learnupjava20.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import ru.learnUp.feb.learnupjava20.dao.User;
import ru.learnUp.feb.learnupjava20.dao.UserDao;

import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;
    private final TransactionTemplate transactionTemplate;

    public UserService(UserDao userDao,
                       TransactionTemplate transactionTemplate) {
        this.userDao = userDao;
        this.transactionTemplate = transactionTemplate;
    }

    public Optional<User> findById(long id) {
        return Optional.ofNullable(userDao.findById(id));
    }

    public void save(User user) {
        transactionTemplate.executeWithoutResult(status -> {
            userDao.save(user);
        });
    }

}
