package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import blog.model.Blog;
import blog.model.Tag;

public class BlogDaoWithDS implements BlogDao {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Blog> getIndexBolgs(int pageRow) {
		return null;
	}

	@Override
	public void insertBlog(Blog blog) throws Exception {
		Connection connection = DataSourceUtils.getConnection(dataSource);
		String sql = "insert into blog (title," + "create_date, last_modify)"
				+ " values(?,now(),now())";
		PreparedStatement a = connection.prepareStatement(sql);
		a.setString(1, blog.getTitle());
		a.execute();
		String getBlogId = "select LAST_INSERT_ID() as id";
		ResultSet rsid = a.executeQuery(getBlogId);
		if (rsid.first())
			blog.setBlogId(rsid.getLong(1));
	}

	@Override
	public void addTag(long blogId, Tag tag) throws Exception {
		Connection connection = DataSourceUtils.getConnection(dataSource);
		String findTagId = "select tag_id from tag t where t.tag_name = '"
				+ tag.getTagName() + "'";
		String insertTagString = "insert into tag(tag_name) values(?)";
		Statement sf = connection.createStatement();

		ResultSet idSet = sf.executeQuery(findTagId);
		long tagId = 0;
		if (idSet.first()) {
			tagId = idSet.getLong("tag_id");
			tag.setId(tagId);
		}
		if (tagId == 0) {
			PreparedStatement insertStatement = connection.prepareStatement(
					insertTagString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, tag.getTagName());
			ResultSet rsId = insertStatement.getGeneratedKeys();
			if (rsId.first()) {
				tag.setId(rsId.getLong(1));
			}
			insertStatement.execute();
			String getTagId = "select LAST_INSERT_ID() as id";
			ResultSet id = sf.executeQuery(getTagId);
			if (id.first()) {
				tagId = id.getLong("id");
				tag.setId(tagId);
			}
		}
		String insertRela = "insert into blog_tag (blog_id,tag_id) values("
				+ +blogId + "," + tag.getId() + ")";
		Statement addTag = connection.createStatement();
		addTag.execute(insertRela);
		throw new RuntimeException("why");
	}

	@Override
	public Blog getBlog(Blog blog) {
		// TODO Auto-generated method stub
		return null;
	}
}
