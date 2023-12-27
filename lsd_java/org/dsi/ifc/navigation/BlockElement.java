/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class BlockElement {
    public long uid;
    public int type;
    public int distanceToDestination;
    public boolean onRoute;
    public boolean persistent;
    public String description;

    public BlockElement() {
        this.uid = -1L;
        this.type = 0;
        this.distanceToDestination = -1;
        this.onRoute = false;
        this.persistent = false;
        this.description = "";
    }

    public BlockElement(long l, int n, int n2, boolean bl, boolean bl2, String string) {
        this.uid = l;
        this.type = n;
        this.distanceToDestination = n2;
        this.onRoute = bl;
        this.persistent = bl2;
        this.description = string;
    }

    public long getUid() {
        return this.uid;
    }

    public int getType() {
        return this.type;
    }

    public int getDistanceToDestination() {
        return this.distanceToDestination;
    }

    public boolean isOnRoute() {
        return this.onRoute;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("BlockElement");
        stringBuffer.append('(');
        stringBuffer.append("uid");
        stringBuffer.append('=');
        stringBuffer.append(this.uid);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("distanceToDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceToDestination);
        stringBuffer.append(',');
        stringBuffer.append("onRoute");
        stringBuffer.append('=');
        stringBuffer.append(this.onRoute);
        stringBuffer.append(',');
        stringBuffer.append("persistent");
        stringBuffer.append('=');
        stringBuffer.append(this.persistent);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

