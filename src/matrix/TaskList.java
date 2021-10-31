package matrix;

public class TaskList {

    Task head;
    int size;

    static class Task {
        String name;
        Task next;

        public Task(String name, Task next) {
            this.name = name;
            this.next = next;
        }

    }

    protected Task createHead(String name) {
        this.size = 1;
        return this.head = new Task(name, null);
    }

    protected void add(int position, String name) {
        Task current = this.head;
        Task newTask = new Task(name, null);

        if (position == 0) {
            this.head = newTask;
            this.head.next = current;
            this.size += 1;
        } else {
            int index = 0;
            while (current != null) {
                if (index == position - 1) {
                    newTask.next = current.next;
                    current.next = newTask;
                    this.size += 1;
                }
                current = current.next;
                index++;
            }
        }
    }

    protected void list(TaskList taskList) {
        Task current = taskList.head;
        while (current != null) {
            System.out.println("Name: " + current.name);
            current = current.next;
        }
    }

    protected void delete(int position) {
        Task current = this.head;
        if (position == 0) {
            this.head = current.next;
            this.size -= 1;
        }
        int index = 0;
        while (current != null) {
            if (index == position -1) {
                if (current.next.next != null) {
                    current.next = current.next.next;
                } else {
                    current.next = null;
                }
                this.size -= 1;
            }
            index++;
            current = current.next;
        }
    }

}
