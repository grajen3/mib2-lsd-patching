/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.locationinput;

import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public interface ILocationinputResultListener {
    default public void updateInputActive(boolean bl) {
    }

    default public void updateState(NavLocation navLocation, int[] nArray, boolean bl, boolean bl2, boolean bl3) {
    }

    default public void updateValueList(LIValueList lIValueList, long l, IHnrFlags iHnrFlags) {
    }

    default public void haptikTakesOwnership() {
    }
}

