/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.global.NavLocation;

public class NavLastDest {
    public String title;
    public NavLocation location;
    public String codedTitle;

    public NavLastDest() {
        this.title = null;
        this.location = null;
        this.codedTitle = null;
    }

    public NavLastDest(String string, NavLocation navLocation, String string2) {
        this.title = string;
        this.location = navLocation;
        this.codedTitle = string2;
    }

    public String getTitle() {
        return this.title;
    }

    public NavLocation getLocation() {
        return this.location;
    }

    public String getCodedTitle() {
        return this.codedTitle;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("NavLastDest");
        stringBuffer.append('(');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("location");
        stringBuffer.append('=');
        stringBuffer.append(this.location);
        stringBuffer.append(',');
        stringBuffer.append("codedTitle");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.codedTitle);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

