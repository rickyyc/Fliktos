package com.ricky.fliktos.controller;

import android.support.annotation.NonNull;

import com.ricky.fliktos.model.Item;
import com.ricky.fliktos.model.PhotoFeed;
import com.ricky.fliktos.network.FlickrService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Manages the data as fetched from the server.
 */
public class PaginatedPhotoListController {
    /**
     * Listener to be notified when new data has arrived.
     */
    public interface PaginatedListControllerListener {
        void isLoading(boolean isLoading);

        void loaded();

        void failed();
    }

    private List<Item> mPhotoList;
    private PaginatedListControllerListener mListener;
    private boolean mIsLoading = false;

    private PaginatedPhotoListController() {
        // do nothing
    }

    public PaginatedPhotoListController(@NonNull PaginatedListControllerListener listener) {
        mPhotoList = new ArrayList<>();
        mListener = listener;
    }

    public void fetch() {
        mIsLoading = true;
        mListener.isLoading(true);
        FlickrService.getFeedPhotosPublic(getResultListCallback());
    }

    @NonNull
    private Callback<PhotoFeed> getResultListCallback() {
        return new Callback<PhotoFeed>() {
            @Override
            public void onResponse(@NonNull Call<PhotoFeed> call, @NonNull Response<PhotoFeed> response) {
                PhotoFeed photoFeed = response.body();

                if (photoFeed != null && photoFeed.getItems() != null && photoFeed.getItems().size() > 0) {
                    mPhotoList.addAll(photoFeed.getItems());
                    mListener.loaded();
                }

                mIsLoading = false;
                mListener.isLoading(false);
            }

            @Override
            public void onFailure(@NonNull Call<PhotoFeed> call, @NonNull Throwable t) {
                call.cancel();
                mIsLoading = false;
                mListener.isLoading(false);
                mListener.failed();
            }
        };
    }

    public boolean isLoading() {
        return mIsLoading;
    }

    public List<Item> getPhotoList() {
        return mPhotoList;
    }
}
