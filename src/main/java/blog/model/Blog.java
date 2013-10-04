package blog.model;
import java.io.Serializable;
import java.util.List;

public class Blog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7141228064615017959L;
	private long blogId;
	private String title;
	private String content;
	private String brief;
	private long contentId;
	private java.util.Date createDate;
	private java.util.Date lastModify;
	private int accessTimes;
	private List<Tag> tags;
	private Category category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAccessTimes(int accessTimes) {
		this.accessTimes = accessTimes;
	}

	public int getAccessTimes() {
		return accessTimes;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public long getBlogId() {
		return blogId;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setLastModify(java.util.Date lastModify) {
		this.lastModify = lastModify;
	}

	public java.util.Date getLastModify() {
		return lastModify;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContentId(long contentId) {
		this.contentId = contentId;
	}

	public long getContentId() {
		return contentId;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getBrief() {
		return brief;
	}
}
