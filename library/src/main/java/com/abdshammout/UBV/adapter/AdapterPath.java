package com.abdshammout.UBV.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abdshammout.UBV.OnClickPathItem;
import com.abdshammout.UBV.library.R;
import com.abdshammout.UBV.model.PathItem;
import com.abdshammout.UBV.model.PathItemStyle;
import com.abdshammout.UBV.util.Constants;
import com.abdshammout.UBV.util.Utils;

import java.util.ArrayList;


public class AdapterPath extends RecyclerView.Adapter<AdapterPath.PathHolder>{

    private Context context;
    private ArrayList<PathItem> pathItemsList;
    private OnClickPathItem onClickPathItem;
    private PathItemStyle pathItemStyle;
    private LinearLayout.LayoutParams itemPathParams;
    private LinearLayout.LayoutParams activeItemPathParams;

    public AdapterPath(Context context, ArrayList<PathItem> pathItemsList,
                       OnClickPathItem onClickPathItem) {
        this.context = context;
        this.pathItemsList = pathItemsList;
        this.onClickPathItem = onClickPathItem;
        this.pathItemStyle = new PathItemStyle();
        initLayoutParams();
    }

    public void setPathItemStyle(PathItemStyle pathItemStyle) {
        this.pathItemStyle = pathItemStyle;
    }

    private void initLayoutParams(){
        int margin = Utils.convertDpToPx(context, 3);
        itemPathParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        itemPathParams.setMargins(margin, margin, margin, margin);

        activeItemPathParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        activeItemPathParams.setMargins(margin, margin, margin *16, margin);
    }


    @NonNull
    @Override
    public PathHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_path, parent,
                false);
        return new PathHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull PathHolder holder, int position) {
        holder.pathItemTitle.setText(pathItemsList.get(position).getTitle());
        if (position == getItemCount()-1){
            setActiveItemPathStyle(holder.pathItemTitle, position);
        } else {
            setItemPathStyle(holder.pathItemTitle, position);
        }
    }

    @Override
    public int getItemCount() {
        return pathItemsList.size();
    }


    class PathHolder extends RecyclerView.ViewHolder{
        TextView pathItemTitle;
        PathHolder(View itemView) {
            super(itemView);
            pathItemTitle = itemView.findViewById(R.id.pathItemTitle);
            pathItemTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PathItem pathItem = pathItemsList.get(getAdapterPosition());
                    onClickPathItem.onClick(getAdapterPosition(), pathItem.getTitle(), pathItem.getId());
                }
            });
            pathItemTitle.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    PathItem pathItem = pathItemsList.get(getAdapterPosition());
                    onClickPathItem.onLongClick(getAdapterPosition(), pathItem.getTitle(), pathItem.getId());
                    return false;
                }
            });
        }
    }


    //------- Item Path Style unActive -------
    private void setItemPathStyle(TextView titlePathItem, int position){
        PathItemStyle pathItemStyle;
        if (pathItemsList.get(position).getPathItemStyle() == null)
            pathItemStyle = this.pathItemStyle;
        else
            pathItemStyle = pathItemsList.get(position).getPathItemStyle();

        setItemPathBackground(titlePathItem, pathItemStyle);
        setItemPathTextColor(titlePathItem, pathItemStyle);
        titlePathItem.setLayoutParams(itemPathParams);
    }
    private void setItemPathBackground(TextView titlePathItem, PathItemStyle pathItemStyle){
        switch (pathItemStyle.getTypeBackgroundPathItem()){
            case Constants.TYPE_INT_RES:
                titlePathItem.setBackgroundResource(pathItemStyle.getPathItemBackgroundResId());
                break;
            case Constants.TYPE_INT_COLOR:
                titlePathItem.setBackgroundColor(pathItemStyle.getPathItemBackgroundColor());
                break;
            case Constants.TYPE_DRAWABLE:
                titlePathItem.setBackground(pathItemStyle.getPathItemBackgroundDrawable());
                break;
        }
    }
    private void setItemPathTextColor(TextView titlePathItem, PathItemStyle pathItemStyle){
        titlePathItem.setTextColor(pathItemStyle.getPathItemTextColor());
    }


    private void setActiveItemPathStyle(TextView titlePathItem, int position){
        PathItemStyle pathItemStyle;
        if (pathItemsList.get(position).isUseStyleAlsoInActive())
            pathItemStyle = pathItemsList.get(position).getPathItemStyle();
        else
            pathItemStyle = this.pathItemStyle;

        setActiveItemPathBackground(titlePathItem, pathItemStyle);
        setActiveItemPathTextColor(titlePathItem, pathItemStyle);
        titlePathItem.setLayoutParams(activeItemPathParams);
    }
    private void setActiveItemPathBackground(TextView titlePathItem, PathItemStyle pathItemStyle){
        switch (pathItemStyle.getActivePathItemBackgroundType()){
            case Constants.TYPE_INT_RES:
                titlePathItem.setBackgroundResource(pathItemStyle.getActivePathItemBackgroundResId());
                break;
            case Constants.TYPE_INT_COLOR:
                titlePathItem.setBackgroundColor(pathItemStyle.getActivePathItemBackgroundColor());
                break;
            case Constants.TYPE_DRAWABLE:
                titlePathItem.setBackground(pathItemStyle.getActivePathItemBackgroundDrawable());
                break;
        }
    }
    private void setActiveItemPathTextColor(TextView titlePathItem, PathItemStyle pathItemStyle){
        titlePathItem.setTextColor(pathItemStyle.getActivePathItemTextColor());
    }


}
