/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatModelApi;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekApi;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekModel;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.Iterator;
import org.dsi.ifc.sdars.SeekEntry;

final class SatSeekEntries {
    private final SatDb mDb;
    private final SatSeekModel mModel;
    private IntObjectMap mSeekEntries;
    private final IAslPool mPool;

    SatSeekEntries(SatDb satDb, SatSeekModel satSeekModel) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mModel = satSeekModel;
        this.mSeekEntries = new IntObjectOptHashMap(10);
    }

    void updateSeekListToHmi() {
        Object object;
        int n = this.mSeekEntries.size();
        SeekEntry[] seekEntryArray = new SeekEntry[n];
        int n2 = 0;
        if (n > 0) {
            object = this.mSeekEntries.values().iterator();
            while (object.hasNext()) {
                seekEntryArray[n2] = (SeekEntry)object.next();
                ++n2;
            }
        }
        object = this.mDb.getModelApi();
        if (this.mSeekEntries.isEmpty()) {
            ((SatModelApi)object).updateAlertList(null);
            this.mPool.setBoolean(174, false);
            this.mPool.setBoolean(190, false);
        }
    }

    void deleteAllSeekEntries() {
        Object object;
        Iterator iterator = this.mSeekEntries.values().iterator();
        while (iterator.hasNext()) {
            object = (SeekEntry)iterator.next();
            this.mModel.getSeekProxy().manageSeek(((SeekEntry)object).getSeekID(), 3);
        }
        this.mSeekEntries.clear();
        object = this.mDb.getModelApi();
        ((SatModelApi)object).updateManageAlertList(null);
        ((SatModelApi)object).updateAlertList(null);
        this.mPool.setBoolean(174, false);
        this.mPool.setBoolean(190, false);
        SatSeekApi.setSeekDeletePressed(true);
    }

    SeekEntry getBySeekID(int n) {
        return (SeekEntry)this.mSeekEntries.get(n);
    }

    void deleteSeekEntryByUser(int n) {
        SeekEntry[] seekEntryArray = (SeekEntry[])this.mPool.getObjectArray(102);
        SeekEntry seekEntry = seekEntryArray[n];
        int n2 = seekEntry.getSeekID();
        Iterator iterator = this.mSeekEntries.values().iterator();
        while (iterator.hasNext()) {
            SeekEntry seekEntry2 = (SeekEntry)iterator.next();
            if (n2 != seekEntry2.getSeekID()) continue;
            this.mModel.getSeekProxy().manageSeek(seekEntry2.getSeekID(), 3);
            iterator.remove();
            break;
        }
        this.updateSeekListToHmi();
        SatSeekApi.setSeekDeletePressed(true);
    }

    void updateSeekList(SeekEntry[] seekEntryArray) {
        this.mDb.getLogHandler().logSeekList(seekEntryArray);
        this.mSeekEntries.clear();
        for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
            if (seekEntryArray[i2] == null) continue;
            this.mSeekEntries.put(seekEntryArray[i2].getSeekID(), seekEntryArray[i2]);
        }
        if (seekEntryArray.length != 0) {
            this.mPool.setBoolean(174, true);
        } else {
            this.mPool.setBoolean(174, false);
        }
        SatModelApi satModelApi = this.mDb.getModelApi();
        satModelApi.updateManageAlertList(seekEntryArray);
        this.mPool.setObjectArray(102, seekEntryArray);
    }
}

