package com.deloittedigital.alcoholofthings.data;

import retrofit2.Response;
import rx.Completable;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.schedulers.Schedulers;

public class CocktailService {

	private CocktailApi mCocktailApi;

	public Observable<String> selectCocktail(final String cocktail) {

		return Observable.defer(() -> mCocktailApi.sendCocktail(cocktail))
				.subscribeOn(Schedulers.io())
				.map(Response::body);

	}

}
