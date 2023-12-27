/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navbap;

import de.vw.mib.asl.api.navbap.IRouteDestinationsNavBap;

public interface IRouteNavBap {
    default public IRouteDestinationsNavBap[] getRoutelist() {
    }

    default public long getIndexOfCurrentDestination() {
    }
}

