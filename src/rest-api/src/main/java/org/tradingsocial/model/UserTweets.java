package org.tradingsocial.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_tweets")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserTweets implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "tweet_type")
	private String tweetType;
	@Column(name = "stock_name")
	private String stockName;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "tweet")
	private Byte[] tweet;
	@Column(name = "tweet_time")
	private Timestamp tweetTime;
	@Column(name = "user_id")
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTweetType() {
		return tweetType;
	}

	public void setTweetType(String tweetType) {
		this.tweetType = tweetType;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Byte[] getTweet() {
		return tweet;
	}

	public void setTweet(Byte[] tweet) {
		this.tweet = tweet;
	}

	public Timestamp getTweetTime() {
		return tweetTime;
	}

	public void setTweetTime(Timestamp tweetTime) {
		this.tweetTime = tweetTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result	+ ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result + Arrays.hashCode(tweet);
		result = prime * result	+ ((tweetTime == null) ? 0 : tweetTime.hashCode());
		result = prime * result	+ ((tweetType == null) ? 0 : tweetType.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result	+ ((userName == null) ? 0 : userName.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTweets other = (UserTweets) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		if (!Arrays.equals(tweet, other.tweet))
			return false;
		if (tweetTime == null) {
			if (other.tweetTime != null)
				return false;
		} else if (!tweetTime.equals(other.tweetTime))
			return false;
		if (tweetType == null) {
			if (other.tweetType != null)
				return false;
		} else if (!tweetType.equals(other.tweetType))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
