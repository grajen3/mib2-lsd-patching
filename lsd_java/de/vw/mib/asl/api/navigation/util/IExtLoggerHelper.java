/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public interface IExtLoggerHelper {
    default public LogMessage appendStr(LogMessage logMessage, String string, String string2) {
    }

    default public LogMessage appendInt(LogMessage logMessage, String string, int n) {
    }

    default public LogMessage appendLong(LogMessage logMessage, String string, long l) {
    }

    default public LogMessage appendBool(LogMessage logMessage, String string, boolean bl) {
    }

    default public LogMessage appendGeopos(LogMessage logMessage, int n, int n2, int n3) {
    }

    default public LogMessage appendLocation(LogMessage logMessage, NavLocation navLocation) {
    }

    default public LogMessage appendTmcListElement(LogMessage logMessage, TmcListElement tmcListElement) {
    }

    default public LogMessage appendTmcMessage(LogMessage logMessage, TmcMessage tmcMessage) {
    }

    default public LogMessage appendCriteria(LogMessage logMessage, int[] nArray) {
    }

    default public LogMessage appendSpellerData(LogMessage logMessage, SpellerData spellerData) {
    }

    default public void traceWithLocation(Logger logger, int n, String string, NavLocation navLocation, String string2) {
    }

    default public LogMessage appendCityHistory(LogMessage logMessage, LICityHistoryEntry[] lICityHistoryEntryArray) {
    }

    default public LogMessage appendStreetHistory(LogMessage logMessage, LIStreetHistoryEntry[] lIStreetHistoryEntryArray) {
    }
}

