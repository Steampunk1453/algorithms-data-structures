package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    @Test
    void createAgenda() {
        // Given
        Agenda agenda = new Agenda();
        // When
        int[][] result =  agenda.createAgenda();
        // Then
        assertEquals(result.length, 12);
    }

    @Test
    void createHead() {
        // Given
        TaskList taskList = new TaskList();
        // When
        taskList.createHead("first");
        // Then
        assertEquals(taskList.head.name, "first");
    }


    @Test
    void addAgenda() {
        // Given
        TaskList taskList = new TaskList();
        taskList.createHead("first");
        // When
        taskList.add(1, "second");
        // Then
        assertEquals(taskList.head.next.name, "second");
    }

    @Test
    void listAgenda() {
        // Given
        TaskList taskList = new TaskList();
        taskList.createHead("first");
        taskList.add(1, "second");
        taskList.add(2, "third");
        taskList.add(3, "fourth");
        taskList.add(4, "fifth");
        // When
        taskList.list(taskList);
        // Then
        assertEquals(taskList.head.name, "first");
    }
    @Test
    void deleteAgenda() {
        // Given
        TaskList taskList = new TaskList();
        taskList.createHead("first");
        taskList.add(1, "second");
        taskList.add(2, "third");
        taskList.add(3, "fourth");
        taskList.add(4, "fifth");
        // When
        taskList.delete(4);
        // Then
        assertEquals(taskList.head.name, "first");
    }


}