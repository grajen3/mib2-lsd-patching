/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.internal.system.keypanel.lock.components.AbstractLockStateComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.PersonalizationKeyLockComponent$1;

public class PersonalizationKeyLockComponent
extends AbstractLockStateComponent {
    public PersonalizationKeyLockComponent(AslPersistenceSyncApi aslPersistenceSyncApi) {
        aslPersistenceSyncApi.addGlobalProfileChangeListener(this.createGlobalProfileChangeListener());
    }

    @Override
    protected boolean checkIsKeyApplicable(int n, int n2) {
        return true;
    }

    private GlobalProfileChangeListener createGlobalProfileChangeListener() {
        return new PersonalizationKeyLockComponent$1(this);
    }
}

