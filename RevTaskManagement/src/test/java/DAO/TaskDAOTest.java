package DAO;

import org.example.Connection.DBConnection;
import org.example.DAO.TaskDAO;
import org.example.Models.Task;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskDAOTest {

    private TaskDAO taskDAO;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException {
        JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;", "sa", "");
        connection = cp.getConnection();
        DBConnection.setConnection(connection);  // Set the connection for testing
        taskDAO = new TaskDAO();

        // Create table and insert test data
        connection.createStatement().execute("CREATE TABLE tasks (" +
                "task_id INT PRIMARY KEY, " +
                "project_id INT, " +
                "assigned_to INT, " +
                "task_name VARCHAR(100), " +
                "task_description TEXT, " +
                "task_status VARCHAR(50), " +
                "progress_description TEXT, " +
                "task_start_date DATE, " +
                "task_end_date DATE)");
        connection.createStatement().execute("INSERT INTO tasks (task_id, task_name, assigned_to, status, task_start_date, task_end_date) VALUES (1, 'Test Task', 1, 'Pending', '2024-07-09', '2024-07-20')");
    }

    @Test
    void testCreateTask() throws SQLException {
        Task task = new Task();
        task.setTask_id(2);
        task.setProject_id(1);
        task.setAssigned_to(1);
        task.setTask_name("New Task");
        task.setTask_description("Description of new task");
        task.setTask_status("Pending");
        task.setTask_start_date(Date.valueOf("2024-07-09"));
        task.setTask_due_date(Date.valueOf("2024-07-20"));

        boolean result = taskDAO.createTask(task);

        assertTrue(result);

        List<Task> tasks = taskDAO.getTasksByUserId(1);
        assertEquals(2, tasks.size());
    }

    @Test
    void testGetTasksByUserId() throws SQLException {
        List<Task> tasks = taskDAO.getTasksByUserId(1);

        assertNotNull(tasks);
        assertEquals(1, tasks.size());
        assertEquals("Test Task", tasks.get(0).getTask_name());
    }

    @Test
    void testUpdateTaskStatusAndTimeline() throws SQLException {
        boolean result = taskDAO.updateTaskStatusAndTimeline(1, "Completed", "Finished the task", Date.valueOf("2024-07-09"), Date.valueOf("2024-07-20"));

        assertTrue(result);

        List<Task> tasks = taskDAO.getTasksByUserId(1);
        assertEquals("Completed", tasks.get(0).getTask_status());
        assertEquals("Finished the task", tasks.get(0).getTask_description());
        assertEquals(Date.valueOf("2024-07-09"), tasks.get(0).getTask_start_date());
        assertEquals(Date.valueOf("2024-07-20"), tasks.get(0).getTask_due_date());
    }
}
