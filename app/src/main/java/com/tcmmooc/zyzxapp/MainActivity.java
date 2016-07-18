package com.tcmmooc.zyzxapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tcmmooc.zyzxapp.fragment.FaXianFragment;
import com.tcmmooc.zyzxapp.fragment.FenLeiFragment;
import com.tcmmooc.zyzxapp.fragment.MuKeFragment;
import com.tcmmooc.zyzxapp.fragment.WoDeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private FrameLayout frameLayout;
    private RadioGroup main_radiogroup_rg;
    private RadioButton main_radiobutton_muke, main_radiobutton_fenlei, main_radiobutton_faxian, main_radiobutton_wode;
    private List<Fragment> fragments;
    private FragmentManager fragmentManager;
    FragmentTransaction transaction;
    int indext = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
        initData();
    }

    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.main_framelayout_top_fl);
        main_radiogroup_rg = (RadioGroup) findViewById(R.id.main_radiogroup_rg);
    }

    private void initData() {
        fragmentManager = getSupportFragmentManager();
        fragments = new ArrayList<>();
        MuKeFragment muKeFragment = new MuKeFragment();
        FaXianFragment faXianFragment = new FaXianFragment();
        FenLeiFragment fenLeiFragment = new FenLeiFragment();
        WoDeFragment woDeFragment = new WoDeFragment();
        fragments.add(muKeFragment);
        fragments.add(fenLeiFragment);
        fragments.add(faXianFragment);
        fragments.add(woDeFragment);
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.main_framelayout_top_fl, fragments.get(indext));
        transaction.commit();
    }


    private void initListener() {
        main_radiogroup_rg.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.main_radiobutton_muke:
                indext = 0;
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_framelayout_top_fl, fragments.get(indext));
                transaction.commit();
                break;
            case R.id.main_radiobutton_faxian:
                indext = 1;
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_framelayout_top_fl, fragments.get(indext));
                transaction.commit();
                break;
            case R.id.main_radiobutton_fenlei:
                indext = 2;
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_framelayout_top_fl, fragments.get(indext));
                transaction.commit();
                break;
            case R.id.main_radiobutton_wode:
                indext = 3;
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_framelayout_top_fl, fragments.get(indext));
                transaction.commit();
                break;
        }
    }
}
