package com.yyg.genge.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yyg.genge.R;

public class AFragment extends Fragment {
    private TextView mTvTitle;
    private Button mBtnChangeF, mBtnReset, mBtnMessage;
    private BFragment bFragment;
    private IOnClick listener;

    public static AFragment newInstance(String title) {
        AFragment fragment = new AFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("AFragment", "----onCreateView----");
        View view = (View) inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_title);
        if (getArguments() != null) {
//            Log.d("--------------------", getArguments().getString("title"));
            mTvTitle.setText(getArguments().getString("title"));
        }
        mBtnChangeF = view.findViewById(R.id.btn_change);
        mBtnChangeF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                Fragment aFragment = getFragmentManager().findFragmentByTag("a");
                if (aFragment != null) {
                    getFragmentManager().beginTransaction().hide(aFragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();

                } else {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
                //TextView改变的AFragment视图内容未保存    返回时AFragment视图会回到初始状态 AFragment不会重新创建
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
            }
        });
        mBtnReset = view.findViewById(R.id.btn_reset);
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("设置新文字");
            }
        });
        mBtnMessage = view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick("你好！我是标题。");
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (IOnClick) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("ContainerActivity必须实现IOnclick接口");
        }

    }

    public interface IOnClick {
        void onClick(String text);
    }


}
