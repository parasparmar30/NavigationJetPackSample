package com.example.navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String msg = getArguments().getString("msg");
        TextView tvMsg = view.findViewById(R.id.txt);
        tvMsg.setText("Message from first fragment "+msg);
        Button button = view.findViewById(R.id.btnVwBck);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NavController navController = Navigation.findNavController(getActivity(), R.id.fragentplace);
                navController.navigateUp();
                navController.addOnNavigatedListener(new NavController.OnNavigatedListener() {
                    @Override
                    public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
                        Log.d("TAG", destination.getLabel() + " ");
                    }
                });
            }
        });
    }

}
