/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.map.INavigationPosInfo;
import org.dsi.ifc.map.PosInfo;

public class INavigationPosInfoImpl
implements INavigationPosInfo {
    public PosInfo realPosInfo;

    public INavigationPosInfoImpl(PosInfo posInfo) {
        this.realPosInfo = posInfo;
    }
}

