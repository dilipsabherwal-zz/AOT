package com.deloittedigital.alcoholofthings.di;

import com.deloittedigital.alcoholofthings.main.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = CocktailModule.class)
public interface CocktailComponent {
	void inject(MainFragment mainFragment);
}
