/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.list;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.list.SatListModel;
import de.vw.mib.asl.internal.radio.sdars.list.SatListStateActive;
import de.vw.mib.asl.internal.radio.sdars.list.SatListStateInactive;
import de.vw.mib.asl.internal.radio.sdars.list.SatListStateSortingCategory;
import de.vw.mib.asl.internal.radio.sdars.list.SatListStateSortingName;
import de.vw.mib.asl.internal.radio.sdars.list.SatListStateSortingNumber;
import de.vw.mib.asl.internal.radio.sdars.list.SatListStateTop;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;

final class SatListTarget
extends TargetHsmImpl {
    private final SatDb mDb;
    private final SatListModel mModel;
    private final HsmState mStateTop;
    private final HsmState mStateInactive;
    private final HsmState mStateActive;
    private final HsmState mStateSortingCategory;
    private final HsmState mStateSortingNumber;
    private final HsmState mStateSortingName;

    SatListTarget(SatDb satDb, Target target, SatListModel satListModel) {
        this.mDb = satDb;
        this.mModel = satListModel;
        this.mStateTop = new SatListStateTop(this.mDb, this, null);
        this.mStateInactive = new SatListStateInactive(this.mDb, this, this.mStateTop);
        this.mStateActive = new SatListStateActive(this.mDb, this, this.mStateTop);
        this.mStateSortingCategory = new SatListStateSortingCategory(this.mDb, this, this.mStateActive);
        this.mStateSortingNumber = new SatListStateSortingNumber(this.mDb, this, this.mStateActive);
        this.mStateSortingName = new SatListStateSortingName(this.mDb, this, this.mStateActive);
        try {
            String string = target.getMainObject().getEventDispatcher().getTaskId(target.getTargetId());
            this.startHsmAndRegisterTarget(target.getMainObject(), ASLRadioTargetIds.ASL_SDARS_LIST_TARGET, string, this.mStateTop);
        }
        catch (Exception exception) {
            SatDb.getLogger().error(512, "COULD NOT START SDARS ListController.");
        }
    }

    void transStateActive() {
        this.hsm.trans(this.mStateActive);
    }

    void transStateInactive() {
        this.hsm.trans(this.mStateInactive);
    }

    void transStateSortingCategory() {
        this.hsm.trans(this.mStateSortingCategory);
    }

    void transStateSortingNumber() {
        this.hsm.trans(this.mStateSortingNumber);
    }

    void transStateSortingName() {
        this.hsm.trans(this.mStateSortingName);
    }

    boolean isShown() {
        return this.getHsm().isActive(this.mStateActive);
    }

    SatListModel getModel() {
        return this.mModel;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        SatDb.logEvent("List", eventGeneric);
        super.gotEvent(eventGeneric);
    }
}

