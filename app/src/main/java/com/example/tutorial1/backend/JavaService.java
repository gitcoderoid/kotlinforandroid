package com.example.tutorial1.backend;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaService {

    private Context context;

    public JavaService(Context context) {
        this.context = context;
    }

    public List<UserJava> getJavaUsers() {
        List<UserJava> javaUsers = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            UserJava javaUser = new UserJava("Author " + i,
                    "Comments " + i,
                    getRandom(i),
                    "www.randomlink.com/image/" + i,
                    "Could not set on click action");
            javaUsers.add(javaUser);
        }
        return javaUsers;
    }

    private int getRandom(int i) {
        Random random = new Random();
        return random.nextInt(i) + 10;
    }
}