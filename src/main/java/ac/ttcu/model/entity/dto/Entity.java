package ac.ttcu.model.entity.dto;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Entity implements Serializable {
    @Override
    public String toString() {
        try {
            String out = this.getClass().getName() + "{";
            StringBuilder stringBuilder = new StringBuilder(out);
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                stringBuilder.append(field.getName() + "='" + field.get(this) + "',");
            }
            stringBuilder.deleteCharAt(out.length() - 1);
            stringBuilder.append('}');
            return out;
        } catch (Exception e) {
            return null;
        }
    }
}
