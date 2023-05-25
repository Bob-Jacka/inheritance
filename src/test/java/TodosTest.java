import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.stats.*;

public class TodosTest {
    static SimpleTask simpleTask;
    static String[] subtasks = new String[]{"Молоко", "Яйца", "Хлеб"};
    static Epic epic;
    static Meeting meeting;
    static Todos todos = new Todos();

    @BeforeAll
    public static void testEquipment() {
        simpleTask = new SimpleTask(5, "Позвонить родителям");
        epic = new Epic(55, subtasks);
        meeting = new Meeting(
                555,
                "meeting",
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldMatchInTodosSimpleTask() {
        Task[] act = todos.search("Позвонить");
        Task[] exp = {simpleTask};

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void shouldNotMatchInTodosSimpleTask() {
        Task[] act = todos.search("мыным жингыртӥз");
        Task[] exp = {simpleTask};

        Assertions.assertNotEquals(exp, act);
    }

    @Test
    public void shouldMatchInTodosEpicTask() {
        Task[] act = todos.search("Хлеб");
        Task[] exp = {epic};

        Assertions.assertArrayEquals(exp, act);
    }

    @Test
    public void shouldNotMatchInTodosEpicTask() {
        Task[] act = todos.search("bread");
        Task[] exp = {epic};

        Assertions.assertNotEquals(exp, act);
    }

    @Test
    public void shouldMatchInTodosMeetingTask() {
        Task[] act1 = todos.search("3");
        Task[] act2 = todos.search("Приложение");
        Task[] exp = {meeting};

        Assertions.assertArrayEquals(exp, act1);
        Assertions.assertArrayEquals(exp, act2);
    }

    @Test
    public void shouldNotMatchInTodosMeetingTask() {
        Task[] act1 = todos.search("15");
        Task[] act2 = todos.search("app");
        Task[] exp = {meeting};

        Assertions.assertNotEquals(exp, act1);
        Assertions.assertNotEquals(exp, act2);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchInSimpleTask() {
        boolean act = simpleTask.matches("Позвонить");
        boolean exp = true;

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldNotMatchInSimpleTask() {
        boolean act = simpleTask.matches("call");
        boolean exp = false;

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldMatchInEpicTask() {
        boolean act = epic.matches("Яйца");
        boolean exp = true;

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldNotMatchInEpicTask() {
        boolean act = epic.matches("eggs");
        boolean exp = false;

        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldMatchInMeetingTask() {
        boolean act1 = meeting.matches("Выкатка 3й версии приложения");
        boolean act2 = meeting.matches("Приложение НетоБанка");
        boolean exp = true;

        Assertions.assertEquals(exp, act1);
        Assertions.assertEquals(exp, act2);
    }

    @Test
    public void shouldNotMatchInMeetingTask() {
        boolean act1 = meeting.matches("Закатка 4й версии приложения");
        boolean act2 = meeting.matches("Приложение СберБанка");
        boolean exp = false;

        Assertions.assertEquals(exp, act1);
        Assertions.assertEquals(exp, act2);
    }
}
