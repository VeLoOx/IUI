package pl.iui.ui.utils;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
  


import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 

@Component
@Scope("session")
public class MarkersUtils implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 6462632952699898937L;

	private MapModel mapModel;
	
	private Marker marker;
      
    private String title;
      
    private double lat;
      
    private double lng;
  
    @PostConstruct
    public void init() {
    	mapModel = new DefaultMapModel();
        
        //Shared coordinates
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
        LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Basic marker
        mapModel.addOverlay(new Marker(coord1, "Konyaalti"));
//        mapModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
//        mapModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
//        mapModel.addOverlay(new Marker(coord4, "Kaleici"));
        
        //updateMarkers();
    }
      
    public MapModel getMapModel() {
        return mapModel;
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
    
    private void updateMarkers(){
    	for(Marker premarker : mapModel.getMarkers()) {
            premarker.setDraggable(true);
        }
    }
      
    public void addMarker() {
        Marker marker = new Marker(new LatLng(lat, lng), title);
        marker.setDraggable(true);
        mapModel.addOverlay(marker);
        //updateMarkers();  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
        
    }
    
    public void onMarkerDrag(MarkerDragEvent event) {
        marker = event.getMarker();
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Dragged", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));
    }
}
