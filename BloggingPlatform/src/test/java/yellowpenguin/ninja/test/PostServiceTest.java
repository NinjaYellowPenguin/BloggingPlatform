package yellowpenguin.ninja.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityNotFoundException;
import yellowpenguin.ninja.dto.post.CreatePostRequest;
import yellowpenguin.ninja.dto.post.PostResponse;
import yellowpenguin.ninja.dto.post.UpdatePostRequest;
import yellowpenguin.ninja.repositories.PostRepository;
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
	
	@Test
	public void testRead() {
		
		CreatePostRequest request = new CreatePostRequest();
		request.setTitle("Historias de un pingüino");
		request.setCategory("Peces");
		request.setTags(new ArrayList<String>());
		request.setContent("He podido comer muchos peces hoy, me siento satisfecho y gordito.");
		
		PostResponse response = service.create(request);
		
		PostResponse readResponse = service.read(response.getId());
		
		assertEquals(request.getCategory(), readResponse.getCategory());		
	}
	

    @Test
    public void testReadThrowsEntityNotFoundException() {
        PostRepository mockRepo = mock(PostRepository.class);
        PostService postService = service;
        String nonExistentId = "123";
        when(mockRepo.findById(nonExistentId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> postService.read(nonExistentId),
                "Expected read() to throw EntityNotFoundException when ID does not exist.");
    }
	
    @Test
	public void testUpdate() {
		
		CreatePostRequest request = new CreatePostRequest();
		request.setTitle("Historias de un pingüino");
		request.setCategory("Peces");
		request.setTags(new ArrayList<String>());
		request.setContent("He podido comer muchos peces hoy, me siento satisfecho y gordito.");		
		PostResponse response = service.create(request);
		
		UpdatePostRequest updateRequest = new UpdatePostRequest();
		updateRequest.setId(response.getId());
		updateRequest.setCategory("Muchos Peces!");
		
		PostResponse updateResponse = service.update(updateRequest);		
		PostResponse readResponse = service.read(updateResponse.getId());
		
		assertEquals(updateRequest.getCategory(), readResponse.getCategory());		
	}
	
	

}
