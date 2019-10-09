/**
 * DateDeserializer.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core.util;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * 
 * Description the class DateDeserializer.java
 *
 * @Autor daniela.conceicao
 * @since
 * @version %I%, %G%
 */
public class DateDeserializer implements JsonDeserializer<Date> {

	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return json == null ? null : new Date(json.getAsLong());
	}
}