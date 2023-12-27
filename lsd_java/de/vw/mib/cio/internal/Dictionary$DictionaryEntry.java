/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioRegistrationListener;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.Dictionary$DictionaryEntry$1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class Dictionary$DictionaryEntry {
    private static final Comparator ENTRY_COMPARATOR = new Dictionary$DictionaryEntry$1();
    private final ArrayList cios;
    private final String intentClass;
    private final ArrayList listeners;

    Dictionary$DictionaryEntry(String string) {
        this.intentClass = string;
        this.cios = new ArrayList();
        this.listeners = new ArrayList();
    }

    AbstractCio getCio() {
        if (this.cios.isEmpty()) {
            return null;
        }
        return (AbstractCio)this.cios.get(0);
    }

    List getCios() {
        return this.cios;
    }

    void registerCio(AbstractCio abstractCio) {
        if (this.cios.contains(abstractCio)) {
            return;
        }
        this.cios.add(abstractCio);
        Collections.sort(this.cios, ENTRY_COMPARATOR);
        if (!this.listeners.isEmpty()) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                CioRegistrationListener cioRegistrationListener = (CioRegistrationListener)this.listeners.get(i2);
                cioRegistrationListener.cioRegistered(this.intentClass, abstractCio);
            }
        }
    }

    void unregisterCio(AbstractCio abstractCio) {
        if (!this.cios.contains(abstractCio)) {
            return;
        }
        this.cios.remove(abstractCio);
        if (!this.listeners.isEmpty()) {
            for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
                CioRegistrationListener cioRegistrationListener = (CioRegistrationListener)this.listeners.get(i2);
                cioRegistrationListener.cioUnregistered(this.intentClass, abstractCio);
            }
        }
    }

    void addListener(CioRegistrationListener cioRegistrationListener) {
        if (this.listeners.contains(cioRegistrationListener)) {
            return;
        }
        this.listeners.add(cioRegistrationListener);
        if (!this.cios.isEmpty()) {
            for (int i2 = 0; i2 < this.cios.size(); ++i2) {
                cioRegistrationListener.cioRegistered(this.intentClass, (AbstractCio)this.cios.get(i2));
            }
        }
    }

    void removeListener(CioRegistrationListener cioRegistrationListener) {
        this.listeners.remove(cioRegistrationListener);
    }
}

