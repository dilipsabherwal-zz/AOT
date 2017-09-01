package com.deloittedigital.alcoholofthings.main;

import com.deloittedigital.alcoholofthings.BaseInteractor;
import com.deloittedigital.alcoholofthings.BasePresenter;
import com.deloittedigital.alcoholofthings.BaseView;

import java.util.List;

public interface MainContract {

	interface View extends BaseView<Presenter> {
		void showErrorToast(String msg);
		void successMessage(String response);
	}

	interface Presenter extends BasePresenter {
		void sendCocktail(String[] selectedItems);
	}

	interface Interactor extends BaseInteractor {

		void sendCocktail(String[] cocktail, OnCocktailFinishedListener listener);

		interface OnCocktailFinishedListener {
			void onSuccess(String response);
			void onSendCocktailError(String errorMsg);
		}
	}

}
