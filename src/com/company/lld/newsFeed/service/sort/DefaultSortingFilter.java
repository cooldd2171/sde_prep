package com.company.lld.newsFeed.service.sort;


import com.company.lld.newsFeed.model.Post;

import java.util.List;

public class DefaultSortingFilter implements SortingFilter{
    @Override
    public List<Post> sort(List<Post> posts) {
        return posts;
    }
    
}
