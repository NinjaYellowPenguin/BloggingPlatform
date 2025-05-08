package yellowpenguin.ninja.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

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
		return new PostResponse(findById(id));
	}
	
	private Post findById(String id) {
		Optional<Post> optional = repo.findById(id);
		if(optional.isEmpty()) {
			throw new EntityNotFoundException("Id doesen't exist.");
		}
		return optional.get();		
	}
	
	public PostResponse update(UpdatePostRequest request) {
		Post post = findById(request.getId());
		post.setCategory(request.getCategory());
		post.setTitle(request.getTitle());
		post.setContent(request.getContent());
		post.setTags(request.getTags());
		post.setUpdatedAt(LocalDateTime.now());
		return new PostResponse(repo.save(post));
	}
	
	public DeletePostResponse delete(DeletePostRequest request) {
		Post post = findById(request.getId());
		repo.deleteById(request.getId());
		DeletePostResponse response = new DeletePostResponse();
		response.setId(request.getId());
		response.setTitle(post.getTitle());
		return response;
	}
	
	
}
