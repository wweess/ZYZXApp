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
        //获取radiogroup控件
        main_radiogroup_rg = (RadioGroup) findViewById(R.id.main_radiogroup_rg);
    }

    private void initData() {
        //获取碎片管理器
        fragmentManager = getSupportFragmentManager();
        //初始化list碎片集合
        fragments = new ArrayList<>();
        //获取muke碎片
        MuKeFragment muKeFragment = new MuKeFragment();
        //获取faxian碎片
        FaXianFragment faXianFragment = new FaXianFragment();
        //获取fenlei碎片
        FenLeiFragment fenLeiFragment = new FenLeiFragment();
        //获取wode碎片
        WoDeFragment woDeFragment = new WoDeFragment();
        fragments.add(muKeFragment);
        fragments.add(fenLeiFragment);
        fragments.add(faXianFragment);
        fragments.add(woDeFragment);
       //默认首页为muke
        //开启碎片事务
        transaction = fragmentManager.beginTransaction();
        //碎片放入容器
        transaction.add(R.id.main_framelayout_top_fl, fragments.get(indext));
        //提交事务
        transaction.commit();
    }

    private void initListener() {
        //给radiogroup添加监听
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
            case R.id.main_radiobutton_fenlei:
                indext = 1;
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_framelayout_top_fl, fragments.get(indext));
                transaction.commit();
                break;
            case R.id.main_radiobutton_faxian:
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
