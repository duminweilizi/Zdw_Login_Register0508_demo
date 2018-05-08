package bawei.com.zhangduwei0508login_register_test.modle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;

import bawei.com.zhangduwei0508login_register_test.R;


public class MyAdater extends BaseAdapter {
    private Context context;
    private List<GoosListBean.DataBean> data;

    public MyAdater(Context context,List<GoosListBean.DataBean> data){
        this.context=context;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder=null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item_layout,null);

            ImageView imageView=convertView.findViewById(R.id.item_pic);
            TextView textView = convertView.findViewById(R.id.item_title);
            myViewHolder=new MyViewHolder(imageView,textView);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder= (MyViewHolder) convertView.getTag();
        }
        //赋值
        String images = data.get(position).getImages();
        String pic_url= images.split("\\|")[0];
        Glide.with(context).load(pic_url).into(myViewHolder.getImageView());
        myViewHolder.getTextView().setText(data.get(position).getTitle());

        return convertView;
    }

    class MyViewHolder{
        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(ImageView imageView, TextView textView) {
            this.imageView = imageView;
            this.textView = textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }

}
