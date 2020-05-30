
package com.codehub.marvelheroes;

import com.karumi.marvelapiclient.model.CharactersDto;
import com.karumi.marvelapiclient.model.MarvelResponse;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CharacterApiRest {
  @GET("characters") Call<MarvelResponse<CharactersDto>> getCharacters(
          @QueryMap Map<String, Object> characterFilter);

  @GET("characters/{id}") Call<MarvelResponse<CharactersDto>> getCharacter(
          @Path("id") String characterId);
}
