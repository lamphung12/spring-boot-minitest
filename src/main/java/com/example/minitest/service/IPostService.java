package com.example.minitest.service;

import com.example.minitest.model.Posts;

public interface IPostService extends GeneralService<Posts>{

    Iterable<Posts> findAllByTitleContaining(String title);

    Iterable<Posts> findTop4();

    Iterable<Posts> findAllByLikesAsc();

}
