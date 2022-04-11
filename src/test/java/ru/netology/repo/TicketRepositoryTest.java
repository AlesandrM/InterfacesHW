package ru.netology.repo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    static TicketRepository repo = new TicketRepository();
    static TicketManager manager = new TicketManager(repo);

    private static final String LED = "Пулково";
    private static final String LPK = "Липецк";
    private static final String SVO = "Шереметьево";
    private static final String VKO = "Внуково";
    private static final String SGC	 = "Сургут";

    static Ticket first = new Ticket(1, 2287, LED, LPK, 133);
    static Ticket second = new Ticket(2, 1299, SVO, LPK, 95);
    static Ticket third = new Ticket(3, 2199, VKO, LPK, 95);
    static Ticket fourth = new Ticket(4, 7099, SGC	, LPK, 149);


    @BeforeAll
    static void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
    }

    @Test
    public void shouldFindAll() {
        Ticket[] expected = {first, second, third};
        assertArrayEquals(expected, repo.getAll());
    }

    @Test
    public void shouldSave() {
        repo.save(fourth);
        Ticket[] expected = {first, second, third, fourth};
        Ticket[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(fourth);
        repo.removeById(4);
        Ticket[] expected = {first, second, third};
        Ticket[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }

}