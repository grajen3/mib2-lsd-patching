/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic.transformer;

import de.vw.mib.asl.internal.navigation.caching.IconDescriptor;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class TrafficMessageIcon {
    public IconDescriptor iconDescriptor = new IconDescriptor(new ResourceLocator(), new TextRenderingInfo());
    public IconDescriptor roadIconDescriptor = new IconDescriptor(new ResourceLocator(), new TextRenderingInfo());
    public boolean isRoadIconDescriptor;
    public long tmcElement_uID;

    public TrafficMessageIcon(long l) {
        this.tmcElement_uID = l;
        this.isRoadIconDescriptor = false;
    }

    public TrafficMessageIcon(long l, boolean bl) {
        this.tmcElement_uID = l;
        this.isRoadIconDescriptor = bl;
    }
}

