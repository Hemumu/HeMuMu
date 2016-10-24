package com.example.administrator.myapplication.act;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myapplication.Contact;
import com.example.administrator.myapplication.R;

public class DetailsActivity extends Activity {

    public final static String ID = "ID";
    public Contact mContact;
    private TextView mName;
    private TextView mEmail;
    private TextView mPhone;
    private View mCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mContact = Contact.getItem(getIntent().getIntExtra(ID, 0));
        mName = (TextView) findViewById(R.id.DETAILS_name);
        mEmail = (TextView) findViewById(R.id.DETAILS_email);
        mPhone = (TextView) findViewById(R.id.DETAILS_phone);
        mCircle = (View) findViewById(R.id.DETAILS_circle);

        mName.setText(mContact.get(Contact.Field.NAME));
        mEmail.setText(mContact.get(Contact.Field.EMAIL));
        mPhone.setText(mContact.get(Contact.Field.PHONE));
        GradientDrawable bgShape = (GradientDrawable) mCircle.getBackground();
        bgShape.setColor(Color.parseColor(mContact.get(Contact.Field.COLOR)));
    }
}
