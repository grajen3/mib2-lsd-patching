/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

public class AudioRoute {
    public int routingInput;
    public int routingOutput;
    public int routeStatus;

    public AudioRoute() {
        this.routingInput = 0;
        this.routingOutput = 0;
        this.routeStatus = 0;
    }

    public AudioRoute(int n, int n2, int n3) {
        this.routingInput = n;
        this.routingOutput = n2;
        this.routeStatus = n3;
    }

    public int getRoutingInput() {
        return this.routingInput;
    }

    public int getRoutingOutput() {
        return this.routingOutput;
    }

    public int getRouteStatus() {
        return this.routeStatus;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("AudioRoute");
        stringBuffer.append('(');
        stringBuffer.append("routingInput");
        stringBuffer.append('=');
        stringBuffer.append(this.routingInput);
        stringBuffer.append(',');
        stringBuffer.append("routingOutput");
        stringBuffer.append('=');
        stringBuffer.append(this.routingOutput);
        stringBuffer.append(',');
        stringBuffer.append("routeStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.routeStatus);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

