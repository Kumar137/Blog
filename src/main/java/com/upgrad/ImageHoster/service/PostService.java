package com.upgrad.ImageHoster.service;


import com.upgrad.ImageHoster.model.Post;

import java.util.List;

public interface PostService {

    Post create(Post post);
    List<Post> findAll();
    List<Post> firstThreePosts();
    Post findById(Long id);
    Post editPost(Post post);
    void deleteById(Post post);
    
    //test
}
