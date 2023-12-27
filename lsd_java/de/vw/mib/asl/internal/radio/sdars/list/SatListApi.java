/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.list;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.list.SatListModel;

public final class SatListApi {
    private final SatDb mDb;
    private SatListModel mModel;

    public SatListApi(SatDb satDb) {
        this.mDb = satDb;
    }

    public void updateCategoryList() {
        this.trigger(1770455296);
    }

    public boolean isShown() {
        if (this.mModel != null) {
            return this.mModel.isShown();
        }
        return false;
    }

    public void startModule() {
        if (this.mModel == null) {
            this.mModel = new SatListModel(this.mDb);
        }
    }

    private void trigger(int n) {
        if (this.mModel != null) {
            this.mModel.trigger(n);
        }
    }

    public SatListModel getSatListModel() {
        return this.mModel;
    }
}

