package co.com.newpandatv.view.activity.setup;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import co.com.newpandatv.R;
import co.com.newpandatv.app.App;

import static android.R.id.edit;

/**
 * Created by Administrator on 2017/9/20.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class FeedbackFrgmentOne extends Fragment implements View.OnClickListener {

    private EditText YJ;
    private EditText YX;
    private Button but_TJ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fragment_layout, null);


        initView(view);

        YX.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
                }else{
                    getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                }
            }
        });


        return view;
    }

    private void initView(View view) {

        YJ = (EditText) view.findViewById(R.id.YJ);
        YX = (EditText) view.findViewById(R.id.YX);
        but_TJ = (Button) view.findViewById(R.id.but_TJ);

        but_TJ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_TJ:
                submit();
                Toast.makeText(App.mContext,"感谢您的建议",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void submit() {
        // validate
        String YJString = YJ.getText().toString().trim();
        if (TextUtils.isEmpty(YJString)) {
            Toast.makeText(getContext(), "请留下您的宝贵意见", Toast.LENGTH_SHORT).show();
            return;
        }

        String YXString = YX.getText().toString().trim();
        if (TextUtils.isEmpty(YXString)) {
            Toast.makeText(getContext(), "请输入您的邮箱，方便我们及时给您回复", Toast.LENGTH_SHORT).show();
            return;
        }

    }
}
