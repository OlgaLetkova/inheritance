package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)

class ProductManagerTest {

    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;

    private Book book1 = new Book(1, "RedPill", 400, "Kurpatov");
    private Book book2 = new Book(2, "Thirst", 500, "Rybakov");
    private Smartphone smartphone1 = new Smartphone(3, "GalaxyS8", 20000, "Samsung");
    private Smartphone smartphone2 = new Smartphone(4, "Iphone8", 35000, "Apple");

    @Test
    void searchByNameForBook() {
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(repository).findAll();
        manager.searchBy("RedPill");
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("RedPill");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthorForBook() {
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(repository).findAll();
        manager.searchBy("Rybakov");
        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("Rybakov");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameForSmartphone() {
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(repository).findAll();
        manager.searchBy("GalaxyS8");
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("GalaxyS8");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByProducerForSmartphone() {
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(repository).findAll();
        manager.searchBy("Apple");
        Product[] expected = new Product[]{smartphone2};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameForNonExistingBook() {
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(repository).findAll();
        manager.searchBy("Storm");
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Storm");
        assertArrayEquals(expected, actual);
    }
}