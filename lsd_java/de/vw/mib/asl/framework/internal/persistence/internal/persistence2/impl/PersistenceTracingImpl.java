/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceTracing;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;

public class PersistenceTracingImpl
implements PersistenceTracing {
    private final ObjectObjectMap mapListener2Name = new ObjectObjectOptHashMap();

    @Override
    public String retrieveName(ProfileChangeListener profileChangeListener) {
        if (profileChangeListener == null) {
            return "<NULL>";
        }
        if (!this.mapListener2Name.containsKey(profileChangeListener)) {
            return "<UNKNOWN>";
        }
        return (String)this.mapListener2Name.get(profileChangeListener);
    }

    @Override
    public void registerListener(ProfileChangeListener profileChangeListener, String string) {
        this.mapListener2Name.put(profileChangeListener, string);
    }
}

