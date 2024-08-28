package com.example.fitflora_proto_one.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fitflora_proto_one.data.model.Tree;
import com.example.fitflora_proto_one.data.model.User;

import java.util.List;

public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<List<Tree>> TreesLiveData = new MutableLiveData<>();
    private final MutableLiveData<User> userProfileMutableLiveData = new MutableLiveData<>();

}