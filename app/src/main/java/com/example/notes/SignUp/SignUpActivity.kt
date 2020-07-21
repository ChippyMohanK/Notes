package com.example.notes.SignUp

import android.content.Intent
import android.text.TextUtils
import android.widget.ProgressBar
import android.widget.Toast
import com.example.notes.note.BaseActivity
import com.example.notes.R
import com.example.notes.ui.MainActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.actiity_signup.*


@Suppress("DEPRECATION")
class SignUpActivity : BaseActivity() {
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    private val TAG = "CreateAccountActivity"
    private val progressBar: ProgressBar? = null
    private var firstName: String? = ""
    private var phone: String? = ""
    private var email: String? = ""
    private var password: String? = ""


    override fun initComponents() {
        initialise()
    }

    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")
        mAuth = FirebaseAuth.getInstance()
        btSignUp.setOnClickListener {
            firstName = teEmail.text.toString().trim()
            phone = teMobile.text.toString().trim()
            email = teEmail.text.toString().trim()
            password = tePassword.text.toString().trim()
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            }
            if (TextUtils.isEmpty(firstName)) {
                Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(phone)) {
                Toast.makeText(getApplicationContext(), "Enter mobile number!", Toast.LENGTH_SHORT).show()
            }
            mAuth!!.createUserWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this,
            OnCompleteListener<AuthResult?> { task ->
                Toast.makeText(this, "createUserWithEmail:onComplete:" + task.isSuccessful,
                    Toast.LENGTH_SHORT).show()
                if (!task.isSuccessful) {
                    Toast.makeText(this, "Authentication failed." + task.exception,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            })
    }
    }




    override fun getLayoutId(): Int {
      return R.layout.actiity_signup
    }
}