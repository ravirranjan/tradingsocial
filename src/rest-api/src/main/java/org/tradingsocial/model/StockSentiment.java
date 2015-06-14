package org.tradingsocial.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "stock_sentiment")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StockSentiment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "sentiment")
	private String sentiment;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "tweet_id")
	private Integer tweetId;
	@Column(name = "stock_name")
	private String stockName;
	@Column(name = "sentiment_time")
	private Timestamp sentimentTime;
	@Column(name = "stock_id")
	private Integer stockId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTweetId() {
		return tweetId;
	}

	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Timestamp getSentimentTime() {
		return sentimentTime;
	}

	public void setSentimentTime(Timestamp sentimentTime) {
		this.sentimentTime = sentimentTime;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result	+ ((sentiment == null) ? 0 : sentiment.hashCode());
		result = prime * result	+ ((sentimentTime == null) ? 0 : sentimentTime.hashCode());
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		result = prime * result	+ ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result + ((tweetId == null) ? 0 : tweetId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		
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
		StockSentiment other = (StockSentiment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sentiment == null) {
			if (other.sentiment != null)
				return false;
		} else if (!sentiment.equals(other.sentiment))
			return false;
		if (sentimentTime == null) {
			if (other.sentimentTime != null)
				return false;
		} else if (!sentimentTime.equals(other.sentimentTime))
			return false;
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		if (tweetId == null) {
			if (other.tweetId != null)
				return false;
		} else if (!tweetId.equals(other.tweetId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
