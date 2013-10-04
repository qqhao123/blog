package blog.model;

import java.io.Serializable;

public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5805903527122636967L;
	private long CateId;
	private long pCateId;
	private String cateName;
	private String describle;

	public long getCateId() {
		return CateId;
	}

	public void setCateId(long CateId) {
		this.CateId = CateId;
	}

	public long getpCateId() {
		return pCateId;
	}

	public void setpCateId(long pCateId) {
		this.pCateId = pCateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescrible() {
		return describle;
	}

	public void setDescrible(String describle) {
		this.describle = describle;
	}

}
