package com.diprobet.bookSharing.util;

import com.diprobet.bookSharing.entity.Transaction;
import com.diprobet.bookSharing.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TransactionRowMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        Transaction transaction = new Transaction();
        User requestedBy = new User();
        User owner = new User();

        owner.setUserId(resultSet.getInt("ownerId"));
        owner.setFullName(resultSet.getString("ownerFullName"));
        owner.setUserName(resultSet.getString("ownerUserName"));

        requestedBy.setUserId(resultSet.getInt("requestedById"));
        requestedBy.setFullName(resultSet.getString("requestedByFullName"));
        requestedBy.setUserName(resultSet.getString("requestedByUserName"));

        transaction.setTransactionId(resultSet.getInt("transactionId"));
        transaction.setBookId(resultSet.getInt("bookId"));
        transaction.setStatus(resultSet.getString("status"));

        transaction.setOwner(owner);
        transaction.setRequestedBy(requestedBy);


        return transaction;
    }
}
