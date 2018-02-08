package com.bitcamp.app.kakao1.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bitcamp.app.kakao1.activity.Intro.*;

import com.bitcamp.app.kakao1.R;

public class MemberDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_detail);
        final Context context = MemberDetail.this;
        Intent intent = this.getIntent();
        final String userid = intent.getStringExtra(Intro.MEMBER_1);
        final MemberItem item = new MemberItem(context);
        Member member = (Member) new DetailService() {
            @Override
            public Object excute() {
                return item.detail(userid);
            }
        }.excute();
        final TextView name = findViewById(R.id.name);
        final TextView phoneNumber = findViewById(R.id.phone_number);
        phoneNumber.setText(member.phoneNumber);
        name.setText(member.name + "님의 프로필 ");
        final ImageView profilePhoto = findViewById(R.id.profile_photo);
        BitmapFactory.Options options= new BitmapFactory.Options();
        options.inSampleSize = 4;
        Bitmap orgImage = BitmapFactory.decodeResource(getResources(),
                this.getResources()
                        .getIdentifier(
                                this.getPackageName()+":drawable/"
                                        +member.profilePhoto,
                                null, null),
                options
        );
        Bitmap resize = orgImage.createScaledBitmap(orgImage, 100, 100, true);
        profilePhoto.setImageBitmap(resize);
        findViewById(R.id.update_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        findViewById(R.id.update_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private abstract class DetailQuery extends Intro.QueryFactory {
        SQLiteOpenHelper helper;

        public DetailQuery(Context context) {
            super(context);
            helper = new Intro.SQLiteHelper(context);
        }

        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getReadableDatabase();
        }
    }
    private class MemberItem extends DetailQuery{

        public MemberItem(Context context) {
            super(context);
        }
        public Member detail(String userid){
            Member member = new Member();
            String sql =
                    String.format("SELECT * FROM %s WHERE " +
                            "%s LIKE '%s' ",
                            Intro.TABLE_MEMBER,
                            Intro.MEMBER_1,
                            userid
                    );
            Cursor cursor = this.getDatabase().rawQuery(sql,null);
            if(cursor != null){
                cursor.moveToFirst();
                member.userid = cursor.getString(cursor.getColumnIndex(Intro.MEMBER_1));
                member.password = cursor.getString(cursor.getColumnIndex(Intro.MEMBER_2));
                member.name = cursor.getString(cursor.getColumnIndex(Intro.MEMBER_3));
                member.email = cursor.getString(cursor.getColumnIndex(Intro.MEMBER_4));
                member.phoneNumber = cursor.getString(cursor.getColumnIndex(Intro.MEMBER_5));
                member.profilePhoto = cursor.getString(cursor.getColumnIndex(Intro.MEMBER_6));
                member.address = cursor.getString(cursor.getColumnIndex(Intro.MEMBER_7));
            }
            Log.d("검색한 회원의 이름 : ", member.name);
            Log.d("검색한 회원의 이름 : ", member.profilePhoto);
            return member;
        }
    }

}
