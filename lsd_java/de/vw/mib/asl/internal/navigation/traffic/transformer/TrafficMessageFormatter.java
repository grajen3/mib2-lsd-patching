/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic.transformer;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import de.vw.mib.util.Util;
import org.dsi.ifc.tmc.TmcMessage;

public class TrafficMessageFormatter {
    private static void put(FixFormatterFieldDataImpl fixFormatterFieldDataImpl, String string, String string2) {
        if (string2 != null && string2.length() > 0) {
            fixFormatterFieldDataImpl.put(string, string2);
        }
    }

    public static FixFormatterFieldData prepareFixFormatterDetailViewData(TmcMessage tmcMessage) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = new FixFormatterFieldDataImpl();
        if (tmcMessage == null) {
            return fixFormatterFieldDataImpl;
        }
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "DirOfRd1", tmcMessage.getDirectionOfRoad1());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "DirOfRd2", tmcMessage.getDirectionOfRoad2());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "StartLoc", tmcMessage.getStartLocation());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "EndLoc", tmcMessage.getEndLocation());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "RdName", tmcMessage.getRoadName());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "RdNumber", tmcMessage.getRoadNumber());
        StringBuffer stringBuffer = TrafficMessageFormatter.constructEventText(tmcMessage);
        if (stringBuffer.length() > 0) {
            TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "EventText", stringBuffer.toString());
        }
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "EventText", stringBuffer.toString());
        fixFormatterFieldDataImpl.put("isArea", tmcMessage.isIsArea());
        fixFormatterFieldDataImpl.put("isBidirectional", tmcMessage.isIsBidirectional());
        boolean bl = tmcMessage.startTime != 0L;
        boolean bl2 = tmcMessage.endTime != 0L;
        ASLSystemAPI aSLSystemAPI = ASLSystemFactory.getSystemApi();
        int n = aSLSystemAPI.getConfiguredDateFormat();
        if (n >= 0 && n <= 2) {
            fixFormatterFieldDataImpl.put("paramDateFormat", n);
        } else {
            fixFormatterFieldDataImpl.put("paramDateFormat", 0);
        }
        fixFormatterFieldDataImpl.put("paramTimeFormat", aSLSystemAPI.getConfiguredTimeFormat());
        fixFormatterFieldDataImpl.put("isStartTimeSupplied", bl);
        fixFormatterFieldDataImpl.put("isEndTimeSupplied", bl2);
        fixFormatterFieldDataImpl.put("StartTime", tmcMessage.startTime * 0);
        fixFormatterFieldDataImpl.put("EndTime", tmcMessage.endTime * 0);
        return fixFormatterFieldDataImpl;
    }

    public static FixFormatterFieldData prepareFixFormatterListData(TmcMessage tmcMessage) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = new FixFormatterFieldDataImpl();
        if (tmcMessage == null) {
            return fixFormatterFieldDataImpl;
        }
        fixFormatterFieldDataImpl.put("isArea", tmcMessage.isIsArea());
        fixFormatterFieldDataImpl.put("isRoadIcon", !Util.isNullOrEmpty(tmcMessage.getRoadNumber()));
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "DirOfRd1", tmcMessage.getDirectionOfRoad1());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "DirOfRd2", tmcMessage.getDirectionOfRoad2());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "StartLoc", tmcMessage.getStartLocation());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "EndLoc", tmcMessage.getEndLocation());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "RdName", tmcMessage.getRoadName());
        if (tmcMessage.getEventText() != null && tmcMessage.getEventText().length > 0) {
            TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "EventText", tmcMessage.getEventText()[0]);
        } else {
            TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "EventText", "");
        }
        return fixFormatterFieldDataImpl;
    }

    public static StringBuffer constructEventText(TmcMessage tmcMessage) {
        StringBuffer stringBuffer = new StringBuffer();
        if (tmcMessage.eventText.length > 0) {
            for (int i2 = 1; i2 < tmcMessage.eventText.length; ++i2) {
                if (tmcMessage.getEventText()[i2] == null) continue;
                stringBuffer.append(tmcMessage.getEventText()[i2]);
                if (i2 + 1 >= tmcMessage.getEventText().length) continue;
                stringBuffer.append(", ");
            }
        }
        return stringBuffer;
    }

    public static String getTimeFormatString() {
        ASLSystemAPI aSLSystemAPI = ASLSystemFactory.getSystemApi();
        String string = aSLSystemAPI.getConfiguredTimeFormat() == 0 ? "h:mm a" : "H:mm";
        return string;
    }
}

