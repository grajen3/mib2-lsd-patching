/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.framework.diag.CioDiagListener;
import de.vw.mib.cio.framework.diag.CioDiagService;
import de.vw.mib.cio.framework.diag.CioIntentDiag;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.cio.internal.Dispatcher;
import de.vw.mib.cio.internal.Factory;
import de.vw.mib.collections.copyonwrite.CowArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DiagService
implements CioDiagService,
CioDiagListener {
    private final CowArray listeners = new CowArray();
    private final Dictionary dictionary;
    private final Dispatcher dispatcher;
    private final Factory factory;

    DiagService(Dictionary dictionary, Dispatcher dispatcher, Factory factory) {
        this.dictionary = dictionary;
        this.dispatcher = dispatcher;
        this.factory = factory;
        dictionary.setCioDiagListener(this);
        dispatcher.setCioDiagService(this);
    }

    @Override
    public CioParametersCreator createActionParams(CioIntentDiag cioIntentDiag) {
        return this.factory.createActionParameters(cioIntentDiag);
    }

    @Override
    public void dispatch(CioIntent cioIntent, CioActionParameters cioActionParameters) {
        this.dispatcher.dispatch(cioIntent, cioActionParameters);
    }

    @Override
    public List getRegisteredCioIntents() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.dictionary.getAllCioIntents());
        return arrayList;
    }

    @Override
    public Map getCioIntentClasses() {
        return this.dictionary.getCioIntentClasses();
    }

    @Override
    public void onCioIntentChanged(CioIntentDiag cioIntentDiag) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((CioDiagListener)objectArray[i2]).onCioIntentChanged(cioIntentDiag);
        }
    }

    @Override
    public void onCioIntentExecute(CioIntentDiag cioIntentDiag, CioActionParameters cioActionParameters) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((CioDiagListener)objectArray[i2]).onCioIntentExecute(cioIntentDiag, cioActionParameters);
        }
    }

    @Override
    public void onCioIntentRegistered(CioIntentDiag cioIntentDiag) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((CioDiagListener)objectArray[i2]).onCioIntentRegistered(cioIntentDiag);
        }
    }

    @Override
    public void onCioIntentUnregistered(CioIntentDiag cioIntentDiag) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((CioDiagListener)objectArray[i2]).onCioIntentUnregistered(cioIntentDiag);
        }
    }

    void registerCioDiagListener(CioDiagListener cioDiagListener) {
        this.listeners.addIfNotAlreadyIn(cioDiagListener);
    }

    void unregisterCioDiagListener(CioDiagListener cioDiagListener) {
        this.listeners.remove(cioDiagListener);
    }

    @Override
    public void onCioVisualizationChanged(CioIntentDiag cioIntentDiag) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((CioDiagListener)objectArray[i2]).onCioVisualizationChanged(cioIntentDiag);
        }
    }
}

