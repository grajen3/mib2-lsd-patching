/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.transformer;

import org.dsi.ifc.tmc.TmcMessage;

public class NavigationBapTMCinfoCollector {
    int infoLength = 0;
    int infoLengthUnit = 0;
    long infoMessageID = 0L;
    int infoPriority = 0;
    String infoLocation = "";
    String infoStreetName = "";
    String infoText = "";

    public NavigationBapTMCinfoCollector(TmcMessage tmcMessage) {
        if (tmcMessage != null) {
            this.infoLength = (int)tmcMessage.affectedRoadLength;
            this.infoLengthUnit = 0;
            this.infoMessageID = tmcMessage.messageID;
            this.infoPriority = 0;
            if (tmcMessage.startLocation != null && tmcMessage.startLocation.length() > 0) {
                this.infoLocation = tmcMessage.startLocation;
                if (tmcMessage.endLocation != null && tmcMessage.endLocation.length() > 0) {
                    this.infoLocation = new StringBuffer().append(this.infoLocation).append("\n").append(tmcMessage.endLocation).toString();
                }
            } else if (tmcMessage.endLocation != null && tmcMessage.endLocation.length() > 0) {
                this.infoLocation = tmcMessage.endLocation;
            }
            StringBuffer stringBuffer = new StringBuffer(60);
            if (tmcMessage.roadName != null && tmcMessage.roadName.length() > 0) {
                stringBuffer.append(tmcMessage.roadName);
            }
            if (tmcMessage.directionOfRoad1 != null && tmcMessage.directionOfRoad1.length() > 0) {
                stringBuffer.append(" ");
                stringBuffer.append(tmcMessage.directionOfRoad1);
            }
            if (tmcMessage.directionOfRoad2 != null && tmcMessage.directionOfRoad2.length() > 0) {
                stringBuffer.append(" ");
                stringBuffer.append(tmcMessage.directionOfRoad2);
            }
            this.infoStreetName = stringBuffer.toString();
            if (tmcMessage.eventText != null & tmcMessage.eventText.length > 0) {
                stringBuffer = new StringBuffer(50);
                String string = null;
                int n = tmcMessage.eventText.length;
                for (int i2 = 1; i2 < n; ++i2) {
                    if (string == null) {
                        string = tmcMessage.eventText[i2];
                        stringBuffer.append(string);
                        continue;
                    }
                    if (string.compareTo(tmcMessage.eventText[i2]) == 0) continue;
                    stringBuffer.append("\n");
                    string = tmcMessage.eventText[i2];
                    stringBuffer.append(string);
                }
                this.infoText = stringBuffer.toString();
            }
        }
    }
}

