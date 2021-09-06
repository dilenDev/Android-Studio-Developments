package com.mobdev.datapass_fragmenttofragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    private FragmentBListener listener;
    private EditText editText;

    //interface declaration and method declaration for the interface
    public interface FragmentBListener{
        void onInputBSent(CharSequence input);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b,container,false);

        editText = v.findViewById(R.id.edit_text);
        Button button = v.findViewById(R.id.button_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputBSent(input);
            }
        });

        return v;
    }

    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentBListener){
            listener = (FragmentBListener) context;
        }else {
            throw new RuntimeException(context.toString().concat("Interface method not implemented"));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
