package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.common.PostsManager;
import com.upgrad.ImageHoster.model.Post;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostServiceImp implements PostService {

    private PostsManager postsManager;

    public PostServiceImp() {
        postsManager =new PostsManager();

    }


    @Override
    public Post create(Post post) {
        postsManager.writeToFile(post);
        return post;
    }

    @Override
    public List<Post> findAll() {
        return postsManager.readAllPosts();
    }


    @Override
    public List<Post> firstThreePosts() {
        return postsManager.getThreePosts();
    }

    @Override
    public Post findById(Long id) {
        return null;
    }

    @Override
    public Post editPost(Post post) {
        return null;
    }

    @Override
    public void deleteById(Post post) {
        postsManager.deletePost(post.getTitle());

    }
}
