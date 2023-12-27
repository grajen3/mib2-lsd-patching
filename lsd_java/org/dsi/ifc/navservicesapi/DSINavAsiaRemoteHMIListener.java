/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;

public interface DSINavAsiaRemoteHMIListener
extends DSIListener {
    default public void updateCurrentCityAndStreet(String string, String string2, int n) {
    }

    default public void updateDayNightView(int n, int n2) {
    }

    default public void updateDestination(double[] dArray, double[] dArray2, int n) {
    }

    default public void updateDestinationDistanceAndTime(double[] dArray, int[] nArray, int n) {
    }

    default public void updatePositionInfo(double d2, double d3, double d4, double d5, double d6, int n) {
    }

    default public void updateNavigationState(boolean bl, boolean bl2, int n) {
    }
}

