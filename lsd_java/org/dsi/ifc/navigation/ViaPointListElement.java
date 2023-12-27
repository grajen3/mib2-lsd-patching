/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class ViaPointListElement {
    public int id;
    public String description;
    public long roadIconId;
    public String roadNumber;
    public boolean hasChildren;
    public long parentID;
    public int numberOfViaPointsInNode;

    public ViaPointListElement() {
        this.id = -1;
        this.description = "";
        this.roadIconId = -1L;
        this.roadNumber = "";
        this.hasChildren = false;
        this.parentID = -1L;
        this.numberOfViaPointsInNode = 0;
    }

    public ViaPointListElement(int n, String string, long l, String string2, boolean bl, long l2, int n2) {
        this.id = n;
        this.description = string;
        this.roadIconId = l;
        this.roadNumber = string2;
        this.hasChildren = bl;
        this.parentID = l2;
        this.numberOfViaPointsInNode = n2;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public long getRoadIconId() {
        return this.roadIconId;
    }

    public String getRoadNumber() {
        return this.roadNumber;
    }

    public boolean isHasChildren() {
        return this.hasChildren;
    }

    public long getParentID() {
        return this.parentID;
    }

    public int getNumberOfViaPointsInNode() {
        return this.numberOfViaPointsInNode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("ViaPointListElement");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("roadIconId");
        stringBuffer.append('=');
        stringBuffer.append(this.roadIconId);
        stringBuffer.append(',');
        stringBuffer.append("roadNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("hasChildren");
        stringBuffer.append('=');
        stringBuffer.append(this.hasChildren);
        stringBuffer.append(',');
        stringBuffer.append("parentID");
        stringBuffer.append('=');
        stringBuffer.append(this.parentID);
        stringBuffer.append(',');
        stringBuffer.append("numberOfViaPointsInNode");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfViaPointsInNode);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

