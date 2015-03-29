package com.taobao.recyclerviewwithcardview.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taobao.recyclerviewwithcardview.R;

import java.util.List;

/**
 * Created by jianjian.sjj on 2015/3/25.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>
{
    private List<String> mDataSet = null;
    private OnItemClickListener mListener;

    public MainAdapter(List<String> dataSet)
    {
        this.mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,viewGroup,false);
        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mListener != null)
                    mListener.onItemClick(v, (String) itemView.getTag());
            }

        });
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i)
    {
        String data = mDataSet.get(i);
        viewHolder.bindData(data);
        viewHolder.itemView.setTag(data);
    }

    @Override
    public int getItemCount()
    {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv;
        public ViewHolder(View itemView)
        {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.info_text);
        }

        public void bindData(String s)
        {
            if(s != null)
                tv.setText(s);
        }
    }

    public interface OnItemClickListener
    {
        public void onItemClick(View view,String data);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mListener = listener;
    }
}
