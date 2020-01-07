package DenysTeam.REST_API;

import java.util.ArrayList;
import java.util.List;

public class BlogMockedData {
	private List<Blog> blogs;
	
	private static BlogMockedData instance = null;
	public static BlogMockedData getInstance(){
		if(instance == null){
			instance = new BlogMockedData();
		}
		return instance;
	}
	
	public BlogMockedData(){
		blogs = new ArrayList<Blog>();
		blogs.add(new Blog(1, "First post", "Content of first post"));
		blogs.add(new Blog(2, "Ssecond post", "Content of second post"));
		blogs.add(new Blog(3, "Third post", "Content of third post"));
	}
	
	//return all posts
	public List<Blog> fetchBlogs(){
		return blogs;
	}
	
	//return post by id
	public Blog getBlogById(int id){
		for(Blog b: blogs){
			if(b.getId() == id){
				return b;
			}
		}
		return null;
	}
	
	//search post by text
	public List<Blog> searchBlogs(String searchTerm){
		List<Blog> searchBlogs = new ArrayList<Blog>();
		for(Blog b: blogs){
			if(b.getTitle().toLowerCase().contains(searchTerm.toLowerCase())||
					b.getContent().toLowerCase().contains(searchTerm.toLowerCase())){
				searchBlogs.add(b);
			}
		}
		return searchBlogs;
	}
	
	//create post
	public Blog createBlog(int id, String title, String content){
		Blog newBlog = new Blog(id, title, content);
		blogs.add(newBlog);
		return newBlog;
	}
	
	//update post
	public Blog updateBlog(int id, String title, String content){
		for(Blog b: blogs){
			if(b.getId() == id){
				int blogIndex = blogs.indexOf(b);
				b.setTitle(title);
				b.setContent(content);
				blogs.set(blogIndex, b);
				return b;
			}
		}
		return null;
	}
	
	//delete post by id
	public boolean delete(int id){
		int blogIndex = -1;
		for(Blog b: blogs){
			if(b.getId() == id){
				blogIndex = blogs.indexOf(b);
				continue;
			}
		}
		if(blogIndex > -1){
			blogs.remove(blogIndex);
		}
		return true;
	}
	
}
