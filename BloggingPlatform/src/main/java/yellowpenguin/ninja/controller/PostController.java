package yellowpenguin.ninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import yellowpenguin.ninja.dto.post.CreatePostRequest;
import yellowpenguin.ninja.dto.post.DeletePostRequest;
import yellowpenguin.ninja.dto.post.DeletePostResponse;
import yellowpenguin.ninja.dto.post.PostResponse;
import yellowpenguin.ninja.dto.post.ReadPostRequest;
import yellowpenguin.ninja.dto.post.UpdatePostRequest;
import yellowpenguin.ninja.services.PostService;

@Controller
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping
	public ResponseEntity<PostResponse> create(@RequestBody CreatePostRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(request));
	}

	@GetMapping
	public ResponseEntity<PostResponse> read(@RequestBody ReadPostRequest request) {
		return ResponseEntity.ok(postService.read(request.getId()));
	}

	@PutMapping
	public ResponseEntity<PostResponse> update(@RequestBody UpdatePostRequest request) {
		return ResponseEntity.ok(postService.update(request));
	}

	@DeleteMapping
	public ResponseEntity<DeletePostResponse> delete(@RequestBody DeletePostRequest request) {
		return ResponseEntity.ok(postService.delete(request));
	}
}
