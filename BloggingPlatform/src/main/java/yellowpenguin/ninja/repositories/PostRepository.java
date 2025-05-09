package yellowpenguin.ninja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yellowpenguin.ninja.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String>{

}
