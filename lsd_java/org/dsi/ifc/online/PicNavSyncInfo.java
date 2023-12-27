/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class PicNavSyncInfo {
    public int addItemCount;
    public int deleteItemCount;
    public int renameItemCount;
    public int moveItemCount;

    public PicNavSyncInfo() {
    }

    public PicNavSyncInfo(int n, int n2, int n3, int n4) {
        this.addItemCount = n;
        this.deleteItemCount = n2;
        this.renameItemCount = n3;
        this.moveItemCount = n4;
    }

    public int getAddItemCount() {
        return this.addItemCount;
    }

    public int getDeleteItemCount() {
        return this.deleteItemCount;
    }

    public int getRenameItemCount() {
        return this.renameItemCount;
    }

    public int getMoveItemCount() {
        return this.moveItemCount;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("PicNavSyncInfo");
        stringBuffer.append('(');
        stringBuffer.append("addItemCount");
        stringBuffer.append('=');
        stringBuffer.append(this.addItemCount);
        stringBuffer.append(',');
        stringBuffer.append("deleteItemCount");
        stringBuffer.append('=');
        stringBuffer.append(this.deleteItemCount);
        stringBuffer.append(',');
        stringBuffer.append("renameItemCount");
        stringBuffer.append('=');
        stringBuffer.append(this.renameItemCount);
        stringBuffer.append(',');
        stringBuffer.append("moveItemCount");
        stringBuffer.append('=');
        stringBuffer.append(this.moveItemCount);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

