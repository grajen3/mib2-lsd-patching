/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.speller;

import org.dsi.ifc.global.NavLocation;

public interface SpellerContext {
    default public void setLocation(NavLocation navLocation) {
    }

    default public NavLocation getLocation() {
    }
}

