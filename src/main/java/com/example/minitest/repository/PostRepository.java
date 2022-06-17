package com.example.minitest.repository;

import com.example.minitest.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Posts,Long> {
    Iterable<Posts> findAllByTitleContaining(String title);

    @Query(value = "select * from Posts order by likes desc limit 4 ", nativeQuery = true)
    Iterable<Posts> findTop4New();

    @Query(value = "select * from Posts order by likes asc ", nativeQuery = true)
    Iterable<Posts> findAllByLikesAsc();


}
