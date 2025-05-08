package yellowpenguin.ninja.dto.post;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequest {

	private String title;
	private String content;
	private String category;
	private List<String> tags;

}
