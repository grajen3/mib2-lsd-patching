/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.traffic;

import org.dsi.ifc.tmc.TmcMessage;

public class TrafficMessageDetails {
    public long messageID;
    public String roadNumber;
    public String urgent;

    public TrafficMessageDetails(TmcMessage tmcMessage) {
        this.messageID = tmcMessage.messageID;
        this.roadNumber = tmcMessage.roadNumber;
        this.urgent = tmcMessage.urgent;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("TrafficMessageDetails");
        stringBuffer.append('(');
        stringBuffer.append("messageID");
        stringBuffer.append('=');
        stringBuffer.append(this.messageID);
        stringBuffer.append(',');
        stringBuffer.append("roadNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("urgent");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.urgent);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

