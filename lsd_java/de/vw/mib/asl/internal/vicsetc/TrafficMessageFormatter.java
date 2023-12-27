/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.navigation.traffic.ITmcMessage;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;

public final class TrafficMessageFormatter {
    private TrafficMessageFormatter() {
    }

    public static FixFormatterFieldData prepareFixFormatterDetailViewData(ITmcMessage iTmcMessage) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = new FixFormatterFieldDataImpl();
        if (iTmcMessage == null) {
            return fixFormatterFieldDataImpl;
        }
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "DirOfRd1", iTmcMessage.getDirectionOfRoad1());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "DirOfRd2", iTmcMessage.getDirectionOfRoad2());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "StartLoc", iTmcMessage.getStartLocation());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "EndLoc", iTmcMessage.getEndLocation());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "RdName", iTmcMessage.getRoadName());
        TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "RdNumber", iTmcMessage.getRoadNumber());
        StringBuffer stringBuffer = TrafficMessageFormatter.constructEventText(iTmcMessage);
        if (stringBuffer.length() > 0) {
            TrafficMessageFormatter.put(fixFormatterFieldDataImpl, "EventText", stringBuffer.toString());
        }
        fixFormatterFieldDataImpl.put("isArea", iTmcMessage.isArea());
        fixFormatterFieldDataImpl.put("isBidirectional", iTmcMessage.isBidirectional());
        boolean bl = iTmcMessage.getStartTime() != 0L;
        boolean bl2 = iTmcMessage.getEndTime() != 0L;
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
        fixFormatterFieldDataImpl.put("StartTime", iTmcMessage.getStartTime() * 0);
        fixFormatterFieldDataImpl.put("EndTime", iTmcMessage.getEndTime() * 0);
        return fixFormatterFieldDataImpl;
    }

    private static void put(FixFormatterFieldDataImpl fixFormatterFieldDataImpl, String string, String string2) {
        if (string2 != null && string2.length() > 0) {
            fixFormatterFieldDataImpl.put(string, string2);
        }
    }

    private static StringBuffer constructEventText(ITmcMessage iTmcMessage) {
        StringBuffer stringBuffer = new StringBuffer();
        if (iTmcMessage.getEventText().length > 0) {
            for (int i2 = 1; i2 < iTmcMessage.getEventText().length; ++i2) {
                if (iTmcMessage.getEventText()[i2] == null) continue;
                stringBuffer.append(iTmcMessage.getEventText()[i2]);
                if (i2 + 1 >= iTmcMessage.getEventText().length) continue;
                stringBuffer.append(", ");
            }
        }
        return stringBuffer;
    }
}

