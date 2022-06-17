package com.example.minitest.service;

import com.example.minitest.model.Posts;
import com.example.minitest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServicePost implements IPostService {
    @Autowired
    PostRepository postRepository;


    @Override
    public Iterable<Posts> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Posts> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Posts post) {
        postRepository.save(post);


    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Iterable<Posts> findAllByTitleContaining(String title) {

        return postRepository.findAllByTitleContaining(title);
    }

    @Override
    public Iterable<Posts> findTop4() {
        return postRepository.findTop4New();
    }

    @Override
    public Iterable<Posts> findAllByLikesAsc() {
        return postRepository.findAllByLikesAsc();
    }
}
