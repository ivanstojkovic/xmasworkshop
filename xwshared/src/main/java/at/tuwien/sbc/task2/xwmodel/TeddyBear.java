package at.tuwien.sbc.task2.xwmodel;

public class TeddyBear {
    
    private String id;
    
    private String headId;
    
    private String bodyId;
    
    private String leftHandId;
    
    private String rightHandId;
    
    private String leftLegId;
    
    private String rightLegId;
    
    private String hatId;
    
    private boolean defective;
    
    private boolean ready;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getHeadId() {
        return headId;
    }
    
    public void setHeadId(String headId) {
        this.headId = headId;
    }
    
    public String getBodyId() {
        return bodyId;
    }
    
    public void setBodyId(String bodyId) {
        this.bodyId = bodyId;
    }
    
    public String getLeftHandId() {
        return leftHandId;
    }
    
    public void setLeftHandId(String leftHandId) {
        this.leftHandId = leftHandId;
    }
    
    public String getRightHandId() {
        return rightHandId;
    }
    
    public void setRightHandId(String rightHandId) {
        this.rightHandId = rightHandId;
    }
    
    public String getLeftLegId() {
        return leftLegId;
    }
    
    public void setLeftLegId(String leftLegId) {
        this.leftLegId = leftLegId;
    }
    
    public String getRightLegId() {
        return rightLegId;
    }
    
    public void setRightLegId(String rightLegId) {
        this.rightLegId = rightLegId;
    }
    
    public String getHatId() {
        return hatId;
    }
    
    public void setHatId(String hatId) {
        this.hatId = hatId;
    }
    
    public String toString() {
        return "TeddyBear [id= " + this.id + "][hatId= " + this.hatId + "][headId= " + this.headId + "][bodyId="
            + this.bodyId + "][leftHandId= " + this.leftHandId + "][rightHandId= " + this.rightHandId + "][leftLegId="
            + this.leftLegId + "][rightLegId= " + this.rightLegId + "]";
    }

    public void setDefective(boolean defective) {
        this.defective = defective;
    }

    public boolean isDefective() {
        return defective;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isReady() {
        return ready;
    }
    
}
