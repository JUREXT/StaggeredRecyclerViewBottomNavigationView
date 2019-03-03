package com.example.jure_lokovsek.staggered_recyclerview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends Activity {

    // TODO: https://blog.iamsuleiman.com/using-bottom-navigation-view-android-design-support-library/

    private ArrayList<Card> mCardList;
    private Context mContext;
    private BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_favorites:
                    setTitle("Favorites");
                    return true;
                case R.id.action_schedules:
                    setTitle("Schedules");
                    return true;
                case R.id.action_music:
                    setTitle("Music");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        bottomNavigationView = findViewById(R.id.navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mContext = MainActivity.this;
        initImagesList();
        initRecyclerView();


    }

    private void initImagesList(){
        mCardList = new ArrayList<>();
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","https://www.slikomania.si/fotky6510/fotos/slike-na-platnu_XOBZV007E11E11-gal2.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://opusteno.rs/slike/desktop-pozadine/21289/slike-lava-desktop-t01.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://www.slikomania.si/fotky6510/fotos/slike-na-platnu_XOBMO001E11-gal.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","https://pbs.twimg.com/profile_images/757551595961851904/TwnHW2_a.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","https://i.pinimg.com/736x/ff/a7/d9/ffa7d9ff1f5fc521c7476387d00ab01d--heart-on-phone-wallpapers.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://static.igre123.net/slike/36641-9258/cool-slika.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://opusteno.rs/slike/2016/02/preslatke-slike-beba-zivotinja-29308/preslatke-slike-beba-zivotinja-2.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","https://2.bp.blogspot.com/_pNylTS_iD1Q/TQ58EYV0jbI/AAAAAAAAF_U/EFU4cGMzi2k/s1600/praznici-pozadine-za-desktop-0143-3D-Bozicne-slike-macke.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","https://sites.google.com/site/itsmyworld7177/_/rsrc/1468739248158/najslade-slike/boo-clothes-dog-fun-Favim.com-487281.jpg?height=266&width=400"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","https://i.ytimg.com/vi/vTUYq89X9i4/hqdefault.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://images.kurir.rs/slika-900x608/prokuplje-macka-izujedala-vlasnicu-besnilo-1328585176-97572.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://zajebanko.com/wp-content/uploads/2016/01/netaknuta-divljina-priroda-1.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://svetmajmuna.com/images/Slike_Zivotinja_Slike_Raznih_Zivotinja_9.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://opusteno.rs/slike/desktop-pozadine/21289/slike-lava-desktop-t22.jpg"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://www.rtvslo.si/_up/photos/2015/09/05/u109627-311294_anbubis_show.png"));
        mCardList.add(new Card("lorem ipsum","lorem ipsum small","http://www.mladinska.com/_files/26672/8_155887388_1920x1080.jpg"));
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.cardView);
        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter = new StaggeredRecyclerViewAdapter(mContext, mCardList);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);
    }

}
