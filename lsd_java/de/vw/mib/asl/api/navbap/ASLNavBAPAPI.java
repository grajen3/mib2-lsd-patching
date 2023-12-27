/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navbap;

import de.vw.mib.asl.api.navbap.IBapTurnToInfoNavBap;
import de.vw.mib.asl.api.navbap.ILDListElementNavBap;
import de.vw.mib.asl.api.navbap.ILocationAccessorNavBap;
import de.vw.mib.asl.api.navbap.INavLaneGuidanceDataNavBap;
import de.vw.mib.asl.api.navbap.IRouteNavBap;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.tmc.TmcMessage;

public interface ASLNavBAPAPI {
    default public void updateBapCompassInfo(int n, int n2) {
    }

    default public void updateBapDistanceToDestination(int n, int n2) {
    }

    default public void updateBapDistanceToDestination(int n, int n2, boolean bl) {
    }

    default public void updateBapDistanceToNextManeuver(int n, int n2, boolean bl, int n3) {
    }

    default public void updateBapTimeToDestination(int n, int n2, long l) {
    }

    default public void updateBapTimeToDestinationRTT(long l) {
    }

    default public void updateBapTimeToDestinationRTTandETA(long l, long l2) {
    }

    default public void updateBapTimeToDestination2(int n, int n2, int n3) {
    }

    default public void updateBapTurnToInfo(String string, String string2) {
    }

    default public void updateBapTurnToInfo(IBapTurnToInfoNavBap[] iBapTurnToInfoNavBapArray) {
    }

    default public void updateBapTMCInfo(TmcMessage tmcMessage) {
    }

    default public void updateBapAltitudeCollector(int n, int n2) {
    }

    default public void navBookInit(ASLListElementFetcher aSLListElementFetcher, int n) {
    }

    default public void navBookUpdate(int n, DataSet[] dataSetArray, int n2) {
    }

    default public void favoriteDestinationInit(ASLListElementFetcher aSLListElementFetcher, int n) {
    }

    default public void favoriteDestinationUpdate(int n, DataSet[] dataSetArray, int n2) {
    }

    default public void navBookSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
    }

    default public void addrListUpdate(AdbEntry[] adbEntryArray) {
    }

    default public Object createDetailListCollector(ILocationAccessorNavBap iLocationAccessorNavBap, String string) {
    }

    default public void updateRgCurrentRoute(IRouteNavBap iRouteNavBap, ILocationAccessorNavBap iLocationAccessorNavBap) {
    }

    default public void lastDestListUpdate(ILDListElementNavBap[] iLDListElementNavBapArray) {
    }

    default public void updateBapLaneGuidance(INavLaneGuidanceDataNavBap[] iNavLaneGuidanceDataNavBapArray, boolean bl) {
    }

    default public void updateMapsScale(int n, int n2) {
    }

    default public void updateMapsScale(int n, int n2, int n3) {
    }
}

