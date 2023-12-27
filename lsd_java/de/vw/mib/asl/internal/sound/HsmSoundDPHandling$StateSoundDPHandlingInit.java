/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.ASLSoundData;
import de.vw.mib.asl.internal.sound.HsmSoundDPHandling;
import de.vw.mib.asl.internal.sound.SoundUtil;
import de.vw.mib.asl.internal.sound.transformer.SoundEqualizerBandCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.sound.ASLSoundPropertyManager;
import org.dsi.ifc.base.DSIListener;

public class HsmSoundDPHandling$StateSoundDPHandlingInit
extends AbstractHsmState {
    private HsmSoundDPHandling target;
    private final /* synthetic */ HsmSoundDPHandling this$0;

    public HsmSoundDPHandling$StateSoundDPHandlingInit(HsmSoundDPHandling hsmSoundDPHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundDPHandling;
        super(hsm, string, hsmState);
        this.target = this.this$0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.initDSI();
                this.target.dsiAudioManagement.setNotification(1, (DSIListener)this.target.dsiAudioManagementListener);
                this.writeSoundDefaultDPValues();
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.target.getTargetId(), -1585053440);
                break;
            }
            case 100001: {
                if (eventGeneric.getResult() != 0 || eventGeneric.getInt(2) != -687821311 || eventGeneric.getLong(3) != 1L) break;
                ASLSoundData.mCodingData = (Coding)eventGeneric.getObject(1);
                int n = ASLSoundData.mCodingData.getValue(49);
                this.this$0.info().append("Sound received coding data. Sound System: ").append(n).log();
                AbstractASLHsmTarget.writeBooleanToDatapool(1537088256, n == 4);
                ASLSoundData.arkamysAvailable = SoundUtil.isSkoda() && n == 4;
                AbstractASLHsmTarget.writeBooleanToDatapool(1839078144, ASLSoundData.arkamysAvailable);
                AbstractASLHsmTarget.writeBooleanToDatapool(1771969280, ASLSoundData.arkamysAvailable);
                this.this$0.checkDynAudioFunctionsAvailable();
                this.this$0.checkAllBrandAndAmpDependingFunctions();
                break;
            }
            case 4: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAudioManagementUpdateAMAvailable(int n, int n2, int n3) {
        if (n == 3) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1469, 0);
            if (!this.target.getHsm().isActive(this.this$0.stateHandling)) {
                this.trans(this.this$0.stateHandling);
            }
        } else {
            AbstractASLHsmTarget.writeIntegerToDatapool(1469, 1);
            AbstractASLHsmTarget.writeBooleanToDatapool(4138, false);
            this.this$0.activeEntConnection = -1;
            this.this$0.activeConnection = -1;
        }
    }

    private void writeSoundDefaultDPValues() {
        AbstractASLHsmTarget.writeIntegerToDatapool(1469, 1);
        AbstractASLHsmTarget.writeBooleanToDatapool(4138, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(3629, false);
        AbstractASLHsmTarget.writeFlagVectorToDatapool(1513, ASLSoundPropertyManager.TM_BOR_MANUAL_EQ_AVAILABLE_NEW__DEFAULT_VALUE);
        AbstractASLHsmTarget.writeBooleanToDatapool(1504, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(1506, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(1511, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(1505, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(1512, false);
        AbstractASLHsmTarget.writeIntegerToDatapool(1484, 0);
        AbstractASLHsmTarget.writeIntegerToDatapool(2789, 0);
        AbstractASLHsmTarget.writeIntegerToDatapool(2672, 0);
        AbstractASLHsmTarget.writeBooleanToDatapool(1587419904, true);
        Object[] objectArray = new SoundEqualizerBandCollector[5];
        for (int i2 = 0; i2 < 5; ++i2) {
            objectArray[i2] = new SoundEqualizerBandCollector(0, 0);
        }
        ListManager.getGenericASLList(1536).updateList(objectArray);
        AbstractASLHsmTarget.writeBooleanToDatapool(-2137122048, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(-2103567616, false);
    }
}

