package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnAnArrayOfTasksWhenSearchingWithThreeMatches() {
        SimpleTask simpleTask = new SimpleTask(15, "Пойти в магазин");

        String[] subtasks = {"Пойти гулять", "Погладить одежду", "Поиграть в настольные игры"};
        Epic epic = new Epic(108, subtasks);

        Meeting meeting = new Meeting(
                33,
                "Пойти покормить кота",
                "Дом",
                "26/07/2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Пойти");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenSearchingWithNoMatches() {
        SimpleTask simpleTask = new SimpleTask(7, "Пойти в магазин");

        String[] subtasks = {"Погладить одежду", "Отправить письмо", "Позвонить маме"};
        Epic epic = new Epic(88, subtasks);

        Meeting meeting = new Meeting(
                999,
                "Поиграть в настольные игры",
                "Дом",
                "26/07/2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Домашний питомец");
        Assertions.assertArrayEquals(expected, actual);
    }
    

}
