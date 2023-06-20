package com.example.ablecommunity.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ablecommunity.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPasswordActivity extends AppCompatActivity {

    private EditText forgot_email;
    private Button forgotBtn;

    FirebaseAuth auth;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forgotBtn=findViewById(R.id.forgotBtn);
        forgot_email=findViewById(R.id.forgot_mail);
        auth=FirebaseAuth.getInstance();
        pd=new ProgressDialog(this);

        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = forgot_email.getText().toString();
                if(email.isEmpty())
                {
                    Toast.makeText(ForgetPasswordActivity.this, "Please Verify All Field", Toast.LENGTH_SHORT).show();
                }
                else {
                    passwordRecovery(email);

                }
            }

            private void passwordRecovery(String email) {

                pd.setMessage("Please wait");
                pd.show();
                auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            pd.dismiss();
                            Toast.makeText(ForgetPasswordActivity.this, "Check your email to recover credentials!", Toast.LENGTH_SHORT).show();
                            Intent backpressed=new Intent(ForgetPasswordActivity.this,LoginActivity.class);
                            startActivity(backpressed);
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(ForgetPasswordActivity.this, "Error: "+e, Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backpressed=new Intent(ForgetPasswordActivity.this,LoginActivity.class);
        startActivity(backpressed);
        finish();
    }
}