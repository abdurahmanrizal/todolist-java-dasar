import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class AplikasiTodoListV2 {
    public static void main(String[] args) {
//        Repository digunakan untuk menyimpan data
//        Service digunakan untuk menyimpan bisnis logic
//        View digunakan untuk menyimpan tampilan
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
