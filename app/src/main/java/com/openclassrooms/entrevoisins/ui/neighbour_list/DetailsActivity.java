package com.openclassrooms.entrevoisins;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {





    private ImageButton mReturnButton;
    private FloatingActionButton mFavoriteButton;
    private ImageView mProfilePic;

    private TextView mName;
    private TextView mLocation;
    private TextView mFacebookAccount;
    private TextView mPhoneNumber;
    private TextView mAproposDeMoi;
    private TextView mDescription;

    private String neighbourName;
    private String neighbourAvatar;
    private Integer neighbourId;

    public static List<Neighbour> mFavoriteList = new ArrayList<>();










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mReturnButton = findViewById(R.id.ReturnImageButton);
        mFavoriteButton = findViewById(R.id.favoriteButton);
        mProfilePic = findViewById(R.id.profilImageView);
        mName = findViewById(R.id.Name_txt);
        mLocation = findViewById(R.id.Location_txt);
        mFacebookAccount = findViewById(R.id.Facebook_txt);
        mPhoneNumber = findViewById(R.id.Phone_txt);
        mAproposDeMoi = findViewById(R.id.Apropos_txt);
        mDescription = findViewById(R.id.description_txt);



         neighbourName= getIntent().getStringExtra("name");
         neighbourAvatar= getIntent().getStringExtra("avatar");
         neighbourId = getIntent().getIntExtra("Id", 0);


        mName.setText(neighbourName);
        Glide.with(this).load(neighbourAvatar).into(mProfilePic);







        mFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), neighbourName + " " + "est ajouté(e) aux favoris", Toast.LENGTH_SHORT).show();
                DI.getNeighbourApiService().addToNeighbourFavoriteList(neighbourId);





            }
        });


        mReturnButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                returnToMainPage();
            }

        });


    }




    public void returnToMainPage(){
        finish();
    }





}
