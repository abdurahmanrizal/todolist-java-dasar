package repository;

import entity.Todolist;

public class TodoListRepositoryImpl implements TodoListRepository{
    private Todolist[] data = new Todolist[10];
    @Override
    public Todolist[] getAll() {
        return data;
    }
    public boolean isFull() {
        // cek apakah data array sudah penuh?
        var isFull = true;

        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void resizeIfFull() {
        // jika data array penuh resize array 2x lipat dari array sebelumnya
        if (isFull()) {
            var temp = data;
            data = new Todolist[data.length * 2];

            for (var i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }
    @Override
    public void add(Todolist todolist) {
        resizeIfFull();
        // tambahkan data ke array yang bernilai null
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }


    @Override
    public boolean remove(Integer number) {
        boolean status = true;
        if ((number - 1) >= data.length) {
            status = false;
        } else if (data[number - 1] == null) {
            status = false;
        }else {
            for (var i = number - 1; i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
        }
        return status;

    }
}
