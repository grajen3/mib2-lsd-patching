/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.GuidanceInfo;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.api.navigation.map.ASLNavigationServiceMainMap;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.organizer.AdbEntry;

public interface ASLNavigationServices {
    public static final int GUIDANCE_DESTINATION_NEXT_STOPOVER;
    public static final int GUIDANCE_DESTINATION_FINAL;
    public static final int SOURCE_UNDEFINED;
    public static final int SOURCE_ONLINE;
    public static final int SOURCE_PHONE;
    public static final int SOURCE_OCU;
    public static final int SOURCE_MESSAGING;
    public static final int SOURCE_TRAVELLINK;
    public static final int SOURCE_SMARTPHONE_INTEGRATION;
    public static final int RESULT_OK;
    public static final int RESULT_ERROR;
    public static final int RESULT_CANCEL;

    default public boolean isServiceAvailable() {
    }

    default public int getContactCapacity() {
    }

    default public void importContact(AdbEntry adbEntry, int n) {
    }

    default public void importContact(AdbEntry adbEntry, int n, boolean bl) {
    }

    default public void importContactSummary(int n, int n2, int n3, int n4) {
    }

    default public int startGuidance(NavAddress[] navAddressArray, boolean bl, int n) {
    }

    default public int stopGuidance(int n) {
    }

    default public boolean isGuidanceActive() {
    }

    default public GuidanceInfo[] getGuidanceInfo() {
    }

    default public NavAddress getCurrentCarPosition() {
    }

    default public NavAddress getLocationInputAddress() {
    }

    default public boolean isValidOnlinePoiCategory(int n) {
    }

    default public ASLNavigationServiceMainMap createMainMapService(AbstractTarget abstractTarget, int[] nArray) {
    }

    default public int[] parseGeoPositionVCard3_0(String string) {
    }
}

