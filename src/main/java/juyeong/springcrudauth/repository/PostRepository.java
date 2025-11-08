package juyeong.springcrudauth.repository;

import juyeong.springcrudauth.model.Post;
import juyeong.springcrudauth.model.PostEdit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    Optional<Post> findById(int id);

    int updateById(int id, PostEdit postEdit);
}
