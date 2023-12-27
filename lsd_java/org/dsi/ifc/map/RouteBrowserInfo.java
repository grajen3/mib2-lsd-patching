/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

public class RouteBrowserInfo {
    public long lengthOfSelectedSegments;
    public String name;

    public RouteBrowserInfo() {
        this.lengthOfSelectedSegments = 0L;
        this.name = null;
    }

    public RouteBrowserInfo(long l, String string) {
        this.lengthOfSelectedSegments = l;
        this.name = string;
    }

    public long getLengthOfSelectedSegments() {
        return this.lengthOfSelectedSegments;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("RouteBrowserInfo");
        stringBuffer.append('(');
        stringBuffer.append("lengthOfSelectedSegments");
        stringBuffer.append('=');
        stringBuffer.append(this.lengthOfSelectedSegments);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

