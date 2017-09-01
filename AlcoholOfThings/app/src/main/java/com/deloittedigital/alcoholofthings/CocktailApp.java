package com.deloittedigital.alcoholofthings;

import android.app.Application;

import com.deloittedigital.alcoholofthings.di.Injector;

public class CocktailApp extends Application {

	public CocktailApp() {
		Injector.init(this);
	}
}
