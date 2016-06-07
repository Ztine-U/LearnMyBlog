package com.blacktea.ztine.learnmyblog.adapter;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.TextView;

import com.blacktea.ztine.learnmyblog.R;
import com.blacktea.ztine.learnmyblog.model.Blog;
import com.blacktea.ztine.learnmyblog.utils.TimeUtil;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ztine on 16/6/5.
 */
public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.BlogListViewHolder> {

    private List<Blog> mBlogs;
    private Context context;

    public BlogListAdapter(Context context, List<Blog> mBlogs) {
        this.context = context;
        this.mBlogs = mBlogs;

    }

    @Override
    public BlogListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BlogListViewHolder holder = new BlogListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(BlogListViewHolder holder, int position) {
        Blog blog = mBlogs.get(position);
//        if(blog.getAuthor().getaAvatar() != null && !"".equals(blog.getAuthor().getaAvatar()))
//        {
            Picasso.with(context).load(blog.getAuthor().getaAvatar()).error(R.mipmap.avatar_default).into(holder.mHeadIcon);
//        }
        holder.mTitle.setText(blog.getbTitle());
        holder.mSummary.setText(blog.getbSummary());

        holder.mPostTime.setText(TimeUtil.DateToChineseString(TimeUtil.ParseUTCDate(blog.getbPublished())));
        holder.mDiggs.setText(blog.getbDiggs());
        holder.mComment.setText(blog.getbComments());
        holder.mViews.setText(blog.getbViews());


    }

    @Override
    public int getItemCount() {
        return mBlogs.size();
    }

    class BlogListViewHolder extends RecyclerView.ViewHolder
    {
        private RoundedImageView mHeadIcon;
        private TextView mTitle;
        private TextView mSummary;
        private TextView mPostTime;
        private TextView mDiggs;
        private TextView mComment;
        private TextView mViews;

        public BlogListViewHolder(View itemView) {
            super(itemView);
            mHeadIcon = (RoundedImageView) itemView.findViewById(R.id.rv_blogitem_head);
            mSummary  = (TextView) itemView.findViewById(R.id.tv_blogitem_summary);
            mPostTime = (TextView) itemView.findViewById(R.id.tv_blogitem_post);
            mDiggs = (TextView) itemView.findViewById(R.id.tv_blogitem_diggs);
            mComment = (TextView) itemView.findViewById(R.id.tv_blogitem_comments);
            mViews = (TextView) itemView.findViewById(R.id.tv_blogitem_views);
        }
    }
}
