/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioRegistrationListener;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.Factory;
import de.vw.mib.cio.internal.ForwardingCio;

class Factory$1
implements CioRegistrationListener {
    private final /* synthetic */ String val$forwardedCioIntentClass;
    private final /* synthetic */ String val$forwardedUsageName;
    private final /* synthetic */ String val$appName;
    private final /* synthetic */ String val$appInstanceName;
    private final /* synthetic */ String val$cioName;
    private final /* synthetic */ String val$intentName;
    private final /* synthetic */ String val$intentClass;
    private final /* synthetic */ String val$usage;
    private final /* synthetic */ int val$rank;
    private final /* synthetic */ long val$intentId;
    private final /* synthetic */ long[] val$visualizationIds;
    private final /* synthetic */ int val$featureFlagId;
    private final /* synthetic */ CioExecutor val$cioExecutor;
    private final /* synthetic */ Factory this$0;

    Factory$1(Factory factory, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n, long l, long[] lArray, int n2, CioExecutor cioExecutor) {
        this.this$0 = factory;
        this.val$forwardedCioIntentClass = string;
        this.val$forwardedUsageName = string2;
        this.val$appName = string3;
        this.val$appInstanceName = string4;
        this.val$cioName = string5;
        this.val$intentName = string6;
        this.val$intentClass = string7;
        this.val$usage = string8;
        this.val$rank = n;
        this.val$intentId = l;
        this.val$visualizationIds = lArray;
        this.val$featureFlagId = n2;
        this.val$cioExecutor = cioExecutor;
    }

    @Override
    public void cioRegistered(String string, CioIntent cioIntent) {
        AbstractCio abstractCio = (AbstractCio)this.this$0.dictionary.getCioIntent(this.val$forwardedCioIntentClass, this.val$forwardedUsageName);
        if (abstractCio != null) {
            this.this$0.dictionary.removeCioRegistrationListener(this.val$forwardedCioIntentClass, this);
            ForwardingCio forwardingCio = new ForwardingCio(this.val$appName, this.val$appInstanceName, this.val$cioName, this.val$intentName, this.val$intentClass, this.val$usage, this.val$rank, this.val$intentId, this.val$visualizationIds, abstractCio, this.this$0.dictionary, this.this$0.scriptWidgetService);
            this.this$0.registerIfRequested(forwardingCio, this.val$featureFlagId, this.val$cioExecutor);
        }
    }

    @Override
    public void cioUnregistered(String string, CioIntent cioIntent) {
    }
}

