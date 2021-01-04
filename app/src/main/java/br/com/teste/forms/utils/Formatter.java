package br.com.teste.forms.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class Formatter implements TextWatcher {

    protected boolean mSelfChanged = false;

    private EditText editText;

    public Formatter(EditText textView) {
        this.editText = textView;
    }

    @Override
    public void afterTextChanged(final Editable text) {
        if (!mSelfChanged) {
            mSelfChanged = true;
            String numbers = keepOnlyNumbers("" + text);
            editText.setText(formatCpf(numbers));
            editText.setSelection(editText.length());
            mSelfChanged = false;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(final CharSequence s, final int start, final int before,
                              final int count) {
        if (mSelfChanged)
            return;
    }

    public static String formatCpf(String cpf) {
        if (cpf == null) return null;
        if (cpf.length() != 11) return cpf;
        cpf = cpf.replace(".", "").replace("-", "");
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    private String keepOnlyNumbers(String strToConvert) {
        return strToConvert.replaceAll("[^0-9]", "");
    }
}
