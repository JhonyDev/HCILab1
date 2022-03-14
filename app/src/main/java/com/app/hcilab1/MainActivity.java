package com.app.hcilab1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etCnic1;
    EditText etCnic2;
    EditText etDob;
    EditText etCnic3;
    EditText etName;
    EditText etFName;
    EditText etAddress;
    EditText etPhoneNumber;
    EditText etMarks;

    DatePickerDialog datePickerDialog;
    RadioButton rbMale;
    RadioButton rbFemale;

    public boolean validEt(EditText etUserName, String strEtUserName) {
        if (strEtUserName.isEmpty()) {
            etUserName.setError("Field Empty");
            etUserName.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePickerDialog = new DatePickerDialog(this);
        etCnic1 = findViewById(R.id.et_cnic_1);
        etCnic2 = findViewById(R.id.et_cnic_2);
        etDob = findViewById(R.id.et_dob);
        etCnic3 = findViewById(R.id.et_cnic_3);

        etName = findViewById(R.id.et_name);
        etFName = findViewById(R.id.et_f_name);
        etAddress = findViewById(R.id.et_address);
        etPhoneNumber = findViewById(R.id.et_phone);
        etMarks = findViewById(R.id.et_marks);

        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);

        etCnic3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    int num = Integer.parseInt(etCnic3.getText().toString());
                    if (num % 2 == 0)
                        rbFemale.setChecked(true);
                    else
                        rbMale.setChecked(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etCnic1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = etCnic1.getText().toString();
                if (text.length() >= 5)
                    etCnic2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etCnic2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = etCnic2.getText().toString();
                if (text.length() >= 7)
                    etCnic3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        datePickerDialog.setOnDateSetListener((datePicker, i, i1, i2) -> {
            String dob = i2 + " - " + i1 + " - " + i;
            etDob.setText(dob);
        });

    }

    public void showDatePicker(View view) {
        datePickerDialog.show();
    }

    public void submit(View view) {
        validate();
    }

    private void validate() {
        if (!validEt(etName, etName.getText().toString()))
            return;
        if (!validEt(etFName, etFName.getText().toString()))
            return;
        if (!validEt(etMarks, etMarks.getText().toString()))
            return;
        if (!validEt(etAddress, etAddress.getText().toString()))
            return;

        if (!validEt(etCnic1, etCnic1.getText().toString()))
            return;

        if (!validEt(etCnic2, etCnic2.getText().toString()))
            return;

        validEt(etCnic3, etCnic3.getText().toString());

    }
}
