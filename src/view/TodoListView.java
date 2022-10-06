package view;

import service.TodoListService;
import util.InputUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true) {
            todoListService.showTodoList();

            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Masukkan pilihan");

            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodoList() {
        System.out.println("Tambah Todolist ");
        var todo = InputUtil.input("Masukkan todo (jika x batal)");
        if (todo.equals("x")) {
            System.out.println("Batal menambahkan todolist");
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("MENGHAPUS TODOLIST");
        var number = InputUtil.input("Masukkan nomor todo (jika x batal): ");

        if(number.equals("x")) {
            // batal
        }else {
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher match = pattern.matcher(number);

            if(!match.find()) {
                System.out.println("Number harus berupa angka");
            }else {
                todoListService.removeTodoList(Integer.valueOf(number));
            }

        }
    }
}
