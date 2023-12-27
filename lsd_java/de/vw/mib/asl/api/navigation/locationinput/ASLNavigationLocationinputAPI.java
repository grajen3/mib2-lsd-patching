/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.locationinput;

import de.vw.mib.asl.api.navigation.IASLNavigationInternalServiceFirst;
import de.vw.mib.asl.api.navigation.locationinput.ILocationinputResultListener;
import de.vw.mib.asl.api.navigation.locationinput.IStartupState;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.memory.SetHomeAddressToCcpCallback;
import org.dsi.ifc.global.NavLocation;

public interface ASLNavigationLocationinputAPI
extends IASLNavigationInternalServiceFirst {
    public static final int EV_LOCATION_INPUT_START_INPUT;
    public static final int EV_LOCATION_INPUT_START_INPUT_P0;
    public static final int EV_LOCATION_INPUT_SET_INPUT;
    public static final int EV_LOCATION_INPUT_SET_INPUT_P0;
    public static final int EV_LOCATION_INPUT_SET_INPUT_P1;
    public static final int EV_LOCATION_INPUT_SELECT_ENTRY_VIA_ID;
    public static final int EV_LOCATION_INPUT_SELECT_ENTRY_VIA_ID_P0;
    public static final int EV_LOCATION_INPUT_SELECT_ENTRY_VIA_ID_P1;
    public static final int EV_LOCATION_INPUT_SELECT_NOTHING;
    public static final int EV_LOCATION_INPUT_SELECT_NOTHING_P0;
    public static final int EV_LOCATION_INPUT_CANCEL_INPUT;
    public static final int EV_LOCATION_INPUT_CANCEL_INPUT_P0;
    public static final int EV_LOCATION_INPUT_SET_CURRENT_LOCATION;
    public static final int EV_LOCATION_INPUT_SET_CURRENT_LOCATION_P0;
    public static final int EV_LOCATION_INPUT_SELECT_ENTRY_VIA_INDEX;
    public static final int EV_LOCATION_INPUT_SELECT_ENTRY_VIA_INDEX_P0;
    public static final int EV_LOCATION_INPUT_SELECT_ENTRY_VIA_INDEX_P1;
    public static final int EV_LOCATION_INPUT_HOME_ADRESS_SET_TO_CCP_UPDATE;
    public static final int EV_LOCATION_INPUT_HOME_ADRESS_SET_TO_CCP_UPDATE_PO_RESULT;
    public static final int EV_LOCATION_INPUT_HOME_ADRESS_SET_UPDATE;
    public static final int EV_LOCATION_INPUT_HOME_ADRESS_SET_UPDATE_PO_RESULT;

    default public void addSpellerHandler(int n, int n2, SpellerHandler spellerHandler) {
    }

    default public void startSpeller(SpellerHandler spellerHandler) {
    }

    default public void saveSpeller(SpellerHandler spellerHandler) {
    }

    default public void startInput(int n) {
    }

    default public void setInput(int n, String string) {
    }

    default public void selectEntryViaId(int n, String string) {
    }

    default public void selectEntryViaIndex(int n, int n2) {
    }

    default public void selectNothing(int n) {
    }

    default public void cancelInput(int n) {
    }

    default public void setCurrentLocation(NavLocation navLocation) {
    }

    default public void registerListener(ILocationinputResultListener iLocationinputResultListener) {
    }

    default public void unregisterListener(ILocationinputResultListener iLocationinputResultListener) {
    }

    default public boolean isInputActive() {
    }

    default public int[] getCurrentSelectionCriteria() {
    }

    default public NavLocation getCurrentLocation() {
    }

    default public void setSpellerContextLocation(NavLocation navLocation) {
    }

    default public void setHomeAddressToCcp(SetHomeAddressToCcpCallback setHomeAddressToCcpCallback) {
    }

    default public void setHomeAddressToCcp() {
    }

    default public void setHomeAddress(NavLocation navLocation) {
    }

    default public void setPointLocation(boolean bl) {
    }

    default public void setStartupState(IStartupState iStartupState) {
    }

    default public void requestStartupState(ILocationinputResultListener iLocationinputResultListener) {
    }
}

