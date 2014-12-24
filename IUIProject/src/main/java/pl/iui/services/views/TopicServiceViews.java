package pl.iui.services.views;

import java.io.Serializable;
import java.util.List;

import pl.iui.domain.topic.TopicEntity;

public class TopicServiceViews implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<TopicEntity> topics;

	public List<TopicEntity> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicEntity> topics) {
		this.topics = topics;
	}
	
	

}
