package Buisiness;

import entities.Collectible;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LibraryService {
    private List<Collectible> collection;
    private List<User> users;

    public LibraryService() {
        collection = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (users.contains(user)) {
            throw new IllegalArgumentException("User with this id already exists");
        } else {
            this.users.add(user);
        }
    }

    public boolean hasUser(User user) {
        return users.contains(user);
    }

    public User deleteUser(User user) {
        int index = users.indexOf(user);
        if (index >= 0) {
            for (Collectible collectible : collection) {
                if (collectible.getOwnerId() == user.getId()) {
                    collectible.setOwnerId(null);
                }
            }
            return users.remove(index);
        } else {
            throw new IllegalArgumentException("Specified user does not exist");
        }
    }

    public void addCollectible(Collectible collectible) {
        if (collection.contains(collectible)) {
            throw new IllegalArgumentException("Element already exists in the collection");
        } else {
            this.collection.add(collectible);
        }
    }

    public boolean hasCollectible(Collectible collectible) {
        return collection.contains(collectible);
    }

    public Collectible deleteCollectible(Collectible collectible) {
        int index = collection.indexOf(collectible);

        if (index >= 0) {
            return collection.remove(index);
        } else {
            throw new IllegalArgumentException("Specified collectible does not exist");
        }
    }

    public boolean rentCollectible(int userId, int collectibleId) {
        Collectible collectible = collection.stream().filter(collectible1 -> collectible1.getId() == collectibleId).findFirst().orElse(null);
        User user = users.stream().filter(user1 -> user1.getId() == userId).findFirst().orElse(null);

        if (collectible == null || user == null) {
            return false;
        } else if (collectible.getOwnerId() != null) {
            return false;
        } else {
            collectible.setOwnerId(userId);
            return true;
        }
    }

    public boolean returnCollectible(int collectibleId) {
        Collectible collectible = collection.stream().filter(collectible1 -> collectible1.getId() == collectibleId).findFirst().orElse(null);
        if (collectible == null) {
            throw new IllegalArgumentException("Specified collectible does not exist");
        }
        if (collectible.getOwnerId() != null) {
            collectible.setOwnerId(null);
            return true;
        } else {
            return false;
        }
    }

    public List<Collectible> getHistoryByUser(int userId) {
        User user = users.stream().filter(user1 -> user1.getId() == userId).findFirst().orElse(null);
        if (user != null) {
            return user
                    .getHistory()
                    .stream()
                    .map(colId -> this.collection
                            .stream()
                            .filter(collectible -> collectible.getId() == colId)
                            .findFirst()
                            .get()
                    ).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Specified user does not exist");
        }
    }

    public List<Collectible> getCollectibleByPredicate(Predicate<Collectible> predicate) {
        return collection.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Users:\n");
        for (User user : users) {
            builder.append(user);
            builder.append("\n");
        }
        builder.append("Collection:\n");
        for (Collectible collectible : collection) {
            builder.append(collectible);
            builder.append("\n");
        }
        return builder.toString();
    }
}
