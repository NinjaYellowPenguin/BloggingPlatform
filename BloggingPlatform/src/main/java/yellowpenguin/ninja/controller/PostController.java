package yellowpenguin.ninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import yellowpenguin.ninja.dto.post.CreatePostRequest;
import yellowpenguin.ninja.dto.post.PostResponse;
import yellowpenguin.ninja.services.PostService;

@Controller
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@PostMapping
	public ResponseEntity<PostResponse> createPost(@RequestBody CreatePostRequest createPostRequest){		
		return ResponseEntity.status(201).body(service.create(createPostRequest));
	}

}
