package com.lastbit.battlepass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment {
    private LinearLayoutManager linearLayoutManager;
    private AdapterHelpMenu adapter;
    private RecyclerView recyclerView;


    public HelpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setStackFromEnd(false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new AdapterHelpMenu();
        recyclerView.setAdapter(adapter);
        adapter.addAsk(new ItemHelp(getString(R.string.ask1), getString(R.string.ask1_1)));
        adapter.addAsk(new ItemHelp(getString(R.string.ask2), getString(R.string.ask2_1)));
        adapter.addAsk(new ItemHelp(getString(R.string.ask3), getString(R.string.ask3_1)));
        adapter.addAsk(new ItemHelp(getString(R.string.ask4), getString(R.string.ask4_1)));
        adapter.addAsk(new ItemHelp(getString(R.string.ask5), getString(R.string.ask5_1)));
        adapter.addAsk(new ItemHelp(getString(R.string.ask6), getString(R.string.ask6_1)));
        adapter.addAsk(new ItemHelp(getString(R.string.ask7), getString(R.string.ask7_1)));
        adapter.addAsk(new ItemHelp(getString(R.string.ask8), getString(R.string.ask8_1)));





        return view;
    }

}