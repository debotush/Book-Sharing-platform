package com.diprobet.bookSharing.util;

import com.diprobet.bookSharing.dto.Review;
import com.diprobet.bookSharing.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {
    public Review mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        Review review = new Review(user);
        review.getUser().setFullName(resultSet.getString("fullName"));
        review.setReview(resultSet.getString("review"));
        review.setRating(resultSet.getInt("rating"));
        return review;
    }

}
