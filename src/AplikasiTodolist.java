public class AplikasiTodolist {
    /**
     * membuat model untuk menampung data todolist
     */
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        testViewRemoveTodoList();
    }

    /**
     * Method untuk menampilkan data todolist
     */
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var nomor = i + 1;

            if (todo != null) {
                System.out.println(nomor + ". " + todo);
            }

        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar java dasar";
        model[1] = "Belajar java oop";
        showTodoList();
    }

    /**
     * Method untuk menambahkan data todolist
     */
    public static void addTodoList(String todo) {
//        cek apakah data array sudah penuh?
        var isFull = true;

        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }
//        jika data array penuh resize array 2x lipat dari array sebelumnya
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
//        tambahkan data ke array yang bernilai null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

//    public static void testAddTodoList() {
//        for (var i = 0; i < 25; i++) {
//            addTodoList("Contoh perulangan ke- " + i);
//        }
//        showTodoList();
//    }

    /**
     * Method untuk menghapus data todolist
     */
    public static boolean removeTodoList(Integer number) {
        boolean status;
        if ((number - 1) >= model.length) {
            status = false;
        } else if (model[number - 1] == null) {
            status = false;
        } else {
            for (var i = number - 1; i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            status = true;
        }

        return status;
    }

//    public static void testRemoveTodoList() {
//        for (var i = 0; i < 5; i++) {
//            addTodoList("Contoh perulangan ke- " + (i + 1));
//        }
//        removeTodoList(4);
//        showTodoList();
//
//
//    }

    /**
     * Method untuk view menampilkan tampilan data todo list
     */

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

//    public static void testInput() {
//        var name = input("Masukkan nama");
//        System.out.println("Hi " + name);
//    }

    public static void viewShowTodoList() {
        while (true) {
            System.out.println("TODOLIST");

            showTodoList();

            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Masukkan pilihan");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }

    }

//    public static void testViewShowTodoList() {
//        addTodoList("Satu");
//        addTodoList("Dua");
//        addTodoList("Tiga");
//        addTodoList("Empat");
//
//        viewShowTodoList();
//
//    }

    /**
     * Method untuk view menampilkan tampilan untuk menambahkan todo list
     */
    public static void viewAddTodoList() {
        System.out.println("Tambah Todolist ");
        var todo = input("Masukkan todo (jika x batal): ");
        if (todo.equals("x")) {
            System.out.println("Batal menambahkan todolist");
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Method untuk view menampilkan tampilan untuk menghapus todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODOLIST");
        var number = input("Masukkan nomor todo (jika x batal): ");

        if(number.equals("x")) {
            // batal
        }else {
            boolean status = removeTodoList(Integer.valueOf(number));

            if(!status) {
                System.out.println("Gagal menghapus nomor todolist " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
