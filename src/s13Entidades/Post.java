package s13Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	private List<Comment> comments;

	// construtores
	public Post() {
	}

	public Post(Date moment, String title, String content, Integer likes) {
		this.setMoment(moment);
		this.setTitle(title);
		this.setContent(content);
		this.setLikes(likes);
		this.comments = new ArrayList<Comment>();
	}

	// getters e setters
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	// metodos especificos da classe
	public void addComent(Comment comment) {
		this.comments.add(comment);
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String output = this.getTitle() + "\n" + this.getLikes() + " Likes - " + sdf.format(this.getMoment()) + "\n"
				+ this.getContent() + "\n" + "Comments:\n";
		for (Comment comment : this.getComments()) {
			output += comment.getText() + "\n";
		}
		return output;
	}

}
