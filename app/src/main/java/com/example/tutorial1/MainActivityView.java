package com.example.tutorial1;

import com.example.tutorial1.backend.UserJava;

import java.util.List;

public interface MainActivityView {

    void showList(List<UserJava> javaUsers);

    void refreshList(List<UserJava> javaUsers);

    void terminateLoading();
}
