package com.example.tutorial1;

import android.content.Context;

import com.example.tutorial1.backend.JavaService;
import com.example.tutorial1.backend.UserJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivityPresenter {

    private MainActivityView view;
    private JavaService javaService;

    public MainActivityPresenter(Context context, MainActivityView view) {
        this.view = view;
        javaService = new JavaService(context);
    }

    public void downloadData() {
        List<UserJava> javaUsers = javaService.getJavaUsers();
        view.showList(javaUsers);
    }

    public void refreshData(FilterType filterType) {
        List<UserJava> javaUsers = javaService.getJavaUsers();
        List<UserJava> filteredList = new ArrayList<>();
        switch (filterType) {
            case MORE_THAN_25:
                filteredList = new FilterList().filterList(javaUsers, filter, 25);
                break;
            case MORE_THAN_50:
                filteredList = new FilterList().filterList(javaUsers, filter, 25);
                break;
            case MORE_THAN_100:
                filteredList = new FilterList().filterList(javaUsers, filter, 25);
                break;
            default:
                break;
        }
        Collections.sort(filteredList, new Comparator<UserJava>() {
            @Override
            public int compare(UserJava userJava, UserJava t1) {
                return t1.getVote().compareTo(userJava.getVote());
            }
        });
        view.refreshList(filteredList);
        view.terminateLoading();
    }

    enum FilterType {
        MORE_THAN_25, MORE_THAN_50, MORE_THAN_100
    }

    interface Filter<T, E> {
        boolean isMatched(T object, E value);
    }

    public class FilterList<E> {
        public <T> List filterList(List<T> originalList, Filter filter, E value) {
            List<T> filterList = new ArrayList<>();
            for (T object : originalList) {
                if (filter.isMatched(object, value)) {
                    filterList.add(object);
                }
            }
            return filterList;
        }
    }

    Filter<UserJava, Integer> filter = new Filter<UserJava, Integer>() {
        public boolean isMatched(UserJava object, Integer value) {
            return object.getVote() > value;
        }
    };
}
