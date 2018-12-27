package me.limeglass.skripthub.internals.readers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.google.gson.stream.JsonReader;

import me.limeglass.skripthub.api.objects.Addon;
import me.limeglass.skripthub.internals.SkriptHubOptional;
import me.limeglass.skripthub.internals.handlers.Reader;
import me.limeglass.skripthub.internals.objects.AddonImp;
import me.limeglass.skripthub.internals.responses.AddonsResponse;

public class AddonsReader extends Reader<AddonsResponse> {
	
	/*CHEAT-SHEET:
	--------------------------------------
					JSON
	--------------------------------------
	[
		{
			"name": "string",
			"url": "string",
			"author": "string"
		}
	]
	--------------------------------------
	*/
	
	@Override
	protected SkriptHubOptional<AddonsResponse> read(JsonReader reader) {
		Set<Addon> addons = new HashSet<Addon>();
		try {
			reader.beginArray();
			while (reader.hasNext()) {
				String[] authors = null;
				String name = null, url = null;
				reader.beginObject();
				while (reader.hasNext()) {
					String next = reader.nextName();
					switch (next) {
						case "name":
							name = reader.nextString();
							break;
						case "url":
							url = reader.nextString();
							break;
						case "author":
							//SkriptHub should support multiple authors in the future.
							authors = new String[] {reader.nextString()};
							break;
						default:
							reader.skipValue();
							break;
					}
				}
				reader.endObject();
				addons.add(new AddonImp(name, url, authors));
			}
			reader.endArray();
		} catch (IOException exception) {
			return new SkriptHubOptional<AddonsResponse>(exception);
		}
		AddonsResponse response = new AddonsResponse(addons.toArray(new Addon[addons.size()]));
		Optional<AddonsResponse> optional = Optional.of(response);
		return new SkriptHubOptional<AddonsResponse>(optional);
	}

}
