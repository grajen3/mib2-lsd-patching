/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class DCDisplayDependency {
    public boolean drivingProfile;

    public DCDisplayDependency() {
        this.drivingProfile = false;
    }

    public DCDisplayDependency(boolean bl) {
        this.drivingProfile = bl;
    }

    public boolean isDrivingProfile() {
        return this.drivingProfile;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append("DCDisplayDependency");
        stringBuffer.append('(');
        stringBuffer.append("drivingProfile");
        stringBuffer.append('=');
        stringBuffer.append(this.drivingProfile);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

