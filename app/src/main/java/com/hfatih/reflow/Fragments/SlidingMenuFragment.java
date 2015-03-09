package com.hfatih.reflow.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfatih.reflow.R;
import com.pocketreddit.library.things.Subreddit;

import java.util.List;

/**
 * Created by fatih on 28.2.2015.
 */
public class SlidingMenuFragment extends Fragment {

	List<Subreddit> subreddits;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_slidingmenu, null);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
