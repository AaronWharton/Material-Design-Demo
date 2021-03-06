package com.example.asus1.materialdesigndemo.ui.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.asus1.materialdesigndemo.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle(R.string.app_name);

        final FrameLayout imageView1 = (FrameLayout) findViewById(R.id.item1);
        final RelativeLayout relativeLayout1 = (RelativeLayout) findViewById(R.id.bottom1);
        final int[] s1 = new int[1];
        Palette.generateAsync(drawableToBitmap(getResources().getDrawable(R.drawable.item1)), new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getVibrantSwatch();
                if (swatch != null) {
                    relativeLayout1.setBackgroundColor(swatch.getRgb());
                    s1[0] = swatch.getRgb();
                }
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.item1));
                bundle.putInt("color", s1[0]);
                intent.putExtras(bundle);
                startActivity(intent, ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this, relativeLayout1, "item").toBundle());
            }
        });

        FrameLayout imageView2 = (FrameLayout) findViewById(R.id.item2);
        final RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.bottom2);
        Palette.generateAsync(drawableToBitmap(getResources().getDrawable(R.drawable.item2)), new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getVibrantSwatch();
                if (swatch != null) {
                    relativeLayout2.setBackgroundColor(swatch.getRgb());
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.item2));
                intent.putExtras(bundle);
                startActivity(intent, ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this, relativeLayout2, "item").toBundle());
            }
        });

        FrameLayout imageView3 = (FrameLayout) findViewById(R.id.item3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "888", Toast.LENGTH_SHORT).show();
            }
        });
        final RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.bottom3);

        Palette.generateAsync(drawableToBitmap(getResources().getDrawable(R.drawable.item3)), new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getVibrantSwatch();
                if (swatch != null) {
                    relativeLayout3.setBackgroundColor(swatch.getRgb());
                }
            }
        });

        FrameLayout imageView4 = (FrameLayout) findViewById(R.id.item4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "999", Toast.LENGTH_SHORT).show();
            }
        });
        final RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.bottom4);

        Palette.generateAsync(drawableToBitmap(getResources().getDrawable(R.drawable.item4)), new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getVibrantSwatch();
                if (swatch != null) {
                    relativeLayout4.setBackgroundColor(swatch.getRgb());
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bd = (BitmapDrawable) drawable;
        bitmap = bd.getBitmap();
        return bitmap;
    }
}
