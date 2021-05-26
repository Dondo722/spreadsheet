package org.example.View.Page;

import org.example.Model.Teacher;
import org.example.View.Table;

public interface Pageable {
    Pages getPages();
    Table<Teacher> getTable();
}
