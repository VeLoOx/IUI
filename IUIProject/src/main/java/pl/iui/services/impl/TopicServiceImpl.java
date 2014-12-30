package pl.iui.services.impl;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import pl.iui.dao.topic.TopicDao;
import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.AdressEntity;
import pl.iui.domain.user.CommentsEntity;
import pl.iui.domain.user.UserEntity;
import pl.iui.services.TopicService;
import pl.iui.services.UserService;

public class TopicServiceImpl extends FacesMessagesProvider implements
		TopicService {

	private TopicDao topicDao;
	private TopicEntity selectedTopic;
	
	private UserService userService;
	
	private String selectedRate;

	private MapModel mapModel;

	private Marker marker;

	private String title;

	private double lat;

	private double lng;

	// ------------Map methods-------------------------------------

	public void createMarker() {
		mapModel = new DefaultMapModel();

		// Shared coordinates
		//LatLng coord1 = new LatLng(36.879466, 30.667648);
//		LatLng coord2 = new LatLng(36.883707, 30.689216);
		// LatLng coord3 = new LatLng(36.879703, 30.706707);
		// LatLng coord4 = new LatLng(36.885233, 30.702323);

		// Basic marker
		//mapModel.addOverlay(new Marker(coord1, "Konyaalti"));
//		mapModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
		// mapModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
		// mapModel.addOverlay(new Marker(coord4, "Kaleici"));
		if(selectedTopic!=null){
			marker = new Marker(new LatLng(selectedTopic.getLat(), selectedTopic.getLng()), selectedTopic.getTitle());
			//marker.setDraggable(true);
			mapModel.addOverlay(marker);
		}
		
	}

	/**
	 * Method to make all markers dragable
	 */
	private void updateMarkers() {
		for (Marker premarker : mapModel.getMarkers()) {
			premarker.setDraggable(true);
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public void addMarker() {
		//Marker marker = new Marker(new LatLng(lat, lng), title);
		marker = new Marker(new LatLng(lat, lng), title);
		marker.setDraggable(true);
		mapModel.addOverlay(marker);
		// updateMarkers();
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added",
						"Lat:" + lat + ", Lng:" + lng));
		

	}

	public void onMarkerDrag(MarkerDragEvent event) {
		marker = event.getMarker();

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Dragged",
						"Lat:" + marker.getLatlng().getLat() + ", Lng:"
								+ marker.getLatlng().getLng()));
	}

	public MapModel getMapModel() {
		return mapModel;
	}

	public void setMapModel(MapModel mapModel) {
		this.mapModel = mapModel;
	}

	// ---------------------------------------------------------------------
	@Override
	public boolean addTopic(TopicEntity topic, UserEntity user,
			AdressEntity adress) {
		topic.setTitle(marker.getTitle());
		LatLng latLng=marker.getLatlng();
		topic.setLat(latLng.getLat());
		topic.setLng(latLng.getLng());
		topic.setAutor(user.getUserName());
		topic.setAdress(adress);
		Date dateobj = new Date();
		topic.setData(dateobj);
		topicDao.save(topic);

		//DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		
		
		return true;
	}

	@Override
	public List<TopicEntity> getAllTopic() {
		// TODO Auto-generated method stub
		return topicDao.findAll();
	}

	public List<TopicEntity> getAllTopicForUser(String name) {
		// TODO Auto-generated method stub
		return topicDao.findUserTopic(name);
	}

	public TopicDao getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public TopicEntity getSelectedTopic() {
		return selectedTopic;
	}

	public void setSelectedTopic(TopicEntity selectedTopic) {
		this.selectedTopic = selectedTopic;
	}

	public void addComment(TopicEntity topic, CommentsEntity comm,
			UserEntity user) {
		comm.setAutor(user.getUserName());
		topic.getComments().add(comm);
		topicDao.update(topic);
	}

	@Override
	public List<CommentsEntity> getAllCommentsForTopic(long id) {

		return topicDao.findById(id).getComments();
	}

	@Override
	public double getRate(TopicEntity top) {
		// TODO Auto-generated method stub
		
		double val = top.getRate()/top.getNumberRate();
		
		return Math.round(val*100.0)/100.0;
	}

	public String getSelectedRate() {
		return selectedRate;
	}

	public void setSelectedRate(String selectedRate) {
		this.selectedRate = selectedRate;
	}

	@Override
	public void addRate(TopicEntity top, String rateS, UserEntity ue) {
		// TODO Auto-generated method stub
		
		double rate = Double.parseDouble(rateS);
		
		top.setRate(top.getRate()+rate);
		top.setNumberRate(top.getNumberRate()+1);
		
		topicDao.update(top);
		
		userService.addRatedTopic(top.getId(), ue);
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public TopicEntity getNewTopic() {
		// TODO Auto-generated method stub
		return new TopicEntity();
	}
	
	public AdressEntity getNewAdress(){
		return new AdressEntity();
		
	}
	
	public String translateDate(TopicEntity t){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = t.getData();
		if(d==null) return ""; else
		return sdf.format(d);
	}

	@Override
	public String translateCommentDate(CommentsEntity c) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy:HH:mm");
		Date d = c.getData();
		if(d==null) return ""; else
		return sdf.format(d);
		
	}

}
