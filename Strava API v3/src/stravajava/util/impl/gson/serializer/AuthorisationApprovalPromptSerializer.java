package stravajava.util.impl.gson.serializer;

import java.lang.reflect.Type;

import stravajava.api.v3.auth.ref.AuthorisationApprovalPrompt;

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
public class AuthorisationApprovalPromptSerializer implements JsonSerializer<AuthorisationApprovalPrompt>, JsonDeserializer<AuthorisationApprovalPrompt> {

	/**
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(AuthorisationApprovalPrompt prompt, Type type, JsonSerializationContext context) {
		return context.serialize(prompt.getId());
	}

	/**
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public AuthorisationApprovalPrompt deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
		return AuthorisationApprovalPrompt.create(element.getAsString());
	}

}
