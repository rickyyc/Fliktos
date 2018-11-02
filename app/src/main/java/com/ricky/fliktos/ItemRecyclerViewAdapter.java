package com.ricky.fliktos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.fliktos.ItemFragment.OnListFragmentInteractionListener;
import com.ricky.fliktos.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {

    private static final String SPACE_CHARACTER = " ";
    private static final String HASH_CHARACTER = "#";
    private final List<Item> mValues;
    private final OnListFragmentInteractionListener mListener;

    ItemRecyclerViewAdapter(List<Item> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        Picasso.get().load(holder.mItem.getMedia().getM()).into(holder.mImageView);

        holder.mTitleTextView.setText(holder.mItem.getTitle());
        holder.mAuthorTextView.setText(holder.itemView.getResources().getString(R.string.author_formatted, parseAuthor(holder.mItem.getAuthor())));

        holder.mTagsTextView.setText(formatTags(holder.mItem.getTags()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    private String parseAuthor(String input) {
        // simple way to extract the author display name
        int start = input.indexOf("(\"");
        int end = input.indexOf("\")");

        return input.substring(start + 2, end);
    }

    private String formatTags(String input) {
        StringBuilder output = new StringBuilder();

        String[] tags = input.trim().split(SPACE_CHARACTER);

        for (String tag :
                tags) {
            if (!tag.isEmpty()) {
                output.append(HASH_CHARACTER).append(tag).append(SPACE_CHARACTER);
            }
        }

        return output.toString();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Item mItem;
        final ImageView mImageView;
        final TextView mTitleTextView;
        final TextView mAuthorTextView;
        final TextView mTagsTextView;

        ViewHolder(View view) {
            super(view);

            mImageView = itemView.findViewById(R.id.photo);
            mTitleTextView = itemView.findViewById(R.id.title);
            mAuthorTextView = itemView.findViewById(R.id.author);
            mTagsTextView = itemView.findViewById(R.id.tags);
        }
    }
}
