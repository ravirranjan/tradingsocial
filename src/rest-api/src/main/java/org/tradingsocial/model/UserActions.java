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
@Table(name = "user_actions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserActions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "action_type")
	private String actionType;
	@Column(name = "target_user_id")
	private Integer targetUserId;
	@Column(name = "source_user_id")
	private Integer sourceUserId;
	@Column(name = "action_content")
	private Byte[] actionContent;
	@Column(name = "action_time")
	private Timestamp actionTime;
	@Column(name = "target_stock_id")
	private Integer targetStockId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public Integer getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(Integer targetUserId) {
		this.targetUserId = targetUserId;
	}

	public Integer getSourceUserId() {
		return sourceUserId;
	}

	public void setSourceUserId(Integer sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	public Byte[] getActionContent() {
		return actionContent;
	}

	public void setActionContent(Byte[] actionContent) {
		this.actionContent = actionContent;
	}

	public Timestamp getActionTime() {
		return actionTime;
	}

	public void setActionTime(Timestamp actionTime) {
		this.actionTime = actionTime;
	}

	public Integer getTargetStockId() {
		return targetStockId;
	}

	public void setTargetStockId(Integer targetStockId) {
		this.targetStockId = targetStockId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(actionContent);
		result = prime * result	+ ((actionTime == null) ? 0 : actionTime.hashCode());
		result = prime * result	+ ((actionType == null) ? 0 : actionType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result	+ ((sourceUserId == null) ? 0 : sourceUserId.hashCode());
		result = prime * result	+ ((targetStockId == null) ? 0 : targetStockId.hashCode());
		result = prime * result	+ ((targetUserId == null) ? 0 : targetUserId.hashCode());
		
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
		UserActions other = (UserActions) obj;
		if (!Arrays.equals(actionContent, other.actionContent))
			return false;
		if (actionTime == null) {
			if (other.actionTime != null)
				return false;
		} else if (!actionTime.equals(other.actionTime))
			return false;
		if (actionType == null) {
			if (other.actionType != null)
				return false;
		} else if (!actionType.equals(other.actionType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sourceUserId == null) {
			if (other.sourceUserId != null)
				return false;
		} else if (!sourceUserId.equals(other.sourceUserId))
			return false;
		if (targetStockId == null) {
			if (other.targetStockId != null)
				return false;
		} else if (!targetStockId.equals(other.targetStockId))
			return false;
		if (targetUserId == null) {
			if (other.targetUserId != null)
				return false;
		} else if (!targetUserId.equals(other.targetUserId))
			return false;
		return true;
	}

}
