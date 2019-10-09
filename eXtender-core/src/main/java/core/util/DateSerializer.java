/**
 * DateSerializer.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core.util;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Date;
/**
 * 
 * Description the class  DateSerializer.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public class DateSerializer implements JsonSerializer<Date> {

    public JsonElement serialize(Date date, Type typeOfSrc,
            JsonSerializationContext context) {
        return date == null ? null : new JsonPrimitive(date.getTime());
    }
}
