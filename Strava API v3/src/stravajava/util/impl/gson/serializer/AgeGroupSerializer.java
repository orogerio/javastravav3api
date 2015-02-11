package stravajava.util.impl.gson.serializer;

import java.lang.reflect.Type;

import stravajava.api.v3.model.reference.StravaAgeGroup;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Dan Shannon
 *
 */
public class AgeGroupSerializer implements JsonSerializer<StravaAgeGroup>, JsonDeserializer<StravaAgeGroup> {

	/**
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public StravaAgeGroup deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
		return StravaAgeGroup.create(json.getAsString());
	}

	/**
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(StravaAgeGroup ageGroup, Type type, JsonSerializationContext context) {
		return context.serialize(ageGroup.getValue());
	}

}
