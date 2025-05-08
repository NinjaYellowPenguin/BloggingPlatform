package yellowpenguin.ninja.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import yellowpenguin.ninja.dto.post.CreatePostRequest;
import yellowpenguin.ninja.dto.post.DeletePostRequest;
import yellowpenguin.ninja.dto.post.DeletePostResponse;
import yellowpenguin.ninja.dto.post.PostResponse;
import yellowpenguin.ninja.dto.post.UpdatePostRequest;
import yellowpenguin.ninja.models.Post;
import yellowpenguin.ninja.repositories.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public PostResponse create(CreatePostRequest request) {
		Post post = new Post();
		post.setId(UUID.randomUUID().toString());
		post.setCategory(request.getCategory());
		post.setContent(request.getContent());
		post.setCreatedAt(LocalDateTime.now());
		post.setTags(request.getTags());
		post.setTitle(request.getTitle());
		post.setUpdatedAt(null);		
		
		return new PostResponse(repo.save(post));
	}
	
	public PostResponse read(String id) {
		Optional<Post> optional = repo.findById(id);
		if(optional.isEmpty()) {
			throw new EntityNotFoundException("Id doesen't exist.");
		}
		return new PostResponse(optional.get());
	}
	
	public PostResponse update(UpdatePostRequest request) {
		return null;
	}
	
	public DeletePostResponse delete(DeletePostRequest request) {
		return null;
	}
	
	
}
