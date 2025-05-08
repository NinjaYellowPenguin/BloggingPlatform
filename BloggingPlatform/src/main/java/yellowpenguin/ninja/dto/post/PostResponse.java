package yellowpenguin.ninja.dto.post;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import yellowpenguin.ninja.models.Post;

@Getter
@Setter
public class PostResponse {
	private String id;
	private String title;
	private String content;
	private String category;
	private List<String> tags;
	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	@JsonProperty("updated_at")
	private LocalDateTime updatedAt;
	
	public PostResponse() {}
	
	public PostResponse(Post post) {
		
		this.id = post.getId();
		this.title = post.getTitle();
		this.content = post.getContent();
		this.category = post.getCategory();
		this.tags = post.getTags();
		this.createdAt = post.getCreatedAt();
		this.updatedAt = post.getUpdatedAt();
		
	}
	
}
	
	
