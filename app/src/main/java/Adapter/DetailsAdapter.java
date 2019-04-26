package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bloodbankmanagementsystem.DetailsActivity;
import com.example.bloodbankmanagementsystem.R;

import java.util.List;

import Model.Details;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {
    Context mContext;
    List<Details> detailsList;

    public DetailsAdapter(Context mContext, List<Details> detailsList) {
        this.mContext = mContext;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.details, viewGroup, false);
            return new DetailsViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder detailsViewHolder, int i) {
        final Details details=detailsList.get(i);
        detailsViewHolder.imgProfile.setImageResource(details.getImageId());
        detailsViewHolder.tvName.setText(details.getName());
        detailsViewHolder.tvBlood.setText(details.getBlood());
//        detailsViewHolder.tvGender.setText(details.getGender());
//        detailsViewHolder.tvAddress.setText(details.getAddress());
//        detailsViewHolder.tvEmail.setText(details.getEmailId());
//        detailsViewHolder.tvPhoneNo.setText(details.getPhoneNo());
//


        detailsViewHolder.imgProfile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailsActivity.class);
                intent.putExtra("image",details.getImageId());
                intent.putExtra("name",details.getName());
                intent.putExtra("phone",details.getPhoneNo());
                intent.putExtra("email",details.getEmailId());
                intent.putExtra("address",details.getAddress());
                intent.putExtra("gender",details.getGender());
                intent.putExtra("blood",details.getBlood());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgProfile;
        TextView tvName,tvPhoneNo,tvEmail,tvAddress,tvGender,tvBlood;
        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile=itemView.findViewById(R.id.imgProfile);
            tvName=itemView.findViewById(R.id.tvName);
            tvPhoneNo=itemView.findViewById(R.id.tvPhoneNo);
            tvEmail=itemView.findViewById(R.id.tvEmail);
            tvAddress=itemView.findViewById(R.id.tvAddress);
            tvGender=itemView.findViewById(R.id.tvGender);
            tvBlood=itemView.findViewById(R.id.tvBlood);
        }

        }
    }


