package com.example.commentsappdemo.UI;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.commentsappdemo.R;
import com.example.commentsappdemo.UI.util.CommentAdaptor;
import com.example.commentsappdemo.model.Comments;
import com.example.commentsappdemo.viewmodel.CommentsViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private FragmentActivity myContext;
    private EditText userET;
    private EditText contentET;
    private Button btnPost;
    private RecyclerView commentsRV;
    private CommentsViewModel model;
    private View.OnClickListener postCommentListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String user = userET.getText().toString();
            String content = contentET.getText().toString();
            if (user.isEmpty() || content.isEmpty() ){
                return;

            }

            Comments comments = new Comments(user, content);
            model.insertComment(comments);

        }
    };

    public HomeFragment() {

    }

    public static HomeFragment  newInstance(){
        return new HomeFragment();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myContext = (FragmentActivity) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        model = new ViewModelProvider(myContext).get(CommentsViewModel.class);

        userET = rootView.findViewById(R.id.et_username);
        contentET = rootView.findViewById(R.id.et_content);
        btnPost = rootView.findViewById(R.id.btn_post);
        commentsRV = rootView.findViewById(R.id.rv_comments);

        CommentAdaptor adaptor = new CommentAdaptor();
        commentsRV.setAdapter(adaptor);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(myContext, RecyclerView.VERTICAL, false);
        commentsRV.setLayoutManager(layoutManager);


        model.getCOMMENTS().observe(myContext, new Observer<List<Comments>>() {
            @Override
            public void onChanged(List<Comments> comments) {
                adaptor.addItems(comments);
                    adaptor.notifyDataSetChanged();
            }
        });

        btnPost.setOnClickListener(postCommentListener);

        return rootView;

    }

}
