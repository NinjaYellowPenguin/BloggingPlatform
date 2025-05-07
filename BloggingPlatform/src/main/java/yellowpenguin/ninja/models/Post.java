package yellowpenguin.ninja.models;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

	private String id;
	private String title;
	private String content;
	private String category;
	private List<String> tags;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Post() {
	}

}
