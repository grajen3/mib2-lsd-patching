/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayListener;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStreamToNavLocation;

class NavigationLocationinputServiceImpl$2
extends AbstractNavGatewayListener {
    private final /* synthetic */ Object val$arg;
    private final /* synthetic */ NavigationLocationinputServiceImpl this$0;

    NavigationLocationinputServiceImpl$2(NavigationLocationinputServiceImpl navigationLocationinputServiceImpl, Object object) {
        this.this$0 = navigationLocationinputServiceImpl;
        this.val$arg = object;
    }

    @Override
    public void handleCommandCmdStreamToNavLocation(CmdStreamToNavLocation cmdStreamToNavLocation) {
        INavigationLocation[] iNavigationLocationArray = new INavigationLocation[]{new INavigationLocationImpl(cmdStreamToNavLocation.getLocationToStream())};
        this.this$0.listener.resolveContactResult(iNavigationLocationArray, this.val$arg);
    }
}

