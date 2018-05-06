package tif16.sari.kartika.tutorial;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import tif16.sari.kartika.tutorial.Tab.MyAdapter;
import tif16.sari.kartika.tutorial.Tab.SlidingTabLayout;

public class DetailActivity extends AppCompatActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager)findViewById(R.id.vp_tab);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),this));

        mSlidingTabLayout = (SlidingTabLayout)findViewById(R.id.st_tab);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view,R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.no_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Beranda/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
