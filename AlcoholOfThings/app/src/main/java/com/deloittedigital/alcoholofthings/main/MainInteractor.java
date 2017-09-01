package com.deloittedigital.alcoholofthings.main;

import com.deloittedigital.alcoholofthings.data.CocktailService;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;

public class MainInteractor implements MainContract.Interactor {

	private CocktailService mCocktailService;

	public MainInteractor(final CocktailService cocktailService) {
		mCocktailService = cocktailService;
	}

	@Override
	public void sendCocktail(String[] cocktailItems, OnCocktailFinishedListener listener) {
		mCocktailService.selectCocktail(cocktailItems)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(
						response -> listener.onSuccess(response),
						error -> listener.onSendCocktailError(error.getCause().getMessage())
				);
	}
}
