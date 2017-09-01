package com.deloittedigital.alcoholofthings.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.deloittedigital.alcoholofthings.R;
import com.deloittedigital.alcoholofthings.data.CocktailService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {

	CocktailService mCocktailService;

	@BindView(R.id.cocktail_one)
	Button cocktailOneBtn;

	@BindView(R.id.cocktail_two)
	Button cocktailTwoBtn;

	@BindView(R.id.cocktail_three)
	Button cocktailThreeBtn;

	@BindView(R.id.cocktail_four)
	Button cocktailFourBtn;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_main, container, false);
		ButterKnife.bind(this, root);

		return root;
	}

	public static MainFragment newInstance() {
		return new MainFragment();
	}

	@OnClick(R.id.cocktail_one)
	public void onCocktailOneBtn() {
		Toast.makeText(getContext(), "Cocktail One clicked", Toast.LENGTH_SHORT).show();
	}

	@OnClick(R.id.cocktail_two)
	public void onCocktailTwoBtn() {
		Toast.makeText(getContext(), "Cocktail Two clicked", Toast.LENGTH_SHORT).show();
	}

	@OnClick(R.id.cocktail_three)
	public void onCocktailThreeBtn() {
		Toast.makeText(getContext(), "Cocktail Three clicked", Toast.LENGTH_SHORT).show();
	}

	@OnClick(R.id.cocktail_four)
	public void onCocktailFourBtn() {
		Toast.makeText(getContext(), "Cocktail Four clicked", Toast.LENGTH_SHORT).show();
	}
}
