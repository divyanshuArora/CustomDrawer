package app.divyanshu.customdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.mindorks.placeholderview.PlaceHolderView;

public class MainActivity extends AppCompatActivity {

     PlaceHolderView mDrawerView;
     DrawerLayout mDrawer;
     Toolbar mToolbar;
     PlaceHolderView mGalleryView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer = (DrawerLayout)findViewById(R.id.drawerLayout);
        mDrawerView = (PlaceHolderView)findViewById(R.id.drawerView);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mGalleryView = (PlaceHolderView)findViewById(R.id.galleryView);
        setupDrawer();


    }

    private void setupDrawer()
    {
        mDrawerView.addView(new Drawer_header())
                .addView(new drawer_menu_item(this.getApplicationContext(),drawer_menu_item.DRAWER_MENU_ITEM_PROFILE))
                .addView(new drawer_menu_item(this.getApplicationContext(),drawer_menu_item.DRAWER_MENU_ITEM_REQUESTS))
                .addView(new drawer_menu_item(this.getApplicationContext(),drawer_menu_item.DRAWER_MENU_ITEM_MESSAGE))
                .addView(new drawer_menu_item(this.getApplicationContext(),drawer_menu_item.DRAWER_MENU_ITEM_NOTIFICATIONS))
                .addView(new drawer_menu_item(this.getApplicationContext(),drawer_menu_item.DRAWER_MENU_ITEM_LOGOUT));


        ActionBarDrawerToggle actionBarDrawerToggle  = new ActionBarDrawerToggle(this,mDrawer,mToolbar,R.string.open_drawer,R.string.close_drawer)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
}
