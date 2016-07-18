package com.tcmmooc.zyzxapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcmmooc.zyzxapp.R;

/**
 * Created by bgd on 2016/7/18.
 */
public class MuKeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.muke_fragment, null);
        return view;
    }
}
