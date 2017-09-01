package com.deloittedigital.alcoholofthings.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.deloittedigital.alcoholofthings.R;
import com.deloittedigital.alcoholofthings.data.CocktailService;
import com.deloittedigital.alcoholofthings.di.Injector;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initFragment(MainFragment.newInstance());
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	private void initFragment(Fragment detailFragment) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(R.id.contentFrame, detailFragment);
		transaction.commit();
	}

}
