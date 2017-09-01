package com.deloittedigital.alcoholofthings.di;

import android.content.Context;

public class Injector {

	private static CocktailComponent sComponent;

	private Injector() {
		throw new AssertionError();
	}

	public static void init(Context context) {
		if (sComponent == null) {
			sComponent = DaggerCocktailComponent.builder().cocktailModule(new CocktailModule(context)).build();
		}
	}

	public static CocktailComponent get() {
		return sComponent;
	}

	public static void setComponent(CocktailComponent component) {
		sComponent = component;
	}

}
