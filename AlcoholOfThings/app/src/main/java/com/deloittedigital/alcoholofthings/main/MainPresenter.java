package com.deloittedigital.alcoholofthings.main;

import com.deloittedigital.alcoholofthings.BasePresenter;

import java.util.List;

public class MainPresenter implements BasePresenter, MainInteractor.OnCocktailFinishedListener {

	private MainContract.View mView;
	private MainInteractor mInteractor;

	public MainPresenter(MainInteractor interactor, MainContract.View view) {
		mInteractor = interactor;
		mView = view;
	}

	public void sendCocktail(String[] selectedItems){
		mInteractor.sendCocktail(selectedItems, this);
	}

	@Override
	public void onSuccess(String response) {
		mView.successMessage(response);
	}

	@Override
	public void onSendCocktailError(String errorMsg) {
		mView.showErrorToast(errorMsg);
	}
}
