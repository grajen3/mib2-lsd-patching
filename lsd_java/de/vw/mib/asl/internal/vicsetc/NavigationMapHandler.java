/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.navigation.map.NavigationMapListenerAdapter;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;

public class NavigationMapHandler
extends NavigationMapListenerAdapter {
    private final VicsTarget target;

    public NavigationMapHandler(VicsTarget vicsTarget) {
        this.target = vicsTarget;
    }

    @Override
    public void updateMapType(int n) {
        this.target.traceMsg(new StringBuffer().append("updateMapType( mapType = ").append(n).append(" )").toString(), this);
        this.notfiyModelOnUpdatedMapType(n);
    }

    private void notfiyModelOnUpdatedMapType(int n) {
        int n2 = n == 2 ? 1 : 0;
        VicsTarget.writeIntegerToDatapool(-2120592128, n2);
    }
}

