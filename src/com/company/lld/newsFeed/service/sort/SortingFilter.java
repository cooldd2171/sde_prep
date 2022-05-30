package com.company.lld.newsFeed.service.sort;


import com.company.lld.newsFeed.model.Post;

import java.util.List;

public interface SortingFilter {
    List<Post> sort(List<Post> posts);
}
