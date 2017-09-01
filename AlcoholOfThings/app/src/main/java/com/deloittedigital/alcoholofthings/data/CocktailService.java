package com.deloittedigital.alcoholofthings.data;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Completable;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.schedulers.Schedulers;

public class CocktailService {

	private CocktailApi mCocktailApi;

	public CocktailService(CocktailApi cocktailApi){
		mCocktailApi = cocktailApi;
	}

	public Observable<String> selectCocktail(final String[] selectedItems) {

		return Observable.defer(() -> mCocktailApi.sendCocktailItems(selectedItems))
				.subscribeOn(Schedulers.io())
				.map(Response::body);

	}

}
