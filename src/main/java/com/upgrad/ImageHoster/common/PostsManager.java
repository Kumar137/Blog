package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Post;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class PostsManager {

    private FileOperations<Post> fileOperations;

    public PostsManager() {
        fileOperations = FileOperations.getInstance();
    }

    public List<Post> readAllPosts() {

        return (ArrayList<Post>) fileOperations.readAllFiles(Constants.POST_DIR_NAME);
    }

    public List<Post> getThreePosts() {

        return (ArrayList<Post>) fileOperations.readRecentFiles(3, Constants.POST_DIR_NAME);
    }

    public static int numberOfPosts() {

        File file = new File(Constants.POST_DIR_NAME);
        File[] files = file.listFiles();
        return files.length;
    }

    public boolean deletePost(final String postTitle) {

        return (boolean) fileOperations.deleteFile(Constants.POST_FILE_PREFIX, postTitle);
    }

    public Post writeToFile(final Post post) {

        return (Post) fileOperations.writeToFile(Constants.POST_FILE_PREFIX, post, post.getTitle());
    }

    public Post getPost(final String prefix) {
        return (Post) fileOperations.readFile(Constants.POST_FILE_PREFIX, prefix);
    }
}
