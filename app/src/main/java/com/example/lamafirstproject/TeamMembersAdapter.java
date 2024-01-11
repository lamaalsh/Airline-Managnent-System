package com.example.lamafirstproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeamMembersAdapter extends RecyclerView.Adapter<TeamMembersAdapter.TeamMemberViewHolder> {

    private List<TeamMember> teamMembers;

    public TeamMembersAdapter(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @NonNull
    @Override
    public TeamMemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_member_card, parent, false);
        return new TeamMemberViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull TeamMemberViewHolder holder, int position) {
        TeamMember teamMember = teamMembers.get(position);
        holder.memberName.setText(teamMember.getName());
        holder.memberImage.setImageResource(teamMember.getImageResource());

        // Adjust image size programmatically
        ViewGroup.LayoutParams layoutParams = holder.memberImage.getLayoutParams();
        layoutParams.width = 200; // Set width in pixels
        layoutParams.height = 200; // Set height in pixels
        holder.memberImage.setLayoutParams(layoutParams);
    }


    @Override
    public int getItemCount() {
        return teamMembers.size();
    }

    static class TeamMemberViewHolder extends RecyclerView.ViewHolder {
        ImageView memberImage;
        TextView memberName;

        TeamMemberViewHolder(View itemView) {
            super(itemView);
            memberImage = itemView.findViewById(R.id.memberImage);
            memberName = itemView.findViewById(R.id.memberName);
        }
    }
}
