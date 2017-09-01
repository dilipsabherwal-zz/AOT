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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment implements MainContract.View {

	@Inject
	CocktailService mCocktailService;

	private MainPresenter mPresenter;

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

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mPresenter = new MainPresenter(new MainInteractor(mCocktailService), this);
	}

	public static MainFragment newInstance() {
		return new MainFragment();
	}

	@OnClick(R.id.cocktail_one)
	public void onCocktailOneBtn() {
		Toast.makeText(getContext(), getResources().getString(R.string.cocktail_one) + " selected", Toast.LENGTH_SHORT).show();
		mPresenter.sendCocktail(new String[]{"Gin", "Tonic"});
	}

	@OnClick(R.id.cocktail_two)
	public void onCocktailTwoBtn() {
		Toast.makeText(getContext(), getResources().getString(R.string.cocktail_two) + " selected", Toast.LENGTH_SHORT).show();
		//mPresenter.sendCocktail(new String[]{"Gin", "Tonic"});
	}

	@OnClick(R.id.cocktail_three)
	public void onCocktailThreeBtn() {
		Toast.makeText(getContext(), getResources().getString(R.string.cocktail_three) + " selected", Toast.LENGTH_SHORT).show();
		//mPresenter.sendCocktail(new String[]{"Gin", "Tonic"});
	}

	@OnClick(R.id.cocktail_four)
	public void onCocktailFourBtn() {
		Toast.makeText(getContext(), getResources().getString(R.string.cocktail_four) + " selected", Toast.LENGTH_SHORT).show();
		//mPresenter.sendCocktail(new String[]{"Gin", "Tonic"});
	}

	@Override
	public void showErrorToast(String msg) {
		Toast.makeText(getContext(), "Error: " + msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void successMessage(String response) {
		Toast.makeText(getContext(), "Success: " + response, Toast.LENGTH_SHORT).show();
	}

}
