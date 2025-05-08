package yellowpenguin.ninja.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import yellowpenguin.ninja.dto.post.CreatePostRequest;
import yellowpenguin.ninja.dto.post.PostResponse;
import yellowpenguin.ninja.services.PostService;

@SpringBootTest
public class PostServiceTest {
	@Autowired
	private PostService service;
	
	@Test
	public void testCreate() {
		CreatePostRequest request = new CreatePostRequest();
		request.setTitle("Historias de un pingüino");
		request.setCategory("Peces");
		request.setTags(new ArrayList<String>());
		request.setContent("He podido comer muchos peces hoy, me siento satisfecho y gordito.");
		
		PostResponse response = service.create(request);
		
		assertNotNull(response.getId());
		
	}
	

}
