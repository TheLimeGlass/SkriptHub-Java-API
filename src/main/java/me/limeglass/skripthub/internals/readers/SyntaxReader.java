package me.limeglass.skripthub.internals.readers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import me.limeglass.skripthub.api.objects.CompatibleVersion;
import me.limeglass.skripthub.api.objects.Plugin;
import me.limeglass.skripthub.api.objects.Syntax;
import me.limeglass.skripthub.api.objects.Syntax.Type;
import me.limeglass.skripthub.internals.SkriptHubOptional;
import me.limeglass.skripthub.internals.handlers.Reader;
import me.limeglass.skripthub.internals.objects.ConditionImp;
import me.limeglass.skripthub.internals.objects.EffectImp;
import me.limeglass.skripthub.internals.objects.EventImp;
import me.limeglass.skripthub.internals.objects.ExpressionImp;
import me.limeglass.skripthub.internals.objects.FunctionImp;
import me.limeglass.skripthub.internals.objects.PluginImp;
import me.limeglass.skripthub.internals.objects.TypeImp;
import me.limeglass.skripthub.internals.objects.UnknownImp;
import me.limeglass.skripthub.internals.responses.SyntaxResponse;

public class SyntaxReader extends Reader<SyntaxResponse> {
	
	/*CHEAT-SHEET:
	--------------------------------------
					JSON
	--------------------------------------
	[
		{
			"id": 0,
			"creator": 0,
			"title": "string",
			"description": "string",
			"syntax_pattern": "string",
			"compatible_addon_version": "string",
			"compatible_minecraft_version": "string",
			"syntax_type": "event",
			"get_syntax_type_css_class": "string",
			"required_plugins": [
				{
					"name": "string",
					"link": "http://example.com"
				}
			],
			"addon": {
				"name": "string",
				"link_to_addon": "http://example.com"
			},
			"type_usage": "string",
			"return_type": "string",
			"event_values": "string",
			"json_id": "string",
			"event_cancellable": true
		}
	]
	--------------------------------------
	*/
	
	@Override
	protected SkriptHubOptional<SyntaxResponse> read(JsonReader reader) {
		Set<Syntax> syntaxes = new HashSet<>();
		try {
			reader.beginArray();
			while (reader.hasNext()) {
				Set<Plugin> required = new HashSet<>();
				boolean cancellable = false;
				Plugin addon = null;
				int creatorId = 0, id = 0;
				String title, description, pattern, addonVersion, minecraftVersion, syntaxType, css, usage, returnType, values, jsonId;
				title = description = pattern = addonVersion = minecraftVersion = syntaxType = css = usage = returnType = values = jsonId = null;
				reader.beginObject();
				while (reader.hasNext()) {
					if (reader.peek() == JsonToken.NULL)
						reader.skipValue();
					String next = reader.nextName();
					switch (next) {
						case "id":
							id = reader.nextInt();
							break;
						case "creator":
							creatorId = reader.nextInt();
							break;
						case "title":
							title = reader.nextString();
							break;
						case "description":
							description = reader.nextString();
							break;
						case "syntax_pattern":
							pattern = reader.nextString();
							break;
						case "compatible_addon_version":
							addonVersion = reader.nextString();
							break;
						case "compatible_minecraft_version":
							minecraftVersion = reader.nextString();
							break;
						case "syntax_type":
							syntaxType = reader.nextString();
							break;
						case "get_syntax_type_css_class":
							css = reader.nextString();
							break;
						case "required_plugins":
							reader.beginArray();
							while (reader.hasNext()) {
								String name, url;
								name = url = null;
								reader.beginObject();
								while (reader.hasNext()) {
									next = reader.nextName();
									if (next.equalsIgnoreCase("name"))
										name = reader.nextString();
									if (next.equalsIgnoreCase("link"))
										url = reader.nextString();
								}
								reader.endObject();
								addon = new PluginImp(name, url);
							}
							reader.endArray();
							break;
						case "addon":
							String name, url;
							name = url = null;
							reader.beginObject();
							while (reader.hasNext()) {
								next = reader.nextName();
								if (next.equalsIgnoreCase("name"))
									name = reader.nextString();
								if (next.equalsIgnoreCase("link_to_addon"))
									url = reader.nextString();
							}
							reader.endObject();
							required.add(new PluginImp(name, url));
							break;
						case "type_usage":
							if (reader.peek() != JsonToken.NULL)
								usage = reader.nextString();
							break;
						case "return_type":
							if (reader.peek() != JsonToken.NULL)
								returnType = reader.nextString();
							break;
						case "event_values":
							if (reader.peek() != JsonToken.NULL)
								values = reader.nextString();
							break;
						case "json_id":
							if (reader.peek() != JsonToken.NULL)
								jsonId = reader.nextString();
							break;
						case "event_cancellable":
							if (reader.peek() != JsonToken.NULL)
								cancellable = reader.nextBoolean();
							break;
						default:
							reader.skipValue();
							break;
					}
				}
				reader.endObject();
				CompatibleVersion version = new CompatibleVersion(minecraftVersion, addonVersion);
				Type type = Type.valueOf(syntaxType.toUpperCase());
				if (type != null) {
					switch (type) {
						case EVENT:
							syntaxes.add(new EventImp(description, version, required, creatorId, pattern, jsonId, title, addon, css, id, cancellable, values));
							break;
						case EXPRESSION:
							syntaxes.add(new ExpressionImp(description, version, required, creatorId, pattern, jsonId, title, addon, css, id, returnType));
							break;
						case TYPE:
							syntaxes.add(new TypeImp(description, version, required, creatorId, pattern, jsonId, title, addon, css, id, usage));
							break;
						case CONDITION:
							syntaxes.add(new ConditionImp(description, version, required, creatorId, pattern, jsonId, title, addon, css, id));
							break;
						case FUNCTION:
							syntaxes.add(new FunctionImp(description, version, required, creatorId, pattern, jsonId, title, addon, css, id));
							break;
						case EFFECT:
							syntaxes.add(new EffectImp(description, version, required, creatorId, pattern, jsonId, title, addon, css, id));
							break;
						default:
							syntaxes.add(new UnknownImp(description, version, required, creatorId, pattern, jsonId, title, addon, css, id));
							break;
					}
				} else {
					syntaxes.add(new UnknownImp(description, version, required, creatorId, pattern, jsonId, title, addon, css, id));
				}
			}
			reader.endArray();
		} catch (IOException exception) {
			return new SkriptHubOptional<SyntaxResponse>(exception);
		}
		SyntaxResponse response = new SyntaxResponse(syntaxes.toArray(new Syntax[syntaxes.size()]));
		Optional<SyntaxResponse> optional = Optional.of(response);
		return new SkriptHubOptional<SyntaxResponse>(optional);
	}

}
