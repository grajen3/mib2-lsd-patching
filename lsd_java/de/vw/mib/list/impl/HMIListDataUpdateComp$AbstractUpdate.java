/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list.impl;

import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListObserver;
import de.vw.mib.list.HMIListPooledEntity;

abstract class HMIListDataUpdateComp$AbstractUpdate
implements HMIListPooledEntity {
    static final int CLEAR_TYPE;
    static final int REFRESH_TYPE;
    static final int SETCONTENT_TYPE;
    static final int SETFOCUS_TYPE;
    static final int SETSIZE_TYPE;
    static final int SETSTATE_TYPE;
    static final int SETSTRINGINDEX_TYPE;
    static final int UPDATE_TYPE;

    HMIListDataUpdateComp$AbstractUpdate() {
    }

    abstract int getType() {
    }

    abstract void acceptManipulator(HMIListDataManipulator hMIListDataManipulator) {
    }

    abstract void acceptObserver(HMIListObserver hMIListObserver) {
    }
}

