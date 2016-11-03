package framgia.vn.cfn;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static framgia.vn.cfn.Contanst.ID_LANG_EN;
import static framgia.vn.cfn.Contanst.ID_LANG_JP;

/**
 * Created by toannguyen201194 on 02/11/2016.
 */
public class ToolbarCustom extends Toolbar {
    private TextView mTxtToolbar;
    private Spinner mSpinner;
    private ViewGroup mViewGroup;
    private OnItemListenner mOnItemListenner;

    public ToolbarCustom(Context context) {
        super(context);
        initialize();
    }

    public ToolbarCustom(Context context,
                         @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public ToolbarCustom(Context context,
                         @Nullable AttributeSet attrs,
                         int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        ViewGroup viewGroup = (ViewGroup) inflate(getContext(), R.layout.toolbar_custom, this);
        mViewGroup = (ViewGroup) viewGroup.getChildAt(0);
        mTxtToolbar = (TextView) viewGroup.findViewById(R.id.text_toolbar);
        mSpinner = (Spinner) mViewGroup.findViewById(R.id.spinner);
        setupSpinner();
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mOnItemListenner != null) {
                    mOnItemListenner.OnItemSelectedListener(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setupSpinner() {
        String[] arr = getResources().getStringArray(R.array.change_language);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout
            .simple_spinner_item, arr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(arrayAdapter);
        mSpinner.setSelection(getCurrent());
    }

    private int getCurrent() {
        String lang = SettingUtils.getLanguage();
        switch (lang) {
            case Contanst.LANG_JP:
                return ID_LANG_JP;
            case Contanst.LANG_EN:
                return ID_LANG_EN;
            default:
                return ID_LANG_JP;
        }
    }

    public void setOnItemSelectListenerSpinner(OnItemListenner listener) {
        this.mOnItemListenner = listener;
    }
}