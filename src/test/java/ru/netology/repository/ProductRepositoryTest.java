package ru.netology.repository;
import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.Smartphone;


import static org.junit.jupiter.api.Assertions.*;
public class ProductRepositoryTest {
    private ru.netology.repository.ProductRepository repository = new ru.netology.repository.ProductRepository();
    Product book = new Book(1, "Инструкция iPhone", 100, "Автор");
    Product smartphone = new Smartphone(2, "iPhone", 50_000, "Производитель");
    Product product = new Product(3, "Кофе", 1_000);
    @Test
    public void shouldSaveOneItem() {
        repository.save(book);
        Product[] expected = {book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindAll() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        Product[] expected = { book, smartphone, product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldRemoveById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(2);
        Product[] expected = { book, product };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveAllById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(1);
        repository.removeById(2);
        repository.removeById(3);
        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}