package sweb.disi.unitn.it.objects.batchData;


import sweb.disi.unitn.it.objects.subscription.Entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class JsonStructure {

	@NotNull
	public String userId;

	@NotNull
	public String experimentId;

	public JsonStructure(){

	}

	@NotNull
	public Entity entity;
	@NotEmpty
	public List<Property> properties = new ArrayList<Property>();

	@Override
	public String toString(){
		String toReturn = "userId: " + this.userId + " experimentId: " + this.experimentId + " Properties: ";

		for (Property p : properties){
			toReturn = toReturn + p.toString();
		}
		return toReturn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getExperimentId() {
		return experimentId;
	}

	public void setExperimentId(String experimentId) {
		this.experimentId = experimentId;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return entity;
	}

}
