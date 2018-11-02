package com.ricky.fliktos.network;

import com.ricky.fliktos.model.PhotoFeed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class FlickrService {
    private final static String BASE_URL = "https://api.flickr.com/services/feeds/photos_public.gne/";

    private interface FlickrServiceInterface {
        @GET("?format=json&nojsoncallback=1")
        Call<PhotoFeed> getFeedPhotosPublic();
    }

    private static final Retrofit sRetrofitInstance = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static FlickrServiceInterface sFlickrService;

    private static FlickrServiceInterface getService() {
        if (sFlickrService == null) {
            sFlickrService = sRetrofitInstance.create(FlickrServiceInterface.class);
        }

        return sFlickrService;
    }

    /**
     * Get pubic photo feed from Flickr.
     * @param resultListCallback
     */
    public static void getFeedPhotosPublic(Callback<PhotoFeed> resultListCallback) {
        Call<PhotoFeed> call = getService().getFeedPhotosPublic();
        call.enqueue(resultListCallback);
    }
}
