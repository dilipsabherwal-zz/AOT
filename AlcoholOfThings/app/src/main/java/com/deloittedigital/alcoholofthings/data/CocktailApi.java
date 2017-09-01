package com.deloittedigital.alcoholofthings.data;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface CocktailApi {

	@POST("/cocktail")
	Observable<Response<String>> sendCocktail(@Body String cocktail);

}
