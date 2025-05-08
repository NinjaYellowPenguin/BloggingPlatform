package yellowpenguin.ninja.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import yellowpenguin.ninja.dto.post.CreatePostRequest;
import yellowpenguin.ninja.dto.post.PostResponse;

@Controller
@RequestMapping("/api/posts")
public class PostController {
	
	@PostMapping
	public ResponseEntity<PostResponse> createPost(@RequestBody CreatePostRequest createPostRequest){
		return null;
	}

}
