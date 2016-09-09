package com.example.tutorial1;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tutorial1.backend.UserJava;

import java.util.List;

import static com.example.tutorial1.MainActivityPresenter.*;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter javaPresenter;
    private JavaRecyclerView javaAdapter;
    private RecyclerView mainActivityList;
    private SwipeRefreshLayout swipeRefreshLayout;

    private int swipeCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mainActivityList = (RecyclerView) findViewById(R.id.main_activity_list);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mainActivityList.setLayoutManager(llm);
        javaAdapter = new JavaRecyclerView(this);
        mainActivityList.setAdapter(javaAdapter);
        javaPresenter = new MainActivityPresenter(getApplicationContext(), this);
        javaPresenter.downloadData();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                javaPresenter.refreshData(getFilterType());
                swipeCounter++;
            }
        });
    }

    @Override
    public void showList(List<UserJava> javaUsers) {
        javaAdapter.setList(javaUsers);
    }

    @Override
    public void refreshList(List<UserJava> javaUsers) {
        javaAdapter.setList(javaUsers);
    }

    @Override
    public void terminateLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    public FilterType getFilterType() {
        switch (swipeCounter) {
            case 0:
                return FilterType.MORE_THAN_25;
            case 1:
                return FilterType.MORE_THAN_25;
            case 2:
                return FilterType.MORE_THAN_25;
            default:
                swipeCounter = 0;
                return FilterType.MORE_THAN_25;
        }
    }
}