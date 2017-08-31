package com.rental.android.sixt.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.rental.android.sixt.R;
import com.rental.android.sixt.models.CarDetailsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anuja on 8/30/17.
 */

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<CarDetailsResponse> data;
    private Context context;

    public CarsAdapter(Context context, ArrayList<CarDetailsResponse> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }


    @Override
    public CarsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_item, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final CarsAdapter.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.carModelName.setText(data.get(position).getCarName());
        holder.carLiscenceNo.setText(data.get(position).getLiscensePlate());
        holder.carModelColor.setText("("+data.get(position).getCarColor()+")");
        holder.carCleanliness.setText(data.get(position).getCleanliness());
        holder.carFuelType.setText(data.get(position).getFuelType() + "(" + data.get(position).getFuelLevel() + ")");
        String images = data.get(position).getImageURl();
        final String url = "https://prod.drive-now-content.com/fileadmin/user_upload_global/assets/cars/" + data.get(position).getModelId() + "/" + data.get(position).getCarColor() + "/2x/car.png";

        Log.d("url", url);
        Glide.with(context)
                .load(url)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Glide.with(context)
                                .load("https://drop.ndtv.com/albums/AUTO/mercedes-amg_gt_c/16_294117_204119_2170.jpg")
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .skipMemoryCache(true)
                                .into(holder.carImage);


                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(holder.carImage);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(CarDetailsResponse Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView carModelName, carModelColor, carLiscenceNo, carFuelType, carCleanliness;
        ImageView carImage;

        public ViewHolder(View itemView) {
            super(itemView);
            carModelName = (TextView) itemView.findViewById(R.id.modelName);
            carModelColor = (TextView) itemView.findViewById(R.id.color);
            carLiscenceNo = (TextView) itemView.findViewById(R.id.liscenceNo);
            carFuelType = (TextView) itemView.findViewById(R.id.fuelTypeVal);
            carCleanliness = (TextView) itemView.findViewById(R.id.cleanlinessVal);
            carImage = (ImageView) itemView.findViewById(R.id.cars_image);

        }


        public void click(final CarDetailsResponse carDetailsResponse, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(carDetailsResponse);
                }
            });
        }
    }


}
