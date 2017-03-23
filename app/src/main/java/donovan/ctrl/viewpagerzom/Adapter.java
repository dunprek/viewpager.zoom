package donovan.ctrl.viewpagerzom;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;


/**
 * Created by don on 3/23/2017.
 */
public class Adapter extends PagerAdapter {

    private Context mContext;
    private List<Integer> imageList;


    public Adapter(Context mContext, List<Integer> imageList) {
        this.mContext = mContext;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        View itemView;

        if (Constants.STATUS_IMAGE.equals("")) {
            itemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_product_detail, container, false);

        } else {
            itemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_full, container, false);

        }
        ImageView imageView = (ImageView) itemView.findViewById(R.id.ivDetail);
        imageView.setImageResource(imageList.get(position));


        if (Constants.STATUS_IMAGE.equals("")) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Constants.STATUS_IMAGE="1";
                    Intent intent = new Intent(mContext, SecondActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });
        }

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}