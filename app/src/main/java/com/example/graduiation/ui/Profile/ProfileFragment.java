package com.example.graduiation.ui.Profile;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.graduiation.R;
import com.example.graduiation.ui.Data.UserParentModel;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private View root;
    private ProfileViewModel viewModel;
    private CircleImageView userProfilePicture;
    private TextView userName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_profile, container, false);
        userProfilePicture = root.findViewById(R.id.profileImage);
        userName = root.findViewById(R.id.tvUserName);

        viewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        viewModel.getUserParentModel(FirebaseAuth.getInstance().getUid()).observe(this, new Observer<UserParentModel>() {
            @Override
            public void onChanged(UserParentModel userParentModel) {
                if (userParentModel != null) {
                    userName.setText(userParentModel.getName());
                    Picasso.get().load(userParentModel.getImage()).networkPolicy(NetworkPolicy.OFFLINE).into(userProfilePicture, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError(Exception e) {
                            Picasso.get().load(userParentModel.getImage()).into(userProfilePicture);

                        }
                    });


                }
            }
        });


        return root;
    }
}
