import Buisiness.LibraryService;
import entities.Album;
import entities.Book;
import entities.Collectible;
import entities.User;

import java.util.List;
import java.util.function.Predicate;

public class run {
    public static void main(String[] args) {
        Collectible book1 = new Book("Księga dżungli", "Kipling");
        Collectible book2 = new Book("Władca pierścieni", "Tolkien");
        Collectible book3 = new Book("Chemia fizyczna", "Atkins");
        Collectible album1 = new Album("Americana", "Offspring");
        Collectible album2 = new Album("Greatest Hits", "Queen");
        Collectible album3 = new Album("Greatest Hits", "Scorpions");

        User user1 = new User("Karol", "Kowalski");
        User user2 = new User("Aśka", "Nowak");

        LibraryService libraryService = new LibraryService();

        libraryService.addCollectible(book1);
        libraryService.addCollectible(book2);
        libraryService.addCollectible(book3);
        libraryService.addCollectible(album1);
        libraryService.addCollectible(album2);
        libraryService.addCollectible(album3);
        libraryService.addUser(user1);
        libraryService.addUser(user2);

        List<Collectible> result = libraryService
                .getCollectibleByPredicate(collectible -> collectible instanceof Album && ((Album) collectible).getAlbumTitle().equals("Greatest Hits"));

        for (Collectible collectible : result) {
            System.out.println(collectible);
        }
    }
}