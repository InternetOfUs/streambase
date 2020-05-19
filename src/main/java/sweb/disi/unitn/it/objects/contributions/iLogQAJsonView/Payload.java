package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payload {

    /** Payload's Location */
    private DataObjView data;

    /** Metadata of Payload (picture) */
    private MetaDataObjView metadata;

    /** Picture */
    String picture;

    public Payload(){

    }

    public DataObjView getData() {
        return data;
    }

    public MetaDataObjView getMetadata() {
        return metadata;
    }

    public String getPicture() {
        return picture;
    }

    public void setData(DataObjView data) {
        this.data = data;
    }

    public void setMetadata(MetaDataObjView metadata) {
        this.metadata = metadata;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
