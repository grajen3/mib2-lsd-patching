/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

import org.dsi.ifc.global.ResourceLocator;

public class ResourceInformation {
    public ResourceLocator resourceLocator;
    public String phoneticString;

    public ResourceInformation() {
        this.resourceLocator = null;
        this.phoneticString = null;
    }

    public ResourceInformation(ResourceLocator resourceLocator, String string) {
        this.resourceLocator = resourceLocator;
        this.phoneticString = string;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public String getPhoneticString() {
        return this.phoneticString;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("ResourceInformation");
        stringBuffer.append('(');
        stringBuffer.append("resourceLocator");
        stringBuffer.append('=');
        stringBuffer.append(this.resourceLocator);
        stringBuffer.append(',');
        stringBuffer.append("phoneticString");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.phoneticString);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

