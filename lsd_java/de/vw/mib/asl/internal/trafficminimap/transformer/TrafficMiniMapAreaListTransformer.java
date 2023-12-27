/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.transformer;

import de.vw.mib.asl.internal.trafficminimap.common.TrafficMiniMapInfo;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.AbstractTrafficMiniMapAreaListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class TrafficMiniMapAreaListTransformer
extends AbstractTrafficMiniMapAreaListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        TrafficMiniMapInfo trafficMiniMapInfo = (TrafficMiniMapInfo)object;
        switch (n) {
            case 3: {
                boolean bl = false;
                if (trafficMiniMapInfo != null && trafficMiniMapInfo.getTrafficMessage() != null) {
                    bl = trafficMiniMapInfo.getTrafficMessage().isIsValid();
                }
                return bl;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        return 0;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        TrafficMiniMapInfo trafficMiniMapInfo = (TrafficMiniMapInfo)object;
        switch (n) {
            case 2: {
                ResourceLocator resourceLocator = new ResourceLocator();
                if (trafficMiniMapInfo != null && trafficMiniMapInfo.getResourceInformation() != null) {
                    resourceLocator = trafficMiniMapInfo.getResourceInformation().getResourceLocator() != null ? trafficMiniMapInfo.getResourceInformation().getResourceLocator() : new ResourceLocator();
                }
                return resourceLocator;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TrafficMiniMapInfo trafficMiniMapInfo = (TrafficMiniMapInfo)object;
        switch (n) {
            case 0: {
                String string = "";
                if (trafficMiniMapInfo != null && trafficMiniMapInfo.getTrafficMessage() != null) {
                    string = trafficMiniMapInfo.getTrafficMessage().getValue();
                }
                return string;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public long getLong(int n, Object object) {
        TrafficMiniMapInfo trafficMiniMapInfo = (TrafficMiniMapInfo)object;
        switch (n) {
            case 4: {
                long l = 0L;
                if (trafficMiniMapInfo != null && trafficMiniMapInfo.getTrafficMessage() != null) {
                    l = trafficMiniMapInfo.getTrafficMessage().getContentID();
                }
                return l;
            }
        }
        throw new IllegalArgumentException();
    }
}

