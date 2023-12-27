/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.sound;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.HMIRelevantASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import java.util.List;

public class SoundASLDataAdapter
extends HMIRelevantASLDataPoolAdapter
implements SoundService {
    private APIFactoryInterface apiFactory;
    private static final int[] SOUND_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{1496, 1472, 1493, 1503, 1500, 1502, 1470, 1509, 1469};
    private static final int[] SOUND_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{1525, 1522, 1533, 1528, 1531};
    private static final int[] SOUND_HMI_EVENT_IDS_TO_LISTEN_TO = new int[]{232};
    private int volumeNaviMin = 0;
    private int volumeNaviMax = 0;
    private int volumeEntertainmentMax = 0;
    private int volumeTAMin = 0;
    private int volumeTAMax = 0;
    private int volumePhoneMin = 0;
    private int volumePhoneMax = 0;
    private int volumeSDSMin = 0;
    private int volumeSDSMax = 0;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$sound$SoundService;

    public SoundASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.apiFactory.getHMIEventService().addHMIEventListener(this, SOUND_HMI_EVENT_IDS_TO_LISTEN_TO);
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$sound$SoundService == null ? (class$de$vw$mib$bap$mqbab2$common$api$sound$SoundService = SoundASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.sound.SoundService")) : class$de$vw$mib$bap$mqbab2$common$api$sound$SoundService;
    }

    @Override
    public final int getVolumeNavi() {
        return this.getDataPool().getInteger(1496, 0);
    }

    @Override
    public final int getVolumeNaviMin() {
        return SoundASLDataAdapter.getIntegerListValue(1524, 0);
    }

    @Override
    public int getVolumeNaviMax() {
        return SoundASLDataAdapter.getIntegerListValue(1524, 1);
    }

    @Override
    public final int getVolumeNaviMinPopup() {
        return SoundASLDataAdapter.getIntegerListValue(1525, 0);
    }

    @Override
    public int getVolumeNaviMaxPopup() {
        return SoundASLDataAdapter.getIntegerListValue(1525, 1);
    }

    @Override
    public int getCurrentDdsVolumeFocus() {
        return this.getDataPool().getInteger(1472, 0);
    }

    @Override
    public int getVolumeEntertainment() {
        return this.getDataPool().getInteger(1493, 0);
    }

    @Override
    public int getVolumeEntertainmentMax() {
        return SoundASLDataAdapter.getIntegerListValue(1522, 0);
    }

    @Override
    public int getVolumeTA() {
        return this.getDataPool().getInteger(1503, 0);
    }

    @Override
    public int getVolumeTAMin() {
        return SoundASLDataAdapter.getIntegerListValue(1533, 0);
    }

    @Override
    public int getVolumeTAMax() {
        return SoundASLDataAdapter.getIntegerListValue(1533, 1);
    }

    @Override
    public int getVolumePhone() {
        return this.getDataPool().getInteger(1500, 0);
    }

    @Override
    public int getVolumePhoneMin() {
        return SoundASLDataAdapter.getIntegerListValue(1528, 0);
    }

    @Override
    public int getVolumePhoneMax() {
        return SoundASLDataAdapter.getIntegerListValue(1528, 1);
    }

    @Override
    public int getVolumeSDS() {
        return this.getDataPool().getInteger(1502, 0);
    }

    @Override
    public int getVolumeSDSMin() {
        return SoundASLDataAdapter.getIntegerListValue(1531, 1);
    }

    @Override
    public int getVolumeSDSMax() {
        return SoundASLDataAdapter.getIntegerListValue(1531, 0);
    }

    @Override
    public int getCurrentAudioComponent() {
        return this.getDataPool().getInteger(1470, 0);
    }

    @Override
    public int getMuteActive() {
        return this.getDataPool().getInteger(1509, 0);
    }

    @Override
    public int getCurrentAmplifierState() {
        return this.getDataPool().getInteger(1469, 0);
    }

    @Override
    public void setSoundVolume(int n, int n2) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(0x4050040, eventGeneric);
    }

    @Override
    public void setMuteState() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-100401088);
    }

    @Override
    public void setCurrentAudioComponent(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-284950464, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(0);
    }

    @Override
    public void activateRadioSource() {
        this.setCurrentAudioComponent(1);
    }

    @Override
    public void activateMediaSource() {
        this.setCurrentAudioComponent(2);
    }

    @Override
    public void activateTvSource() {
        this.setCurrentAudioComponent(5);
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                SoundServiceListener soundServiceListener = (SoundServiceListener)iterator.next();
                soundServiceListener.updateSoundData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return SOUND_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return SOUND_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        boolean bl;
        switch (n) {
            case 1524: {
                int n2 = this.getVolumeNaviMinPopup();
                if (this.volumeNaviMin != n2) {
                    this.volumeNaviMin = n2;
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 1525: {
                int n3 = this.getVolumeNaviMaxPopup();
                if (this.volumeNaviMax != n3) {
                    this.volumeNaviMax = n3;
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 1522: {
                int n4 = this.getVolumeEntertainmentMax();
                if (this.volumeEntertainmentMax != n4) {
                    this.volumeEntertainmentMax = n4;
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 1533: {
                int n5 = this.getVolumeTAMin();
                int n6 = this.getVolumeTAMax();
                if (this.volumeTAMin != n5 || this.volumeTAMax != n6) {
                    this.volumeTAMin = n5;
                    this.volumeTAMax = n6;
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 1528: {
                int n7 = this.getVolumePhoneMax();
                int n8 = this.getVolumePhoneMin();
                if (this.volumePhoneMin != n8 || this.volumePhoneMax != n7) {
                    this.volumePhoneMin = n8;
                    this.volumePhoneMax = n7;
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            case 1530: {
                int n9 = this.getVolumeSDSMax();
                int n10 = this.getVolumeSDSMin();
                if (this.volumeSDSMin != n10 || this.volumeSDSMax != n9) {
                    this.volumeSDSMin = n10;
                    this.volumeSDSMax = n9;
                    bl = true;
                    break;
                }
                bl = false;
                break;
            }
            default: {
                bl = true;
            }
        }
        if (bl) {
            this._notifyServiceDelegates(n);
        }
    }

    @Override
    public void addSoundServiceListener(SoundServiceListener soundServiceListener, int[] nArray) {
        this.registerServiceListener((Object)soundServiceListener, nArray);
    }

    @Override
    public void removeSoundServiceListener(SoundServiceListener soundServiceListener, int[] nArray) {
        this.removeServiceListener(soundServiceListener, nArray);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

