/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.ResolveAddressListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactAddressDetailController;

class NavigateContactAddressDetailController$1
implements ResolveAddressListener {
    private final /* synthetic */ NavigateContactAddressDetailController this$0;

    NavigateContactAddressDetailController$1(NavigateContactAddressDetailController navigateContactAddressDetailController) {
        this.this$0 = navigateContactAddressDetailController;
    }

    @Override
    public void resolveAddressResult(int n, INavigationLocation iNavigationLocation) {
        if (n == 1) {
            Framework.fireUIEvent(-519556096);
            return;
        }
        this.this$0.notifyShowDestinationAddressDetails(iNavigationLocation);
    }
}

