package donovan.ctrl.viewpagerzom;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class SecondActivity extends AppCompatActivity {
    private CircleIndicator indicator;
    private ViewPager viewPager;
    Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        viewPager = (ViewPager) findViewById(R.id.vpDetail);
        indicator = (CircleIndicator) findViewById(R.id.indicator);

        ArrayList<Integer> gambar = new ArrayList<>();
        gambar.add(0, (R.drawable.img_one));
        gambar.add(1, (R.drawable.img_two));


        adapter = new Adapter(SecondActivity.this, gambar);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

    }

}
