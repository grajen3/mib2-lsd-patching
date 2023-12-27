/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.radio.transformer.RadioAMPresetListInfoTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioAMPresetListInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioAMStationListInfoTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioAMStationListInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioCurrentSongTagListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioDABAdditionalServicesListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioDABAdditionalServicesList_CommandListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioDABEnsembleListInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioDABPresetListInfoTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioDABPresetListInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioDABServiceListItemInfoTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioDABServiceListItemInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioDABStationListInfoTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioFMPresetListInfoTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioFMPresetListInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioFMStationListInfoTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioFMStationListInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioFMStationListInfo_NAR_MPSTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioFMStationListInfo_NAR_SPSTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioHomeCountryListTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioListStoreAutoLogoSelectLogoTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioServiceComponentsTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioStationListTileLTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioStationListTileSTransformer;
import de.vw.mib.asl.internal.radio.transformer.RadioTMListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoAMCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoAMTransformer;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoDABCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoDABTransformer;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoFMCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoFMTransformer;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioMulticastServiceInfoCollector;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioMulticastServiceInfoTransformer;

public final class ASLRadioDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLRadioDeviceImpl INSTANCE = new ASLRadioDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(31);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLRadioDeviceImpl() {
    }

    public static ASLRadioDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Radio";
    }

    @Override
    public int getTargetId() {
        return 10105;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(465970176, this);
        aSLListRegistry.registerASLDevice(1451, this);
        aSLListRegistry.registerASLDevice(1452, this);
        aSLListRegistry.registerASLDevice(1453, this);
        aSLListRegistry.registerASLDevice(1454, this);
        aSLListRegistry.registerASLDevice(1455, this);
        aSLListRegistry.registerASLDevice(1456, this);
        aSLListRegistry.registerASLDevice(1457, this);
        aSLListRegistry.registerASLDevice(1458, this);
        aSLListRegistry.registerASLDevice(1459, this);
        aSLListRegistry.registerASLDevice(1460, this);
        aSLListRegistry.registerASLDevice(1461, this);
        aSLListRegistry.registerASLDevice(1462, this);
        aSLListRegistry.registerASLDevice(3093, this);
        aSLListRegistry.registerASLDevice(3094, this);
        aSLListRegistry.registerASLDevice(4058, this);
        aSLListRegistry.registerASLDevice(4115, this);
        aSLListRegistry.registerASLDevice(4116, this);
        aSLListRegistry.registerASLDevice(1465, this);
        aSLListRegistry.registerASLDevice(1466, this);
        aSLListRegistry.registerASLDevice(3590, this);
        aSLListRegistry.registerASLDevice(3591, this);
        aSLListRegistry.registerASLDevice(3592, this);
        aSLListRegistry.registerASLDevice(3593, this);
        aSLListRegistry.registerASLDevice(3594, this);
        aSLListRegistry.registerASLDevice(3595, this);
        aSLListRegistry.registerASLDevice(3596, this);
        aSLListRegistry.registerASLDevice(3597, this);
        aSLListRegistry.registerASLDevice(1153836032, this);
        aSLListRegistry.registerASLDevice(1170613248, this);
        aSLListRegistry.registerASLDevice(1416, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-2113667008, 10105);
        serviceRegister.registerService(-2096889792, 10105);
        serviceRegister.registerService(-2080112576, 10105);
        serviceRegister.registerService(-2063335360, 10105);
        serviceRegister.registerService(-2046558144, 10105);
        serviceRegister.registerService(-485883840, 10105);
        serviceRegister.registerService(-2029780928, 10105);
        serviceRegister.registerService(-2013003712, 10105);
        serviceRegister.registerService(-1996226496, 10105);
        serviceRegister.registerService(-1979449280, 10105);
        serviceRegister.registerService(-1962672064, 10105);
        serviceRegister.registerService(-1912340416, 10105);
        serviceRegister.registerService(-1945894848, 10105);
        serviceRegister.registerService(-1929117632, 10105);
        serviceRegister.registerService(-1895563200, 10105);
        serviceRegister.registerService(-1878785984, 10105);
        serviceRegister.registerService(-1862008768, 10105);
        serviceRegister.registerService(-955776960, 10105);
        serviceRegister.registerService(-1845231552, 10105);
        serviceRegister.registerService(-1828454336, 10105);
        serviceRegister.registerService(-1811677120, 10105);
        serviceRegister.registerService(-1794899904, 10105);
        serviceRegister.registerService(-1778122688, 10105);
        serviceRegister.registerService(-1761345472, 10105);
        serviceRegister.registerService(-1744568256, 10105);
        serviceRegister.registerService(-1727791040, 10105);
        serviceRegister.registerService(235536448, 10105);
        serviceRegister.registerService(252313664, 10105);
        serviceRegister.registerService(-1711013824, 10105);
        serviceRegister.registerService(722075712, 10105);
        serviceRegister.registerService(-1694236608, 10105);
        serviceRegister.registerService(-1677459392, 10105);
        serviceRegister.registerService(-1660682176, 10105);
        serviceRegister.registerService(-1643904960, 10105);
        serviceRegister.registerService(-1627127744, 10105);
        serviceRegister.registerService(-1610350528, 10105);
        serviceRegister.registerService(-1593573312, 10105);
        serviceRegister.registerService(-1576796096, 10105);
        serviceRegister.registerService(-1560018880, 10105);
        serviceRegister.registerService(-1543241664, 10105);
        serviceRegister.registerService(-1526464448, 10105);
        serviceRegister.registerService(-1509687232, 10105);
        serviceRegister.registerService(-1492910016, 10105);
        serviceRegister.registerService(-1476132800, 10105);
        serviceRegister.registerService(-1459355584, 10105);
        serviceRegister.registerService(-1442578368, 10105);
        serviceRegister.registerService(-1425801152, 10105);
        serviceRegister.registerService(-1409023936, 10105);
        serviceRegister.registerService(983508032, 10105);
        serviceRegister.registerService(-1392246720, 10105);
        serviceRegister.registerService(-1375469504, 10105);
        serviceRegister.registerService(-1358692288, 10105);
        serviceRegister.registerService(-1341915072, 10105);
        serviceRegister.registerService(10429504, 10105);
        serviceRegister.registerService(-1325137856, 10105);
        serviceRegister.registerService(-1073151936, 10105);
        serviceRegister.registerService(-1291583424, 10105);
        serviceRegister.registerService(-1274806208, 10105);
        serviceRegister.registerService(-1224474560, 10105);
        serviceRegister.registerService(-1207697344, 10105);
        serviceRegister.registerService(144647232, 10105);
        serviceRegister.registerService(-1190920128, 10105);
        serviceRegister.registerService(-1174142912, 10105);
        serviceRegister.registerService(1745551424, 10105);
        serviceRegister.registerService(27206720, 10105);
        serviceRegister.registerService(-1308360640, 10105);
        serviceRegister.registerService(-1140588480, 10105);
        serviceRegister.registerService(-1123811264, 10105);
        serviceRegister.registerService(127870016, 10105);
        serviceRegister.registerService(-1090256832, 10105);
        serviceRegister.registerService(178201664, 10105);
        serviceRegister.registerService(1930100800, 10105);
        serviceRegister.registerService(1946878016, 10105);
        serviceRegister.registerService(-1073479616, 10105);
        serviceRegister.registerService(-1056702400, 10105);
        serviceRegister.registerService(-1039925184, 10105);
        serviceRegister.registerService(1443430464, 10105);
        serviceRegister.registerService(-1023147968, 10105);
        serviceRegister.registerService(161424448, 10105);
        serviceRegister.registerService(-1006370752, 10105);
        serviceRegister.registerService(-1107034048, 10105);
        serviceRegister.registerService(-989593536, 10105);
        serviceRegister.registerService(1107689536, 10105);
        serviceRegister.registerService(-972816320, 10105);
        serviceRegister.registerService(-956039104, 10105);
        serviceRegister.registerService(-939261888, 10105);
        serviceRegister.registerService(-922484672, 10105);
        serviceRegister.registerService(-905707456, 10105);
        serviceRegister.registerService(655424, 10105);
        serviceRegister.registerService(-888930240, 10105);
        serviceRegister.registerService(1225130048, 10105);
        serviceRegister.registerService(77538368, 10105);
        serviceRegister.registerService(-872153024, 10105);
        serviceRegister.registerService(-855375808, 10105);
        serviceRegister.registerService(-838598592, 10105);
        serviceRegister.registerService(-821821376, 10105);
        serviceRegister.registerService(-805044160, 10105);
        serviceRegister.registerService(-788266944, 10105);
        serviceRegister.registerService(-2096693184, 10105);
        serviceRegister.registerService(-771489728, 10105);
        serviceRegister.registerService(-754712512, 10105);
        serviceRegister.registerService(-737935296, 10105);
        serviceRegister.registerService(-721158080, 10105);
        serviceRegister.registerService(-704380864, 10105);
        serviceRegister.registerService(-687603648, 10105);
        serviceRegister.registerService(-670826432, 10105);
        serviceRegister.registerService(-654049216, 10105);
        serviceRegister.registerService(-637272000, 10105);
        serviceRegister.registerService(-620494784, 10105);
        serviceRegister.registerService(-603717568, 10105);
        serviceRegister.registerService(-586940352, 10105);
        serviceRegister.registerService(-2079915968, 10105);
        serviceRegister.registerService(-570163136, 10105);
        serviceRegister.registerService(-553385920, 10105);
        serviceRegister.registerService(-536608704, 10105);
        serviceRegister.registerService(118161472, 10105);
        serviceRegister.registerService(134938688, 10105);
        serviceRegister.registerService(-519831488, 10105);
        serviceRegister.registerService(-503054272, 10105);
        serviceRegister.registerService(-486277056, 10105);
        serviceRegister.registerService(-469499840, 10105);
        serviceRegister.registerService(-452722624, 10105);
        serviceRegister.registerService(-435945408, 10105);
        serviceRegister.registerService(-419168192, 10105);
        serviceRegister.registerService(-402390976, 10105);
        serviceRegister.registerService(-385613760, 10105);
        serviceRegister.registerService(262087744, 10105);
        serviceRegister.registerService(278864960, 10105);
        serviceRegister.registerService(295642176, 10105);
        serviceRegister.registerService(312419392, 10105);
        serviceRegister.registerService(329196608, 10105);
        serviceRegister.registerService(345973824, 10105);
        serviceRegister.registerService(362751040, 10105);
        serviceRegister.registerService(379528256, 10105);
        serviceRegister.registerService(396305472, 10105);
        serviceRegister.registerService(413082688, 10105);
        serviceRegister.registerService(429859904, 10105);
        serviceRegister.registerService(446637120, 10105);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2410011: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1451: {
                nArray = ListColumnsUtil.getIntArrayByBits(477, 7);
                break;
            }
            case 1452: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 1453: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1454: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 1455: {
                nArray = ListColumnsUtil.getIntArrayByBits(3583, 11);
                break;
            }
            case 1456: {
                nArray = ListColumnsUtil.getIntArrayByBits(1791, 10);
                break;
            }
            case 1457: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 1458: {
                nArray = ListColumnsUtil.getIntArrayByBits(247, 7);
                break;
            }
            case 1459: {
                nArray = ListColumnsUtil.getSimpleIntArray(12);
                break;
            }
            case 1460: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 1461: {
                nArray = ListColumnsUtil.getIntArrayByBits(1915, 9);
                break;
            }
            case 1462: {
                nArray = ListColumnsUtil.getSimpleIntArray(12);
                break;
            }
            case 3093: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 3094: {
                nArray = ListColumnsUtil.getIntArrayByBits(247, 7);
                break;
            }
            case 4058: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 4115: {
                nArray = ListColumnsUtil.getIntArrayByBits(27, 4);
                break;
            }
            case 4116: {
                nArray = ListColumnsUtil.getIntArrayByBits(27, 4);
                break;
            }
            case 1465: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 1466: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 3590: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3591: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3592: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3593: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3594: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3595: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3596: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3597: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2410052: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2410053: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 1416: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Radio: ").append(n).toString());
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
        return ASLRadioDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLRadioDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2410011: {
                genericASLList = aSLListFactory.createGenericASLList(ASLRadioDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "ListOfExceptions"), n, "Radio", "ListOfExceptions");
                break;
            }
            case 1451: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioAMPresetListInfoTransformer(), n, "Radio", "AMPresetListInfo");
                break;
            }
            case 1452: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioAMStationListInfoTransformer(), n, "Radio", "AMStationListInfo");
                break;
            }
            case 1453: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioCurrentSongTagListTransformer(), n, "Radio", "CurrentSongTagList");
                break;
            }
            case 1454: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioCurrentStationInfoAMTransformer(), n, "Radio", "CurrentStationInfoAM");
                genericASLList.updateList(new RadioCurrentStationInfoAMCollector[]{new RadioCurrentStationInfoAMCollector()});
                break;
            }
            case 1455: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioCurrentStationInfoDABTransformer(), n, "Radio", "CurrentStationInfoDAB");
                genericASLList.updateList(new RadioCurrentStationInfoDABCollector[]{new RadioCurrentStationInfoDABCollector()});
                break;
            }
            case 1456: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioCurrentStationInfoFMTransformer(), n, "Radio", "CurrentStationInfoFM");
                genericASLList.updateList(new RadioCurrentStationInfoFMCollector[]{new RadioCurrentStationInfoFMCollector()});
                break;
            }
            case 1457: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioDABAdditionalServicesListTransformer(), n, "Radio", "DABAdditionalServicesList");
                break;
            }
            case 1458: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioDABPresetListInfoTransformer(), n, "Radio", "DABPresetListInfo");
                break;
            }
            case 1459: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioDABServiceListItemInfoTransformer(), n, "Radio", "DABServiceListItemInfo");
                break;
            }
            case 1460: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioDABStationListInfoTransformer(), n, "Radio", "DABStationListInfo");
                break;
            }
            case 1461: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioFMPresetListInfoTransformer(), n, "Radio", "FMPresetListInfo");
                break;
            }
            case 1462: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioFMStationListInfoTransformer(), n, "Radio", "FMStationListInfo");
                break;
            }
            case 3093: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioFMStationListInfo_NAR_MPSTransformer(), n, "Radio", "FMStationListInfo_NAR_MPS");
                break;
            }
            case 3094: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioFMStationListInfo_NAR_SPSTransformer(), n, "Radio", "FMStationListInfo_NAR_SPS");
                break;
            }
            case 4058: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioListStoreAutoLogoSelectLogoTransformer(), n, "Radio", "ListStoreAutoLogoSelectLogo");
                break;
            }
            case 4115: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioHomeCountryListTransformer(), n, "Radio", "HomeCountryList");
                break;
            }
            case 4116: {
                genericASLList = aSLListFactory.createGenericASLList(ASLRadioDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "HomeProvinceList"), n, "Radio", "HomeProvinceList");
                break;
            }
            case 1465: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioMulticastServiceInfoTransformer(), n, "Radio", "MulticastServiceInfo");
                genericASLList.updateList(new RadioMulticastServiceInfoCollector[]{new RadioMulticastServiceInfoCollector()});
                break;
            }
            case 1466: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioTMListTransformer(), n, "Radio", "TMList");
                break;
            }
            case 3590: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioAMPresetListInfo_CommandListTransformer(), n, "Radio", "AMPresetListInfo_CommandList");
                break;
            }
            case 3591: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioAMStationListInfo_CommandListTransformer(), n, "Radio", "AMStationListInfo_CommandList");
                break;
            }
            case 3592: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioDABAdditionalServicesList_CommandListTransformer(), n, "Radio", "DABAdditionalServicesList_CommandList");
                break;
            }
            case 3593: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioDABEnsembleListInfo_CommandListTransformer(), n, "Radio", "DABEnsembleListInfo_CommandList");
                break;
            }
            case 3594: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioDABPresetListInfo_CommandListTransformer(), n, "Radio", "DABPresetListInfo_CommandList");
                break;
            }
            case 3595: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioDABServiceListItemInfo_CommandListTransformer(), n, "Radio", "DABServiceListItemInfo_CommandList");
                break;
            }
            case 3596: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioFMPresetListInfo_CommandListTransformer(), n, "Radio", "FMPresetListInfo_CommandList");
                break;
            }
            case 3597: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioFMStationListInfo_CommandListTransformer(), n, "Radio", "FMStationListInfo_CommandList");
                break;
            }
            case 2410052: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioStationListTileLTransformer(), n, "Radio", "StationListTileL");
                break;
            }
            case 2410053: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioStationListTileSTransformer(), n, "Radio", "StationListTileS");
                break;
            }
            case 1416: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioServiceComponentsTransformer(), n, "Radio", "ServiceComponents");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Radio: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 2410011: {
                string3 = "de.vw.mib.asl.internal.radio.transformer.";
                string2 = "RadioListOfExceptionsTransformer";
                break;
            }
            case 4116: {
                string3 = "de.vw.mib.asl.internal.radio.transformer.";
                string2 = "RadioHomeProvinceListTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Radio: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Radio", string);
    }
}

