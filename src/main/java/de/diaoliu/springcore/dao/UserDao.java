package de.diaoliu.springcore.dao;

import de.diaoliu.springcore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

@Repository
public class UserDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private UserMappingQuery userMappingQuery;

    private static final String CREATE_USER =
            "INSERT INTO user(id,email,createdAt) values(:id,:email,:createdAt)";
    private static final String GET_USER_BY_EMAIL =
            "SELECT id,email,createdAt FROM user WHERE email= ?";

    @Autowired
    private DataSource dataSource;

    public void setDataSource() {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.userMappingQuery = new UserMappingQuery(dataSource);
    }

    public User getUserByEmail(String email) {
        List<User> users = userMappingQuery.execute(email);
        return users.size() > 0 ? users.get(0) : null;
    }

    public void save(User user) {
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("email", user.getEmail())
                .addValue("createdAt", new Date());
        this.namedParameterJdbcTemplate.update(CREATE_USER, sqlParameterSource);
    }

    private class UserMappingQuery extends MappingSqlQuery<User> {

        public UserMappingQuery(DataSource ds) {
            super(ds, GET_USER_BY_EMAIL);
            super.declareParameter(new SqlParameter("email", Types.VARCHAR));
            compile();
        }

        protected User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setEmail(resultSet.getString("email"));
            user.setCreatedAt(resultSet.getDate("createdAt"));
            return user;
        }
    }

}
