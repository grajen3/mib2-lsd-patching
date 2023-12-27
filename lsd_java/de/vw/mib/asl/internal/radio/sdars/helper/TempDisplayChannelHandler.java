/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.sdars.StationInfo;

final class TempDisplayChannelHandler
implements IAslPoolListener {
    private final SatDb mDb;
    private final IAslPool mPool;
    private StationInfo mChannel = null;
    private int mIndexOfPresetActivated = -1;

    public TempDisplayChannelHandler(SatDb satDb, IAslPool iAslPool) {
        this.mDb = satDb;
        this.mPool = iAslPool;
        this.mPool.setObject(71, this);
        this.mPool.addListener(72, (IAslPoolListener)this);
        this.mPool.addListener(74, (IAslPoolListener)this);
        this.mPool.addListener(73, (IAslPoolListener)this);
        this.mPool.addListener(22, (IAslPoolListener)this);
        this.mPool.addListener(23, (IAslPoolListener)this);
    }

    private void reset() {
        AbstractTarget abstractTarget = (AbstractTarget)this.mPool.getObject(62);
        if (abstractTarget != null) {
            abstractTarget.stopTimer(-1316617984);
        }
        this.mChannel = null;
        this.mIndexOfPresetActivated = -1;
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 72: {
                this.mChannel = iAslPoolRecord.getChannel();
                if (this.mChannel == null) break;
                this.mIndexOfPresetActivated = iAslPool.getInt(156);
                StationInfo stationInfo = iAslPool.getChannel(15);
                if (stationInfo.getSID() == this.mChannel.getSID()) {
                    iAslPool.notifyUpdate(15);
                } else {
                    iAslPool.setChannel(15, this.mChannel);
                }
                AbstractTarget abstractTarget = (AbstractTarget)iAslPool.getObject(62);
                if (abstractTarget == null) break;
                int n2 = abstractTarget.getTargetId();
                abstractTarget.getTimerServer().restartOrStartTimedEvent(n2, -1316617984, 0, false);
                break;
            }
            case 73: {
                this.reset();
                break;
            }
            case 74: {
                AbstractTarget abstractTarget;
                if (this.mChannel == null) break;
                StationInfo stationInfo = iAslPool.getChannel(23);
                if (null != stationInfo) {
                    boolean bl = this.mDb.getChannels().isInvalid(stationInfo.sID);
                    if (bl || stationInfo.subscription != 2) {
                        stationInfo = iAslPool.getChannel(21);
                        bl = this.mDb.getChannels().isInvalid(stationInfo.sID);
                    }
                    if (bl || stationInfo.subscription != 2) {
                        ServiceManager.logger.info(512).append("TempDisplayChannelHandler - notifyUpdate() - Subscription:").append(stationInfo.subscription).log();
                        stationInfo = SatConfig.DEFAULT_CHANNEL;
                    }
                }
                iAslPool.setChannel(15, stationInfo);
                iAslPool.setChannel(23, stationInfo);
                this.mPool.setInt(34, 0);
                this.mPool.setInt(81, 0);
                if (this.mIndexOfPresetActivated >= 0) {
                    this.mDb.getPresetApi().setIndex(this.mIndexOfPresetActivated);
                }
                if ((abstractTarget = (AbstractTarget)iAslPool.getObject(62)) != null) {
                    abstractTarget.stopTimer(-1316617984);
                }
                this.mChannel = null;
                break;
            }
            case 22: 
            case 23: {
                if (this.mChannel == null) break;
                this.reset();
                break;
            }
        }
    }
}

