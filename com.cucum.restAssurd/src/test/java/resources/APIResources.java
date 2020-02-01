package resources;

public enum APIResources {

	AddPlaceAPI("/maps/api/place/add/json"), 
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");

	private String  resources;

	APIResources(String resource) {
		this.resources = resource;
	}
  public String getResource() {
	  
	  return  resources;
  }
}
