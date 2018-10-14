package dataaccess.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;

public class ObjectMapper {
    public static <T> T invoke(ResultSet resultSet, Class<T> clazz) {
        try {
            final T item = clazz.getDeclaredConstructor().newInstance();
            Arrays.stream(item.getClass().getDeclaredMethods())
                    .filter(x -> x.getName().startsWith("set"))
                    .forEach(m -> bindValueToMethod(item, resultSet, m));
            return item;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> void bindValueToMethod(T item, ResultSet resultSet, Method m) {
        String field = m.getName().replace("set", "").replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
        Class<?> parameterType = m.getParameterTypes()[0];
        try {
            if (parameterType == String.class)
                m.invoke(item, resultSet.getString(field));
            else if (parameterType == double.class)
                m.invoke(item, resultSet.getDouble(field));
            else if (parameterType == int.class)
                m.invoke(item, resultSet.getInt(field));
            else if (parameterType == Timestamp.class)
                m.invoke(item, resultSet.getTimestamp(field));
            else if (DbObject.class.isAssignableFrom(parameterType))
                m.invoke(item, invoke(resultSet, parameterType));
        } catch (IllegalAccessException | InvocationTargetException | SQLException e) {
            e.printStackTrace();
        }
    }
}
