/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkClosestTrafficMessagesListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public final class TravelLinkClosestTrafficMessagesListTransformer
extends AbstractTravelLinkClosestTrafficMessagesListTransformer {
    @Override
    public String getString(int n, Object object) {
        return "Traffic";
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        return null;
    }
}

