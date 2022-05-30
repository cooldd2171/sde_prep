package com.company.lld.newsFeed.service.sort;


import com.company.lld.newsFeed.model.Post;

import java.util.Comparator;
import java.util.List;

public class CommentBasedSortingFilter implements SortingFilter{
    @Override
    public List<Post> sort(List<Post> posts) {
        posts.sort(new CustomComparator());
        return posts;
    }

    public class CustomComparator implements Comparator<Post> {

        @Override
        public int compare(Post o1, Post o2) {
            return o2.getComments().size()-o1.getComments().size();
        }
    }
}
