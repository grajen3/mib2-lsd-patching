/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListPooledEntity;
import de.vw.mib.list.HMIListRefCountEntity;

public interface HMIListDataUpdate
extends HMIListPooledEntity,
HMIListRefCountEntity {
    default public void acceptManipulator(HMIListDataManipulator hMIListDataManipulator) {
    }

    default public void acceptObserver(HMIListObserver hMIListObserver) {
    }

    default public HMIListDataUpdate merge(HMIListDataUpdate hMIListDataUpdate) {
    }
}

