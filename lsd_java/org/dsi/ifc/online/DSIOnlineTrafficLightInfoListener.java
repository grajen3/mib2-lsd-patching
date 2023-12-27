/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.CarBCSpeed;

public interface DSIOnlineTrafficLightInfoListener
extends DSIListener {
    default public void updateTrafficLightInfo(int n, int n2, int[] nArray, int n3, int n4, int n5) {
    }

    default public void updateTrafficLightSpeed(CarBCSpeed carBCSpeed, int n) {
    }

    default public void updateTrafficLightTime(int n, int n2, int n3) {
    }
}

