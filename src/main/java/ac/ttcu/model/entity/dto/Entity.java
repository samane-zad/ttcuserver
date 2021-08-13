package ac.ttcu.model.entity.dto;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Entity implements Serializable {
    /**
     * toString method for non ac.ttcu type objects
     *
     * @return designed string format presenting all object fields with values
     */
    @Override
    public String toString() {
        try {
            String className = this.getClass().getName();
            String out = className.substring(className.lastIndexOf(".") + 1);
            StringBuilder stringBuilder = new StringBuilder(out);
            stringBuilder.append('{');
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String value;
                try {
                    value = field.get(this).toString();
                    if (field.getType().getName().startsWith("ac.ttcu")) {
                        value = field.get(this).toString();
                    }
                } catch (NullPointerException ne) {
                    value = null;
                }

                stringBuilder.append(field.getName() + "='" + value + "',");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append('}');
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
