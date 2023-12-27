/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.sound.transformer.SoundEQRoomSettingsBoolTransformer;
import de.vw.mib.asl.internal.sound.transformer.SoundEQRoomSettingsTransformer;
import de.vw.mib.asl.internal.sound.transformer.SoundEQSettingsBoolTransformer;
import de.vw.mib.asl.internal.sound.transformer.SoundEQSettingsTransformer;
import de.vw.mib.asl.internal.sound.transformer.SoundEqualizerBandTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundBalanceFaderCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundBalanceFaderTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsBalanceLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsBalanceLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsBassLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsBassLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsCantonSurroundLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsCantonSurroundLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsFaderLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsFaderLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsGALALimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsGALALimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsMiddleLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsMiddleLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsSubwooferLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsSubwooferLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsTrebleLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsTrebleLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeAuxLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeAuxLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeBluetoothLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeBluetoothLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeEntertainmentLimitsCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeEntertainmentLimitsTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeEntertainmentLoweringLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeEntertainmentLoweringLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeICCLimitsCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeICCLimitsTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeNavEntLowLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeNavEntLowLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeNaviLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeNaviLimitPopupCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeNaviLimitPopupTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeNaviLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeOnVolumeSetupiLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeOnVolumeSetupiLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumePhoneLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumePhoneLimitPopupCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumePhoneLimitPopupTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumePhoneLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeRingtoneLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeRingtoneLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeSDSLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeSDSLimitPopupCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeSDSLimitPopupTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeSDSLimitTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeTALimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeTALimitPopupCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeTALimitPopupTransformer;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeTALimitTransformer;

public final class ASLSoundDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSoundDeviceImpl INSTANCE = new ASLSoundDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(30);
    private ASLListFactory listFactory;

    private ASLSoundDeviceImpl() {
    }

    public static ASLSoundDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Sound";
    }

    @Override
    public int getTargetId() {
        return 10106;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3529, this);
        aSLListRegistry.registerASLDevice(1514, this);
        aSLListRegistry.registerASLDevice(1515, this);
        aSLListRegistry.registerASLDevice(1516, this);
        aSLListRegistry.registerASLDevice(1517, this);
        aSLListRegistry.registerASLDevice(1518, this);
        aSLListRegistry.registerASLDevice(1519, this);
        aSLListRegistry.registerASLDevice(1520, this);
        aSLListRegistry.registerASLDevice(1521, this);
        aSLListRegistry.registerASLDevice(1522, this);
        aSLListRegistry.registerASLDevice(1523, this);
        aSLListRegistry.registerASLDevice(1524, this);
        aSLListRegistry.registerASLDevice(1525, this);
        aSLListRegistry.registerASLDevice(1526, this);
        aSLListRegistry.registerASLDevice(1527, this);
        aSLListRegistry.registerASLDevice(1528, this);
        aSLListRegistry.registerASLDevice(1529, this);
        aSLListRegistry.registerASLDevice(1530, this);
        aSLListRegistry.registerASLDevice(1939741440, this);
        aSLListRegistry.registerASLDevice(1531, this);
        aSLListRegistry.registerASLDevice(1532, this);
        aSLListRegistry.registerASLDevice(1533, this);
        aSLListRegistry.registerASLDevice(1534, this);
        aSLListRegistry.registerASLDevice(1535, this);
        aSLListRegistry.registerASLDevice(2006850304, this);
        aSLListRegistry.registerASLDevice(1536, this);
        aSLListRegistry.registerASLDevice(1475, this);
        aSLListRegistry.registerASLDevice(1476, this);
        aSLListRegistry.registerASLDevice(1477, this);
        aSLListRegistry.registerASLDevice(1478, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1282874176, 10106);
        serviceRegister.registerService(-368836544, 10106);
        serviceRegister.registerService(1098324800, 10106);
        serviceRegister.registerService(1182210880, 10106);
        serviceRegister.registerService(1266096960, 10106);
        serviceRegister.registerService(-352059328, 10106);
        serviceRegister.registerService(-335282112, 10106);
        serviceRegister.registerService(-318504896, 10106);
        serviceRegister.registerService(-301727680, 10106);
        serviceRegister.registerService(-284950464, 10106);
        serviceRegister.registerService(1249319744, 10106);
        serviceRegister.registerService(1577648192, 10106);
        serviceRegister.registerService(1594425408, 10106);
        serviceRegister.registerService(1081547584, 10106);
        serviceRegister.registerService(1131879232, 10106);
        serviceRegister.registerService(1148656448, 10106);
        serviceRegister.registerService(1165433664, 10106);
        serviceRegister.registerService(-268173248, 10106);
        serviceRegister.registerService(-251396032, 10106);
        serviceRegister.registerService(-234618816, 10106);
        serviceRegister.registerService(-217841600, 10106);
        serviceRegister.registerService(-201064384, 10106);
        serviceRegister.registerService(-184287168, 10106);
        serviceRegister.registerService(-435748800, 10106);
        serviceRegister.registerService(-167509952, 10106);
        serviceRegister.registerService(-150732736, 10106);
        serviceRegister.registerService(-133955520, 10106);
        serviceRegister.registerService(-117178304, 10106);
        serviceRegister.registerService(-100401088, 10106);
        serviceRegister.registerService(-83623872, 10106);
        serviceRegister.registerService(327744, 10106);
        serviceRegister.registerService(-66846656, 10106);
        serviceRegister.registerService(-16515008, 10106);
        serviceRegister.registerService(1443364928, 10106);
        serviceRegister.registerService(-50069440, 10106);
        serviceRegister.registerService(17104960, 10106);
        serviceRegister.registerService(33882176, 10106);
        serviceRegister.registerService(1299651392, 10106);
        serviceRegister.registerService(-33292224, 10106);
        serviceRegister.registerService(1611202624, 10106);
        serviceRegister.registerService(1258946624, 10106);
        serviceRegister.registerService(1711931456, 10106);
        serviceRegister.registerService(1627979840, 10106);
        serviceRegister.registerService(50659392, 10106);
        serviceRegister.registerService(-586612672, 10106);
        serviceRegister.registerService(0x4050040, 10106);
        serviceRegister.registerService(0x5050040, 10106);
        serviceRegister.registerService(1198988096, 10106);
        serviceRegister.registerService(1215765312, 10106);
        serviceRegister.registerService(1232542528, 10106);
        serviceRegister.registerService(1316428608, 10106);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3529: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1514: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1515: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1516: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1517: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1518: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1519: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1520: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1521: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1522: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1523: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1524: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1525: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1526: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1527: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1528: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1529: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1530: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1810035: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1531: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1532: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1533: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1534: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1535: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1810039: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1536: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1475: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1476: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1477: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1478: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Sound: ").append(n).toString());
            }
        }
        return nArray;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.getGenericASLList(n);
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return ASLSoundDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSoundDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3529: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundBalanceFaderTransformer(), n, "Sound", "BalanceFader");
                genericASLList.updateList(new SoundBalanceFaderCollector[]{new SoundBalanceFaderCollector()});
                break;
            }
            case 1514: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundToneSettingsBalanceLimitTransformer(), n, "Sound", "ToneSettingsBalanceLimit");
                genericASLList.updateList(new SoundToneSettingsBalanceLimitCollector[]{new SoundToneSettingsBalanceLimitCollector()});
                break;
            }
            case 1515: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundToneSettingsCantonSurroundLimitTransformer(), n, "Sound", "ToneSettingsCantonSurroundLimit");
                genericASLList.updateList(new SoundToneSettingsCantonSurroundLimitCollector[]{new SoundToneSettingsCantonSurroundLimitCollector()});
                break;
            }
            case 1516: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundToneSettingsBassLimitTransformer(), n, "Sound", "ToneSettingsBassLimit");
                genericASLList.updateList(new SoundToneSettingsBassLimitCollector[]{new SoundToneSettingsBassLimitCollector()});
                break;
            }
            case 1517: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundToneSettingsFaderLimitTransformer(), n, "Sound", "ToneSettingsFaderLimit");
                genericASLList.updateList(new SoundToneSettingsFaderLimitCollector[]{new SoundToneSettingsFaderLimitCollector()});
                break;
            }
            case 1518: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundToneSettingsGALALimitTransformer(), n, "Sound", "ToneSettingsGALALimit");
                genericASLList.updateList(new SoundToneSettingsGALALimitCollector[]{new SoundToneSettingsGALALimitCollector()});
                break;
            }
            case 1519: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundToneSettingsMiddleLimitTransformer(), n, "Sound", "ToneSettingsMiddleLimit");
                genericASLList.updateList(new SoundToneSettingsMiddleLimitCollector[]{new SoundToneSettingsMiddleLimitCollector()});
                break;
            }
            case 1520: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundToneSettingsSubwooferLimitTransformer(), n, "Sound", "ToneSettingsSubwooferLimit");
                genericASLList.updateList(new SoundToneSettingsSubwooferLimitCollector[]{new SoundToneSettingsSubwooferLimitCollector()});
                break;
            }
            case 1521: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundToneSettingsTrebleLimitTransformer(), n, "Sound", "ToneSettingsTrebleLimit");
                genericASLList.updateList(new SoundToneSettingsTrebleLimitCollector[]{new SoundToneSettingsTrebleLimitCollector()});
                break;
            }
            case 1522: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeEntertainmentLimitsTransformer(), n, "Sound", "VolumeEntertainmentLimits");
                genericASLList.updateList(new SoundVolumeEntertainmentLimitsCollector[]{new SoundVolumeEntertainmentLimitsCollector()});
                break;
            }
            case 1523: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeEntertainmentLoweringLimitTransformer(), n, "Sound", "VolumeEntertainmentLoweringLimit");
                genericASLList.updateList(new SoundVolumeEntertainmentLoweringLimitCollector[]{new SoundVolumeEntertainmentLoweringLimitCollector()});
                break;
            }
            case 1524: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeNaviLimitTransformer(), n, "Sound", "VolumeNaviLimit");
                genericASLList.updateList(new SoundVolumeNaviLimitCollector[]{new SoundVolumeNaviLimitCollector()});
                break;
            }
            case 1525: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeNaviLimitPopupTransformer(), n, "Sound", "VolumeNaviLimitPopup");
                genericASLList.updateList(new SoundVolumeNaviLimitPopupCollector[]{new SoundVolumeNaviLimitPopupCollector()});
                break;
            }
            case 1526: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeOnVolumeSetupiLimitTransformer(), n, "Sound", "VolumeOnVolumeSetupiLimit");
                genericASLList.updateList(new SoundVolumeOnVolumeSetupiLimitCollector[]{new SoundVolumeOnVolumeSetupiLimitCollector()});
                break;
            }
            case 1527: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumePhoneLimitTransformer(), n, "Sound", "VolumePhoneLimit");
                genericASLList.updateList(new SoundVolumePhoneLimitCollector[]{new SoundVolumePhoneLimitCollector()});
                break;
            }
            case 1528: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumePhoneLimitPopupTransformer(), n, "Sound", "VolumePhoneLimitPopup");
                genericASLList.updateList(new SoundVolumePhoneLimitPopupCollector[]{new SoundVolumePhoneLimitPopupCollector()});
                break;
            }
            case 1529: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeRingtoneLimitTransformer(), n, "Sound", "VolumeRingtoneLimit");
                genericASLList.updateList(new SoundVolumeRingtoneLimitCollector[]{new SoundVolumeRingtoneLimitCollector()});
                break;
            }
            case 1530: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeSDSLimitTransformer(), n, "Sound", "VolumeSDSLimit");
                genericASLList.updateList(new SoundVolumeSDSLimitCollector[]{new SoundVolumeSDSLimitCollector()});
                break;
            }
            case 1810035: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeNavEntLowLimitTransformer(), n, "Sound", "VolumeNavEntLowLimit");
                genericASLList.updateList(new SoundVolumeNavEntLowLimitCollector[]{new SoundVolumeNavEntLowLimitCollector()});
                break;
            }
            case 1531: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeSDSLimitPopupTransformer(), n, "Sound", "VolumeSDSLimitPopup");
                genericASLList.updateList(new SoundVolumeSDSLimitPopupCollector[]{new SoundVolumeSDSLimitPopupCollector()});
                break;
            }
            case 1532: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeTALimitTransformer(), n, "Sound", "VolumeTALimit");
                genericASLList.updateList(new SoundVolumeTALimitCollector[]{new SoundVolumeTALimitCollector()});
                break;
            }
            case 1533: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeTALimitPopupTransformer(), n, "Sound", "VolumeTALimitPopup");
                genericASLList.updateList(new SoundVolumeTALimitPopupCollector[]{new SoundVolumeTALimitPopupCollector()});
                break;
            }
            case 1534: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeAuxLimitTransformer(), n, "Sound", "VolumeAuxLimit");
                genericASLList.updateList(new SoundVolumeAuxLimitCollector[]{new SoundVolumeAuxLimitCollector()});
                break;
            }
            case 1535: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeBluetoothLimitTransformer(), n, "Sound", "VolumeBluetoothLimit");
                genericASLList.updateList(new SoundVolumeBluetoothLimitCollector[]{new SoundVolumeBluetoothLimitCollector()});
                break;
            }
            case 1810039: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundVolumeICCLimitsTransformer(), n, "Sound", "VolumeICCLimits");
                genericASLList.updateList(new SoundVolumeICCLimitsCollector[]{new SoundVolumeICCLimitsCollector()});
                break;
            }
            case 1536: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundEqualizerBandTransformer(), n, "Sound", "EqualizerBand");
                break;
            }
            case 1475: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundEQRoomSettingsTransformer(), n, "Sound", "EQRoomSettings");
                break;
            }
            case 1476: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundEQRoomSettingsBoolTransformer(), n, "Sound", "EQRoomSettingsBool");
                break;
            }
            case 1477: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundEQSettingsTransformer(), n, "Sound", "EQSettings");
                break;
            }
            case 1478: {
                genericASLList = aSLListFactory.createGenericASLList(new SoundEQSettingsBoolTransformer(), n, "Sound", "EQSettingsBool");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Sound: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

