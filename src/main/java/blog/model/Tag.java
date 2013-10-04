package blog.model;

import java.io.Serializable;

public class Tag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5250140389386453722L;
	private long id;
	private String tagName;
	private String memo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMemo() {
		return memo;
	}
}
