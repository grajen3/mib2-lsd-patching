/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.light;

import de.vw.mib.asl.api.car.light.LightService;

public class NotAvailableLightService
implements LightService {
    @Override
    public String getColorSRGB() {
        return "#000000";
    }
}

