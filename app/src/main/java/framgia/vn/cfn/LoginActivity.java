package framgia.vn.cfn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static framgia.vn.cfn.Contanst.ID_LANG_EN;
import static framgia.vn.cfn.Contanst.ID_LANG_JP;
import static framgia.vn.cfn.Contanst.LANG_EN;
import static framgia.vn.cfn.Contanst.LANG_JP;
import static framgia.vn.cfn.SettingUtils.setLocale;

public class LoginActivity extends AppCompatActivity
    implements View.OnClickListener, OnItemListenner {
    private ToolbarCustom mToolbar;
    private EditText mEditUserName, mEditPassword;
    private Button mBtnLogin, mBtnFaceBook, mBtnRegister;
    private TextView mTxtFgPass, mTxtMember, mTxtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SpManager.getInstance().init(getApplication(), Contanst.CONFIG_LANG);
        initView();
    }

    public void initView() {
        mToolbar = (ToolbarCustom) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            mToolbar.setOnItemSelectListenerSpinner(this);
        }
        setSupportActionBar(mToolbar);
        mEditUserName = (EditText) findViewById(R.id.edit_username);
        mBtnLogin = (Button) findViewById(R.id.button_login);
        mEditPassword = (EditText) findViewById(R.id.edit_password);
        mBtnFaceBook = (Button) findViewById(R.id.button_facebook);
        mBtnRegister = (Button) findViewById(R.id.button_register);
        mTxtFgPass = (TextView) findViewById(R.id.text_fg_pass);
        mTxtMember = (TextView) findViewById(R.id.text_member);
        mTxtTitle = (TextView) findViewById(R.id.text_title);
        mBtnLogin.setOnClickListener(this);
    }

    public void refesh() {
        mEditUserName.setHint(getString(R.string.username));
        mEditPassword.setHint(getString(R.string.password));
        mBtnLogin.setText(getString(R.string.title_login));
        mBtnFaceBook.setText(getString(R.string.title_btn_facebook));
        mTxtFgPass.setText(getString(R.string.forget_password));
        mTxtMember.setText(getString(R.string.register_member));
        mBtnRegister.setText(getString(R.string.title_btn_register));
        mTxtTitle.setText(getString(R.string.about_login));
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void OnItemSelectedListener(int position) {
        changeLanguage(position);
        refesh();
    }

    private void changeLanguage(int language) {
        String lang;
        switch (language) {
            case ID_LANG_EN:
                lang = LANG_EN;
                break;
            case ID_LANG_JP:
                lang = LANG_JP;
                break;
            default:
                lang = LANG_JP;
                break;
        }
        SettingUtils.setLanguage(lang);
        setLocale(lang, getResources());
    }
}
