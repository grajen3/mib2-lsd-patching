/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.internal;

import de.vw.mib.physics.GeoPosition;
import de.vw.mib.physics.GeoPositionFactory;
import de.vw.mib.physics.internal.GeoPositionImpl;

public class GeoPositionFactoryImpl
implements GeoPositionFactory {
    @Override
    public GeoPosition createGeoPosition() {
        return new GeoPositionImpl();
    }
}

