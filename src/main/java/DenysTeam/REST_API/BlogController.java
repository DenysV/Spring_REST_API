package DenysTeam.REST_API;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
	
	@RequestMapping("/")
	public String Index(){
		return "Hello Docker world!";
	} 
	 
	BlogMockedData blogMockedData = BlogMockedData.getInstance();
	
	@GetMapping("/blog")
	public List<Blog> index(){
		return blogMockedData.fetchBlogs(); 
	}
	
	@GetMapping("/blog/{id}")
	public Blog show(@PathVariable String id){
		int BlogId = Integer.parseInt(id);
		return blogMockedData.getBlogById(BlogId); 
	}
	
	@PostMapping("/blog/search")
	public List<Blog> search(@RequestBody Map<String, String> body){
		String searchItem = body.get("text");
		return blogMockedData.searchBlogs(searchItem);
	}
	/*
	@JsonManagedReference(value="anyName")
	@JsonBackReference(value="anyName")
	*/
	@PostMapping(value="/blog", consumes={MediaType.APPLICATION_JSON_UTF8_VALUE}, produces="application/json;charset=UTF-8")
	public Blog create(@RequestBody(required=false) Map<String, String> body){
	//public Blog create(@RequestPart("title") String title, @RequestPart("content") String content){
		int id = Integer.parseInt(body.get("id"));
		String title = body.get("title");
		String content = body.get("content");
		return blogMockedData.createBlog(id, title, content);
	}
	
	@PutMapping("/blog/{id}")
	public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
		int blogId = Integer.parseInt(id);
		String title = body.get("title");
		String content = body.get("content");
		return blogMockedData.updateBlog(blogId, title, content);
	}
	
	@DeleteMapping("/blog/{id}")
	public boolean delete(@PathVariable String id){
		int blogId = Integer.parseInt(id);
		return blogMockedData.delete(blogId);
	}
	
}
