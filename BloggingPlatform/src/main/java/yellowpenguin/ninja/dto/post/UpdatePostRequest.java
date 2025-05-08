package yellowpenguin.ninja.dto.post;
import java.util.List;

public class UpdatePostRequest {
	private String id;
	private String title;
	private String content;
	private String category;
	private List<String> tags;
}
