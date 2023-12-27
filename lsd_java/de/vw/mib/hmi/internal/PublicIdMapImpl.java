/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.internal;

import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.datapool.ASLDatapoolIdMap;
import de.vw.mib.event.SystemEventIdMap;
import de.vw.mib.hmi.HmiEventIdMap;
import de.vw.mib.hmi.internal.PublicIdsResDataAccess;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.PerfectSlotHash;
import de.vw.mib.hmi.utils.ResData;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.io.File;

public class PublicIdMapImpl
implements ASLDatapoolIdMap,
HmiEventIdMap,
SystemEventIdMap {
    private final Logger logger;
    private final PerfectSlotHash aslDatapoolSlotHash;
    private final int[] aslDatapoolTargetIds;
    private final IntIntMap aslDatapoolFallback;
    private int aslDatapoolFreeId = Math.max(-193, 11243585);
    private final PerfectSlotHash eventSlotHash;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$hmi$internal$PublicIdMapImpl;

    public PublicIdMapImpl() {
        this.logger = ServiceManagerCommon.loggerFactory.getLogger(8);
        PublicIdsResDataAccess publicIdsResDataAccess = this.loadData();
        this.aslDatapoolSlotHash = publicIdsResDataAccess.newAslDatapoolIds_slothash();
        this.aslDatapoolTargetIds = publicIdsResDataAccess.getAslDatapoolIds_TargetId();
        this.aslDatapoolFallback = new IntIntOptHashMap();
        this.eventSlotHash = PerfectSlotHash.newSlotHash(publicIdsResDataAccess.getEventIds_PublicId(), publicIdsResDataAccess.getEventIds_Data());
        if (!$assertionsDisabled && publicIdsResDataAccess.getEventIds_PublicId().length > Short.MAX_VALUE) {
            throw new AssertionError((Object)"slot fits in short");
        }
    }

    protected PublicIdsResDataAccess loadData() {
        File file = ResData.getResFile(ServiceManagerCommon.configurationManager, "asldatapool.res");
        Object[] objectArray = ResData.loadAndCheck(ServiceManagerCommon.fileManager, file, MagicNumber.PUBLICIDS_RES, 0, 325596857, this.logger, 1);
        return new PublicIdsResDataAccess(objectArray);
    }

    @Override
    public int getPropertyId(int n) {
        int n2 = this.aslDatapoolSlotHash.getSlot(n);
        if (n2 >= 0) {
            return this.aslDatapoolTargetIds[n2];
        }
        int n3 = this.aslDatapoolFallback.get(n);
        if (n3 == 0) {
            n3 = this.aslDatapoolFreeId++;
            this.aslDatapoolFallback.put(n, n3);
            if (this.logger.isTraceEnabled(4)) {
                LogMessage logMessage = this.logger.trace(4);
                logMessage.append("Map unknown ASL getter ID ").append(n).append(" to property ID ").append(n3).append(".");
                logMessage.log();
            }
        }
        return n3;
    }

    @Override
    public short getCompactEventId(int n) {
        int n2 = this.eventSlotHash.getSlot(n);
        return (short)n2;
    }

    @Override
    public int getInternalSystemEventId(int n) {
        int n2 = this.eventSlotHash.getSlot(n);
        return n2 >= 0 ? n : -1;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$hmi$internal$PublicIdMapImpl == null ? (class$de$vw$mib$hmi$internal$PublicIdMapImpl = PublicIdMapImpl.class$("de.vw.mib.hmi.internal.PublicIdMapImpl")) : class$de$vw$mib$hmi$internal$PublicIdMapImpl).desiredAssertionStatus();
    }
}

