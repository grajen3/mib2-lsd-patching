/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.database.AslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;

public final class SubscriptionHandler
implements IAslPoolListener {
    private final SatDb mDb;

    public SubscriptionHandler(SatDb satDb) {
        this.mDb = satDb;
        AslPool aslPool = this.mDb.getPool();
        aslPool.addListener(2, (IAslPoolListener)this);
        aslPool.addListener(38, (IAslPoolListener)this);
        aslPool.addListener(55, (IAslPoolListener)this);
        aslPool.addListener(10, (IAslPoolListener)this);
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 2: {
                int n2 = iAslPoolRecord.getInt();
                if (n2 == 1) {
                    iAslPool.setInt(172, 0);
                    break;
                }
                iAslPool.setInt(172, 1);
                break;
            }
            case 38: {
                boolean bl = iAslPoolRecord.getBoolean();
                if (!bl || !iAslPool.getBoolean(55)) break;
                this.mDb.sendHmiEvent(212);
                iAslPool.setBoolean(55, false);
                break;
            }
            case 55: {
                boolean bl;
                boolean bl2 = iAslPoolRecord.getBoolean();
                if (!bl2 || !(bl = iAslPool.getBoolean(38))) break;
                this.mDb.sendHmiEvent(212);
                iAslPool.setBoolean(55, false);
                break;
            }
            case 10: {
                int n3 = iAslPoolRecord.getInt();
                if (n3 != 1) break;
                iAslPool.setBoolean(55, true);
                break;
            }
        }
    }
}

