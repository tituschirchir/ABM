package dataaccess.models;

import org.springframework.util.StringUtils;
import services.robinhood.RHQuote;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;

public class RHTransformer {
    public static Function<RHQuote, Quote> TO_QUOTE = new Function<RHQuote, Quote>() {
        @Override
        public Quote apply(RHQuote rhQuote) {
            try {
                Quote item = Quote.class.getDeclaredConstructor().newInstance();
                Method[] declaredMethods = rhQuote.getClass().getDeclaredMethods();
                Arrays.stream(declaredMethods)
                        .filter(x-> x.getName().startsWith("get"))
                        .forEach(x->{
                            String field = fromCamel(x.getName());
                            String setter = field.replace("get", "set");
                            try {
                                Object value = x.invoke(rhQuote);
                                Quote.class.getDeclaredMethod(setter, x.getReturnType()).invoke(item, value);
                            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
                return item;
            } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    private static String fromCamel(String name) {
        String[] s = name.split("_");
        StringBuilder s1 = new StringBuilder(s[0]);
        for (int i = 1; i < s.length; i++) {
            s1.append(StringUtils.capitalize(s[i]));
        }
        return s1.toString();
    }
}
