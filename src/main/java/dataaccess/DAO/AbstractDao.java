package dataaccess.DAO;

import annotations.TableName;
import dataaccess.helpers.DbObject;

public class AbstractDao<T extends DbObject> {
    public String tableName() {
        return DbObject.class.getDeclaredAnnotation(TableName.class).name();
    }
}
