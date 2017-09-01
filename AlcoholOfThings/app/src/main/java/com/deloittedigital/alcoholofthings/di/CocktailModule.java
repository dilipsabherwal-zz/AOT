package com.deloittedigital.alcoholofthings.di;

import android.content.Context;
import android.util.Log;

import com.deloittedigital.alcoholofthings.data.CocktailApi;
import com.deloittedigital.alcoholofthings.data.CocktailService;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class CocktailModule {

	private Context mContext;

	public CocktailModule(Context context) {
		mContext = context;
	}

	@Provides
	@Singleton
	public CocktailService provideCocktailService(CocktailApi cocktailApi) {
		return new CocktailService(cocktailApi);
	}

	@Provides
	@Singleton
	public OkHttpClient providesOkHttpClient() {
		OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BODY);
		okHttpClientBuilder
				.addInterceptor(logging)
				.addInterceptor((chain) -> chain.proceed(chain.request())
				)
				.connectTimeout(20, TimeUnit.SECONDS)
				.writeTimeout(20, TimeUnit.SECONDS)
				.readTimeout(20, TimeUnit.SECONDS);

		return okHttpClientBuilder.retryOnConnectionFailure(true).build();
	}

	@Provides
	@Singleton
	public CocktailApi providesCocktailApi(OkHttpClient okHttpClient) {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost:8080")
				.client(okHttpClient)
				.addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();

		return retrofit.create(CocktailApi.class);
	}
}
