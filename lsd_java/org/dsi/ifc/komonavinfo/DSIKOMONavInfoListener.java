/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komonavinfo;

import org.dsi.ifc.base.DSIListener;

public interface DSIKOMONavInfoListener
extends DSIListener {
    default public void setCurrentStreetResult(int n) {
    }

    default public void setTurnToStreetResult(int n) {
    }

    default public void setCityNameResult(int n) {
    }

    default public void setSemiDynRouteResult(int n) {
    }

    default public void setTrafficOffsetResult(int n) {
    }

    default public void setRgSelectResult(int n) {
    }

    default public void setCapabilitiesResult(int n) {
    }

    default public void setMapScaleResult(int n, int n2, boolean[] blArray, int n3, int n4, boolean[] blArray2, boolean bl) {
    }

    default public void setMapScale(int n, int n2, boolean[] blArray, int n3, int n4, int n5) {
    }
}

