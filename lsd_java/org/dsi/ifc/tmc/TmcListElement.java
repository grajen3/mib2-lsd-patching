/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

import org.dsi.ifc.tmc.TmcMessage;

public class TmcListElement {
    public long streetSignId;
    public TmcMessage message;
    public int type;
    public String description;
    public boolean hasChild;
    public long uID;
    public long parentID;
    public int numberOfMessagesInNode;
    public int positionInCompleteList;
    public String directionOfRoad1;
    public String directionOfRoad2;
    public boolean isBidirectional;
    public String roadName;
    public String roadNumber;
    public int[] iconIdList;

    public TmcListElement() {
        this.streetSignId = 0L;
        this.message = null;
        this.type = 0;
        this.description = null;
        this.hasChild = false;
        this.parentID = 0L;
        this.uID = 0L;
        this.numberOfMessagesInNode = 0;
        this.positionInCompleteList = 0;
        this.directionOfRoad1 = null;
        this.directionOfRoad2 = null;
        this.isBidirectional = false;
        this.roadName = null;
        this.roadNumber = null;
        this.iconIdList = null;
    }

    public TmcListElement(long l, TmcMessage tmcMessage, int n, String string, boolean bl, long l2, long l3, int n2, int n3, String string2, String string3, boolean bl2, String string4, String string5, int[] nArray) {
        this.streetSignId = l;
        this.message = tmcMessage;
        this.type = n;
        this.description = string;
        this.hasChild = bl;
        this.parentID = l3;
        this.uID = l2;
        this.numberOfMessagesInNode = n2;
        this.positionInCompleteList = n3;
        this.directionOfRoad1 = string2;
        this.directionOfRoad2 = string3;
        this.isBidirectional = bl2;
        this.roadName = string4;
        this.roadNumber = string5;
        this.iconIdList = nArray;
    }

    public long getStreetSignId() {
        return this.streetSignId;
    }

    public TmcMessage getMessage() {
        return this.message;
    }

    public void setMessage(TmcMessage tmcMessage) {
        this.message = tmcMessage;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public boolean isHasChild() {
        return this.hasChild;
    }

    public void setHasChild(boolean bl) {
        this.hasChild = bl;
    }

    public long getUID() {
        return this.uID;
    }

    public void setUID(long l) {
        this.uID = l;
    }

    public int getNumberOfMessagesInNode() {
        return this.numberOfMessagesInNode;
    }

    public void setNumberOfMessagesInNode(int n) {
        this.numberOfMessagesInNode = n;
    }

    public long getParentID() {
        return this.parentID;
    }

    public int getPositionInCompleteList() {
        return this.positionInCompleteList;
    }

    public void setParentID(long l) {
        this.parentID = l;
    }

    public String getDirectionOfRoad1() {
        return this.directionOfRoad1;
    }

    public String getDirectionOfRoad2() {
        return this.directionOfRoad2;
    }

    public boolean isIsBidirectional() {
        return this.isBidirectional;
    }

    public String getRoadName() {
        return this.roadName;
    }

    public void setRoadName(String string) {
        this.roadName = string;
    }

    public String getRoadNumber() {
        return this.roadNumber;
    }

    public void setRoadNumber(String string) {
        this.roadNumber = string;
    }

    public int[] getIconIdList() {
        return this.iconIdList;
    }

    public void setIconIdList(int[] nArray) {
        this.iconIdList = nArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2000);
        stringBuffer.append("TmcListElement");
        stringBuffer.append('(');
        stringBuffer.append("streetSignId");
        stringBuffer.append('=');
        stringBuffer.append(this.streetSignId);
        stringBuffer.append(',');
        stringBuffer.append("message");
        stringBuffer.append('=');
        stringBuffer.append(this.message);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("hasChild");
        stringBuffer.append('=');
        stringBuffer.append(this.hasChild);
        stringBuffer.append(',');
        stringBuffer.append("uID");
        stringBuffer.append('=');
        stringBuffer.append(this.uID);
        stringBuffer.append(',');
        stringBuffer.append("parentID");
        stringBuffer.append('=');
        stringBuffer.append(this.parentID);
        stringBuffer.append(',');
        stringBuffer.append("numberOfMessagesInNode");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfMessagesInNode);
        stringBuffer.append(',');
        stringBuffer.append("positionInCompleteList");
        stringBuffer.append('=');
        stringBuffer.append(this.positionInCompleteList);
        stringBuffer.append(',');
        stringBuffer.append("directionOfRoad1");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.directionOfRoad1);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("directionOfRoad2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.directionOfRoad2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("isBidirectional");
        stringBuffer.append('=');
        stringBuffer.append(this.isBidirectional);
        stringBuffer.append(',');
        stringBuffer.append("roadName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("roadNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("iconIdList");
        stringBuffer.append('[');
        if (this.iconIdList != null) {
            stringBuffer.append(this.iconIdList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.iconIdList != null) {
            int n = this.iconIdList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.iconIdList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.iconIdList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

