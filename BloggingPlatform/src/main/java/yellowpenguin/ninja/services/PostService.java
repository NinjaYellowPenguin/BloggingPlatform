package yellowpenguin.ninja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yellowpenguin.ninja.dto.post.CreatePostRequest;
import yellowpenguin.ninja.dto.post.DeletePostRequest;
import yellowpenguin.ninja.dto.post.DeletePostResponse;
import yellowpenguin.ninja.dto.post.UpdatePostRequest;
import yellowpenguin.ninja.models.Post;
import yellowpenguin.repositories.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public Post create(CreatePostRequest request) {
		return null;
	}
	
	public Post read(String id) {
		return null;
	}
	
	public Post update(UpdatePostRequest request) {
		return null;
	}
	
	public DeletePostResponse delete(DeletePostRequest request) {
		return null;
	}
	
	
}
