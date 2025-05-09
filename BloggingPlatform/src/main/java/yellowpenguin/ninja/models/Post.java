package yellowpenguin.ninja.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {
	@Id
	private String id;
	private String title;
	@Lob
	private String content;
	private String category;
	@ElementCollection
	private List<String> tags;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
