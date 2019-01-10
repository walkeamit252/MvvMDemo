package in.com.mvvmdemo.login;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.com.mvvmdemo.R;


public class MainActivity extends AppCompatActivity implements LifecycleOwner{

//    @BindView(R.id.inEmail)
//    EditText EtEmail;
//    @BindView(R.id.inPassword)
//    EditText EtPassword;

    EditText etEmail;
    EditText etPassword;
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSubmit=findViewById(R.id.btnSubmit);

       // ButterKnife.bind(this);

        final LoginViewModel model = ViewModelProviders.of(this).get(LoginViewModel.class);
        model.getResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });


        model.getToastMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();
                model.afterEmailTextChanged(email);
                model.afterPasswordTextChanged(password);
                model.onLoginClicked();
            }
        });

    }





}