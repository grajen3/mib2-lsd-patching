/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLoggerHelper;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public final class ExtLoggerHelper
implements IExtLoggerHelper {
    private static IExtLoggerHelper mpInstance = new ExtLoggerHelper();

    private ExtLoggerHelper() {
    }

    public static IExtLoggerHelper getInstance() {
        return mpInstance;
    }

    @Override
    public LogMessage appendStr(LogMessage logMessage, String string, String string2) {
        if (string2 != null && string2.length() > 0) {
            logMessage.append(string).append("=").append(string2).append(" ");
        }
        return logMessage;
    }

    @Override
    public LogMessage appendInt(LogMessage logMessage, String string, int n) {
        return logMessage.append(string).append("=").append(n).append(" ");
    }

    @Override
    public LogMessage appendLong(LogMessage logMessage, String string, long l) {
        return logMessage.append(string).append("=").append(l).append(" ");
    }

    @Override
    public LogMessage appendBool(LogMessage logMessage, String string, boolean bl) {
        return logMessage.append(string).append("=").append(bl).append(" ");
    }

    @Override
    public LogMessage appendGeopos(LogMessage logMessage, int n, int n2, int n3) {
        return logMessage.append(n).append(".").append(n2).append(".").append(n3);
    }

    @Override
    public LogMessage appendLocation(LogMessage logMessage, NavLocation navLocation) {
        if (navLocation == null) {
            logMessage.append("NULL-LOC=[ ]");
        } else {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            logMessage.append(iLocationWrapper.isNavigable() ? "VAL-LOC=[ " : "INV-LOC=[ ");
            this.appendInt(logMessage, "LO", iLocationWrapper.getLongitude());
            this.appendInt(logMessage, "LA", iLocationWrapper.getLatitude());
            this.appendStr(logMessage, "C", iLocationWrapper.getCountry());
            this.appendStr(logMessage, "CA", iLocationWrapper.getCountryCode());
            this.appendStr(logMessage, "ST", iLocationWrapper.getState());
            this.appendStr(logMessage, "T", iLocationWrapper.getCity());
            this.appendStr(logMessage, "Z", iLocationWrapper.getPostalCode());
            this.appendStr(logMessage, "TR", iLocationWrapper.getCityRefinement());
            this.appendStr(logMessage, "NbS", iLocationWrapper.getStreetNearby());
            this.appendStr(logMessage, "S", iLocationWrapper.getStreet());
            this.appendStr(logMessage, "SR", iLocationWrapper.getStreetRefinement());
            this.appendStr(logMessage, "HN", iLocationWrapper.getHousenumber());
            this.appendStr(logMessage, "J", iLocationWrapper.getCrossing());
            this.appendBool(logMessage, "BN", iLocationWrapper.isStreetBasename());
            logMessage.append(" ]");
        }
        return logMessage;
    }

    @Override
    public LogMessage appendTmcListElement(LogMessage logMessage, TmcListElement tmcListElement) {
        if (tmcListElement == null) {
            logMessage.append("NULL-TMCELEMENT=[ ]");
        } else {
            logMessage.append("TMCLISTELEMENT=[ ");
            this.appendLong(logMessage, "uID", tmcListElement.uID);
            this.appendInt(logMessage, "Type", tmcListElement.type);
            this.appendBool(logMessage, "IsBi", tmcListElement.isBidirectional);
            this.appendBool(logMessage, "HasChild", tmcListElement.hasChild);
            if (tmcListElement.hasChild) {
                this.appendInt(logMessage, "NoOfEl", tmcListElement.numberOfMessagesInNode);
                this.appendStr(logMessage, "RName", tmcListElement.roadName);
                this.appendStr(logMessage, "RNum", tmcListElement.roadNumber);
            } else {
                this.appendTmcMessage(logMessage, tmcListElement.message);
            }
            logMessage.append(" ]");
        }
        return logMessage;
    }

    @Override
    public LogMessage appendTmcMessage(LogMessage logMessage, TmcMessage tmcMessage) {
        if (tmcMessage == null) {
            logMessage.append("NULL-TMCMESSAGE=[ ]");
        } else {
            logMessage.append("TMCMESSAGE=[ ");
            this.appendLong(logMessage, "mID", tmcMessage.messageID);
            this.appendBool(logMessage, "IsArea", tmcMessage.isArea);
            this.appendBool(logMessage, "IsBi", tmcMessage.isBidirectional);
            this.appendStr(logMessage, "Dir1", tmcMessage.directionOfRoad1);
            this.appendStr(logMessage, "Dir2", tmcMessage.directionOfRoad2);
            this.appendStr(logMessage, "StrtL", tmcMessage.startLocation);
            this.appendStr(logMessage, "EndL", tmcMessage.endLocation);
            this.appendStr(logMessage, "RName", tmcMessage.roadName);
            this.appendStr(logMessage, "RNum", tmcMessage.roadNumber);
            this.appendStr(logMessage, "Urg", tmcMessage.urgent);
            this.appendInt(logMessage, "RRel", tmcMessage.routeRelevance);
            if (tmcMessage.eventText != null) {
                for (int i2 = 0; i2 < tmcMessage.eventText.length; ++i2) {
                    String string = tmcMessage.eventText[i2];
                    if (string == null || string.length() <= 0) continue;
                    logMessage.append("EvTxt[").append(i2).append("]=(").append(string).append(") ");
                }
            }
            if (tmcMessage.startTime != 0L) {
                this.appendLong(logMessage, "StartT", tmcMessage.startTime);
            }
            if (tmcMessage.endTime != 0L) {
                this.appendLong(logMessage, "EndT", tmcMessage.endTime);
            }
            if (tmcMessage.hasGeoPos) {
                this.appendInt(logMessage, "LO", tmcMessage.geoPosLongitude);
                this.appendInt(logMessage, "LA", tmcMessage.geoPosLatitude);
            }
            logMessage.append(" ]");
        }
        return logMessage;
    }

    @Override
    public LogMessage appendCriteria(LogMessage logMessage, int[] nArray) {
        logMessage.append("[");
        block16: for (int i2 = 0; i2 < nArray.length; ++i2) {
            switch (nArray[i2]) {
                case 1: {
                    logMessage.append(" C");
                    continue block16;
                }
                case 138: {
                    logMessage.append(" ST");
                    continue block16;
                }
                case 2: {
                    logMessage.append(" T");
                    continue block16;
                }
                case 6: {
                    logMessage.append(" Z");
                    continue block16;
                }
                case 3: {
                    logMessage.append(" S");
                    continue block16;
                }
                case 32782: {
                    logMessage.append(" SF");
                    continue block16;
                }
                case 141: {
                    logMessage.append(" SFN");
                    continue block16;
                }
                case 127: {
                    logMessage.append(" SA");
                    continue block16;
                }
                case 16: {
                    logMessage.append(" TC");
                    continue block16;
                }
                case 5: {
                    logMessage.append(" HN");
                    continue block16;
                }
                case 136: {
                    logMessage.append(" HNA");
                    continue block16;
                }
                case 4: {
                    logMessage.append(" J");
                    continue block16;
                }
                case 32768: {
                    logMessage.append(" POI");
                    continue block16;
                }
                case 133: {
                    logMessage.append(" LIC");
                    continue block16;
                }
                default: {
                    logMessage.append(" ").append(nArray[i2]);
                }
            }
        }
        logMessage.append(" ]");
        return logMessage;
    }

    @Override
    public LogMessage appendSpellerData(LogMessage logMessage, SpellerData spellerData) {
        logMessage.append("[");
        this.appendStr(logMessage, "input", spellerData.getEnteredText());
        this.appendStr(logMessage, "match_t", spellerData.getMatchText());
        this.appendInt(logMessage, "match_c", spellerData.getMatchCount());
        this.appendStr(logMessage, "nvc", spellerData.getAvailableCharacters());
        this.appendInt(logMessage, "cur_pos", spellerData.getCursorPosition());
        this.appendInt(logMessage, "sel_sta", spellerData.getSelectionStart());
        this.appendInt(logMessage, "sel_end", spellerData.getSelectionEnd());
        logMessage.append("]");
        return logMessage;
    }

    @Override
    public void traceWithLocation(Logger logger, int n, String string, NavLocation navLocation, String string2) {
        if (logger.isTraceEnabled(n)) {
            LogMessage logMessage = logger.trace(16384);
            logMessage.append(string);
            this.appendLocation(logMessage, navLocation);
            logMessage.append(string2);
            logMessage.log();
        }
    }

    @Override
    public LogMessage appendCityHistory(LogMessage logMessage, LICityHistoryEntry[] lICityHistoryEntryArray) {
        logMessage.append("{ ");
        if (lICityHistoryEntryArray != null) {
            for (int i2 = 0; i2 < lICityHistoryEntryArray.length; ++i2) {
                if (lICityHistoryEntryArray[i2] == null || lICityHistoryEntryArray[i2].name == null) continue;
                logMessage.append(lICityHistoryEntryArray[i2].name).append("(").append(lICityHistoryEntryArray[i2].id).append(") ");
            }
        }
        logMessage.append("}");
        return logMessage;
    }

    @Override
    public LogMessage appendStreetHistory(LogMessage logMessage, LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
        logMessage.append("{ ");
        if (lIStreetHistoryEntryArray != null) {
            for (int i2 = 0; i2 < lIStreetHistoryEntryArray.length; ++i2) {
                if (lIStreetHistoryEntryArray[i2] == null || lIStreetHistoryEntryArray[i2].name == null) continue;
                logMessage.append(lIStreetHistoryEntryArray[i2].name).append("(").append(lIStreetHistoryEntryArray[i2].id).append(") ");
            }
        }
        logMessage.append("}");
        return logMessage;
    }
}

