/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.locationinput;

import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.global.NavLocation;

public interface ISpellerContext {
    public static final int STATE_NONE;
    public static final int STATE_COUNTRY;
    public static final int STATE_CITY;
    public static final int STATE_STREET;
    public static final int STATE_HOUSENUMBER;
    public static final int STATE_CROSSING;
    public static final int STATE_ZIP;
    public static final int STATE_STREET_DISAMB;
    public static final int STATE_PROVINCE;
    public static final int STATE_STATE;
    public static final int STATE_STREET_WTIH_BASENAMES;
    public static final int STATE_CHOME;
    public static final int STATE_PLACE;
    public static final int STATE_WARD;
    public static final int STATE_PHONENUMBER;
    public static final int STATE_MAPCODE;
    public static final int HISTORY_MODE_NONE;
    public static final int HISTORY_MODE_CITY;
    public static final int HISTORY_MODE_STREET;

    default public void setHandler(SpellerHandler spellerHandler) {
    }

    default public SpellerHandler getHandler() {
    }

    default public void setLocation(NavLocation navLocation) {
    }

    default public NavLocation getLocation() {
    }

    default public void setState(int n) {
    }

    default public int getActiveState() {
    }

    default public Target getTarget() {
    }
}

