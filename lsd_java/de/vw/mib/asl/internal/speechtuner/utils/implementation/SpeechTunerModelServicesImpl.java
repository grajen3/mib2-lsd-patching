/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils.implementation;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerModelServices;

public final class SpeechTunerModelServicesImpl
implements SpeechTunerModelServices {
    private final Services frameworkServices;

    public SpeechTunerModelServicesImpl(Services services) {
        this.frameworkServices = services;
    }

    @Override
    public void writeIntegerToDatapool(int n, int n2) {
        this.frameworkServices.getASLPropertyManager().valueChangedInteger(n, n2);
    }

    @Override
    public void sendEventToModel(int n) {
        this.frameworkServices.getSystemEventDispatcher().createAndSubmitHMIEvent(n);
    }

    @Override
    public void sendUnexpectedErrorEventToModel() {
        this.frameworkServices.getSystemEventDispatcher().createAndSubmitHMIEvent(-467518976);
    }

    @Override
    public GenericASLList getGenericASLList(int n) {
        return this.frameworkServices.getASLListManager().getGenericASLList(n);
    }

    @Override
    public ASLListManager getListManager() {
        return this.frameworkServices.getASLListManager();
    }
}

