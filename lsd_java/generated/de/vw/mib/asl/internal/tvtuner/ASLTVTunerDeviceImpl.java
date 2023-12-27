/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.tvtuner;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerAvailableAudioChannelTransformer;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerEWSMessageAreaCodesListNamesTransformer;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerEWSMessageAreaCodesListTransformer;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerPresetListTransformer;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerPresetStoreListTransformer;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerSetupAudioChannelListTransformer;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerSetupPresetDeletionListTransformer;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerSupportedTVNormIndicesTransformer;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerSupportedTVNormsTransformer;
import de.vw.mib.asl.internal.tvtuner.transformer.TVTunerTVStationListTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerCASInformationCollector;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerCASInformationTransformer;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerEWSMessageCollector;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerEWSMessageTransformer;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerKeyPanelListCollector;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerKeyPanelListTransformer;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerMessageServiceCollector;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerMessageServiceTransformer;

public final class ASLTVTunerDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLTVTunerDeviceImpl INSTANCE = new ASLTVTunerDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(15);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLTVTunerDeviceImpl() {
    }

    public static ASLTVTunerDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "TVTuner";
    }

    @Override
    public int getTargetId() {
        return 10115;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1119083008, this);
        aSLListRegistry.registerASLDevice(2525, this);
        aSLListRegistry.registerASLDevice(2710, this);
        aSLListRegistry.registerASLDevice(2935, this);
        aSLListRegistry.registerASLDevice(3306, this);
        aSLListRegistry.registerASLDevice(2715, this);
        aSLListRegistry.registerASLDevice(2749, this);
        aSLListRegistry.registerASLDevice(2922, this);
        aSLListRegistry.registerASLDevice(3231, this);
        aSLListRegistry.registerASLDevice(2398, this);
        aSLListRegistry.registerASLDevice(2415, this);
        aSLListRegistry.registerASLDevice(2816, this);
        aSLListRegistry.registerASLDevice(3249, this);
        aSLListRegistry.registerASLDevice(-1236523520, this);
        aSLListRegistry.registerASLDevice(-1135860224, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1057357888, 10115);
        serviceRegister.registerService(-1608178112, 10115);
        serviceRegister.registerService(1929838656, 10115);
        serviceRegister.registerService(2013724736, 10115);
        serviceRegister.registerService(2030501952, 10115);
        serviceRegister.registerService(-2130247616, 10115);
        serviceRegister.registerService(-2113470400, 10115);
        serviceRegister.registerService(-1979252672, 10115);
        serviceRegister.registerService(-1962475456, 10115);
        serviceRegister.registerService(-1643708352, 10115);
        serviceRegister.registerService(-1626931136, 10115);
        serviceRegister.registerService(-1610153920, 10115);
        serviceRegister.registerService(-1559822272, 10115);
        serviceRegister.registerService(-1073217472, 10115);
        serviceRegister.registerService(-1591400896, 10115);
        serviceRegister.registerService(-1056440256, 10115);
        serviceRegister.registerService(302514240, 10115);
        serviceRegister.registerService(-1526267840, 10115);
        serviceRegister.registerService(-1509490624, 10115);
        serviceRegister.registerService(201850944, 10115);
        serviceRegister.registerService(537395264, 10115);
        serviceRegister.registerService(1577582656, 10115);
        serviceRegister.registerService(1594359872, 10115);
        serviceRegister.registerService(1611137088, 10115);
        serviceRegister.registerService(1627914304, 10115);
        serviceRegister.registerService(1174995008, 10115);
        serviceRegister.registerService(17367104, 10115);
        serviceRegister.registerService(1678442560, 10115);
        serviceRegister.registerService(1644691520, 10115);
        serviceRegister.registerService(1661468736, 10115);
        serviceRegister.registerService(218628160, 10115);
        serviceRegister.registerService(-1358430144, 10115);
        serviceRegister.registerService(-1341652928, 10115);
        serviceRegister.registerService(-922222528, 10115);
        serviceRegister.registerService(84475968, 10115);
        serviceRegister.registerService(-1492713408, 10115);
        serviceRegister.registerService(-234422208, 10115);
        serviceRegister.registerService(554172480, 10115);
        serviceRegister.registerService(-66650048, 10115);
        serviceRegister.registerService(1560805440, 10115);
        serviceRegister.registerService(-83427264, 10115);
        serviceRegister.registerService(-452526016, 10115);
        serviceRegister.registerService(235405376, 10115);
        serviceRegister.registerService(-2012741568, 10115);
        serviceRegister.registerService(-1022885824, 10115);
        serviceRegister.registerService(-1995964352, 10115);
        serviceRegister.registerService(1678245952, 10115);
        serviceRegister.registerService(1695023168, 10115);
        serviceRegister.registerService(1711800384, 10115);
        serviceRegister.registerService(-351862720, 10115);
        serviceRegister.registerService(-620232640, 10115);
        serviceRegister.registerService(-586678208, 10115);
        serviceRegister.registerService(-301334464, 10115);
        serviceRegister.registerService(-1574623680, 10115);
        serviceRegister.registerService(-1557846464, 10115);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2510013: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2525: {
                nArray = ListColumnsUtil.getIntArrayByBits(47, 5);
                break;
            }
            case 2710: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2935: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3306: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2715: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2749: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2922: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3231: {
                nArray = ListColumnsUtil.getIntArrayByBits(2147354368, 17);
                break;
            }
            case 2398: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2415: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2816: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3249: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2510006: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2510012: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device TVTuner: ").append(n).toString());
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
        return ASLTVTunerDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLTVTunerDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2510013: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerKeyPanelListTransformer(), n, "TVTuner", "KeyPanelList");
                genericASLList.updateList(new TVTunerKeyPanelListCollector[]{new TVTunerKeyPanelListCollector()});
                break;
            }
            case 2525: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerTVStationListTransformer(), n, "TVTuner", "TVStationList");
                break;
            }
            case 2710: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerPresetListTransformer(), n, "TVTuner", "PresetList");
                break;
            }
            case 2935: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerCASInformationTransformer(), n, "TVTuner", "CASInformation");
                genericASLList.updateList(new TVTunerCASInformationCollector[]{new TVTunerCASInformationCollector()});
                break;
            }
            case 3306: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerMessageServiceTransformer(), n, "TVTuner", "MessageService");
                genericASLList.updateList(new TVTunerMessageServiceCollector[]{new TVTunerMessageServiceCollector()});
                break;
            }
            case 2715: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerPresetStoreListTransformer(), n, "TVTuner", "PresetStoreList");
                break;
            }
            case 2749: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerSetupPresetDeletionListTransformer(), n, "TVTuner", "SetupPresetDeletionList");
                break;
            }
            case 2922: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerSetupAudioChannelListTransformer(), n, "TVTuner", "SetupAudioChannelList");
                break;
            }
            case 3231: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerEWSMessageTransformer(), n, "TVTuner", "EWSMessage");
                genericASLList.updateList(new TVTunerEWSMessageCollector[]{new TVTunerEWSMessageCollector()});
                break;
            }
            case 2398: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerSupportedTVNormsTransformer(), n, "TVTuner", "SupportedTVNorms");
                break;
            }
            case 2415: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerSupportedTVNormIndicesTransformer(), n, "TVTuner", "SupportedTVNormIndices");
                break;
            }
            case 2816: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerAvailableAudioChannelTransformer(), n, "TVTuner", "AvailableAudioChannel");
                break;
            }
            case 3249: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerEWSMessageAreaCodesListTransformer(), n, "TVTuner", "EWSMessageAreaCodesList");
                break;
            }
            case 2510006: {
                genericASLList = aSLListFactory.createGenericASLList(new TVTunerEWSMessageAreaCodesListNamesTransformer(), n, "TVTuner", "EWSMessageAreaCodesListNames");
                break;
            }
            case 2510012: {
                genericASLList = aSLListFactory.createGenericASLList(ASLTVTunerDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "KeyPanelPositions"), n, "TVTuner", "KeyPanelPositions");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device TVTuner: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 2510012: {
                string3 = "de.vw.mib.asl.internal.tvtuner.transformer.";
                string2 = "TVTunerKeyPanelPositionsTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device TVTuner: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "TVTuner", string);
    }
}

