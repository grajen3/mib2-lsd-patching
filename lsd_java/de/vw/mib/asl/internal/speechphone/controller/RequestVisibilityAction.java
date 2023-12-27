/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.controller.AbstractCombinedAction;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;

public class RequestVisibilityAction
extends AbstractCombinedAction {
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;

    public RequestVisibilityAction(CioDictionary cioDictionary, CioDispatcher cioDispatcher) {
        this.cioDictionary = cioDictionary;
        this.cioDispatcher = cioDispatcher;
    }

    @Override
    protected void onAction(int n) {
        CioIntent cioIntent = this.cioDictionary.getCioIntent("ShowContent", "HMI_SPEECHPHONE");
        this.cioDispatcher.dispatch(cioIntent);
    }
}

