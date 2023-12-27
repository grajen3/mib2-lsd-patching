/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.State;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;

interface Context {
    default public AbstractPersonalizedAppDsiAdapter getDsiAdapter() {
    }

    default public PersistenceServices getServices() {
    }

    default public void logError(String string) {
    }

    default public void logError(String string, Exception exception) {
    }

    default public void logInformation(String string) {
    }

    default public void logTrace(String string) {
    }

    default public void logWarning(String string) {
    }

    default public void startTimer(long l) {
    }

    default public void stopTimer() {
    }

    default public void transitionToState(State state) {
    }
}

