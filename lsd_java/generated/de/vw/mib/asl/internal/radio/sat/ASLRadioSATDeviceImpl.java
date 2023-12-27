/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.sat;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCategoryListInfoTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCategoryListInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCategoryListSubItemInfoTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATChanneFilterCategoryListTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATChanneFilterChannelListTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATChannelListInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATChannelListItemInfoTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATManageAlertsListTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATAlertListTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATPresetListInfoTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATPresetListInfo_CommandListTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATReplaceAlertListTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATSimilarContentListTransformer;
import de.vw.mib.asl.internal.radio.sat.transformer.RadioSATTrafficMarketListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCurrentChannelInfoCollector;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCurrentChannelInfoTransformer;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATRadioTextCollector;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATRadioTextTransformer;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATAlertInfoCollector;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATAlertInfoTransformer;

public final class ASLRadioSATDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLRadioSATDeviceImpl INSTANCE = new ASLRadioSATDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(20);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLRadioSATDeviceImpl() {
    }

    public static ASLRadioSATDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Radio.SAT";
    }

    @Override
    public int getTargetId() {
        return 10104;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1304, this);
        aSLListRegistry.registerASLDevice(314975232, this);
        aSLListRegistry.registerASLDevice(1305, this);
        aSLListRegistry.registerASLDevice(1306, this);
        aSLListRegistry.registerASLDevice(1307, this);
        aSLListRegistry.registerASLDevice(1308, this);
        aSLListRegistry.registerASLDevice(3962, this);
        aSLListRegistry.registerASLDevice(1309, this);
        aSLListRegistry.registerASLDevice(3340, this);
        aSLListRegistry.registerASLDevice(1310, this);
        aSLListRegistry.registerASLDevice(1311, this);
        aSLListRegistry.registerASLDevice(1312, this);
        aSLListRegistry.registerASLDevice(1313, this);
        aSLListRegistry.registerASLDevice(1314, this);
        aSLListRegistry.registerASLDevice(382084096, this);
        aSLListRegistry.registerASLDevice(398861312, this);
        aSLListRegistry.registerASLDevice(415638528, this);
        aSLListRegistry.registerASLDevice(1273, this);
        aSLListRegistry.registerASLDevice(1275, this);
        aSLListRegistry.registerASLDevice(1284, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(0x4B040040, 10104);
        serviceRegister.registerService(0x4C040040, 10104);
        serviceRegister.registerService(0x4D040040, 10104);
        serviceRegister.registerService(0x4E040040, 10104);
        serviceRegister.registerService(0x4F040040, 10104);
        serviceRegister.registerService(0x50040040, 10104);
        serviceRegister.registerService(1359216704, 10104);
        serviceRegister.registerService(1375993920, 10104);
        serviceRegister.registerService(1392771136, 10104);
        serviceRegister.registerService(0x54040040, 10104);
        serviceRegister.registerService(60761152, 10104);
        serviceRegister.registerService(0x55040040, 10104);
        serviceRegister.registerService(1443102784, 10104);
        serviceRegister.registerService(1459880000, 10104);
        serviceRegister.registerService(43983936, 10104);
        serviceRegister.registerService(1476657216, 10104);
        serviceRegister.registerService(1493434432, 10104);
        serviceRegister.registerService(1510211648, 10104);
        serviceRegister.registerService(1526988864, 10104);
        serviceRegister.registerService(1543766080, 10104);
        serviceRegister.registerService(-385220544, 10104);
        serviceRegister.registerService(-368443328, 10104);
        serviceRegister.registerService(1560543296, 10104);
        serviceRegister.registerService(1577320512, 10104);
        serviceRegister.registerService(1594097728, 10104);
        serviceRegister.registerService(1208549440, 10104);
        serviceRegister.registerService(0x60040040, 10104);
        serviceRegister.registerService(1627652160, 10104);
        serviceRegister.registerService(1644429376, 10104);
        serviceRegister.registerService(1661206592, 10104);
        serviceRegister.registerService(0x64040040, 10104);
        serviceRegister.registerService(1694761024, 10104);
        serviceRegister.registerService(0x66040040, 10104);
        serviceRegister.registerService(1728315456, 10104);
        serviceRegister.registerService(1745092672, 10104);
        serviceRegister.registerService(1761869888, 10104);
        serviceRegister.registerService(1778647104, 10104);
        serviceRegister.registerService(1795424320, 10104);
        serviceRegister.registerService(1812201536, 10104);
        serviceRegister.registerService(1828978752, 10104);
        serviceRegister.registerService(1845755968, 10104);
        serviceRegister.registerService(1862533184, 10104);
        serviceRegister.registerService(0x70040040, 10104);
        serviceRegister.registerService(1896087616, 10104);
        serviceRegister.registerService(1912864832, 10104);
        serviceRegister.registerService(1929642048, 10104);
        serviceRegister.registerService(0x74040040, 10104);
        serviceRegister.registerService(1963196480, 10104);
        serviceRegister.registerService(1979973696, 10104);
        serviceRegister.registerService(0x77040040, 10104);
        serviceRegister.registerService(2013528128, 10104);
        serviceRegister.registerService(2030305344, 10104);
        serviceRegister.registerService(2047082560, 10104);
        serviceRegister.registerService(2063859776, 10104);
        serviceRegister.registerService(-653721536, 10104);
        serviceRegister.registerService(-636944320, 10104);
        serviceRegister.registerService(2080636992, 10104);
        serviceRegister.registerService(2097414208, 10104);
        serviceRegister.registerService(2114191424, 10104);
        serviceRegister.registerService(2130968640, 10104);
        serviceRegister.registerService(-2147221440, 10104);
        serviceRegister.registerService(-2130444224, 10104);
        serviceRegister.registerService(94315584, 10104);
        serviceRegister.registerService(111092800, 10104);
        serviceRegister.registerService(194978880, 10104);
        serviceRegister.registerService(211756096, 10104);
        serviceRegister.registerService(228533312, 10104);
        serviceRegister.registerService(245310528, 10104);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1304: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2410002: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 1305: {
                nArray = ListColumnsUtil.getIntArrayByBits(11, 3);
                break;
            }
            case 1306: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 1307: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 1308: {
                nArray = ListColumnsUtil.getSimpleIntArray(19);
                break;
            }
            case 3962: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            case 1309: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 3340: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 1310: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1311: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1312: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 1313: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 1314: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2410006: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2410007: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2410008: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1273: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1275: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1284: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Radio.SAT: ").append(n).toString());
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
        return ASLRadioSATDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLRadioSATDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1304: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATCategoryListInfoTransformer(), n, "Radio.SAT", "CategoryListInfo");
                break;
            }
            case 2410002: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATCategoryListSubItemInfoTransformer(), n, "Radio.SAT", "CategoryListSubItemInfo");
                break;
            }
            case 1305: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATChanneFilterCategoryListTransformer(), n, "Radio.SAT", "ChanneFilterCategoryList");
                break;
            }
            case 1306: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATChanneFilterChannelListTransformer(), n, "Radio.SAT", "ChanneFilterChannelList");
                break;
            }
            case 1307: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATChannelListItemInfoTransformer(), n, "Radio.SAT", "ChannelListItemInfo");
                break;
            }
            case 1308: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATCurrentChannelInfoTransformer(), n, "Radio.SAT", "CurrentChannelInfo");
                genericASLList.updateList(new RadioSATCurrentChannelInfoCollector[]{new RadioSATCurrentChannelInfoCollector()});
                break;
            }
            case 3962: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATRadioTextTransformer(), n, "Radio.SAT", "RadioText");
                genericASLList.updateList(new RadioSATRadioTextCollector[]{new RadioSATRadioTextCollector()});
                break;
            }
            case 1309: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATSATAlertListTransformer(), n, "Radio.SAT", "SATAlertList");
                break;
            }
            case 3340: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATSATSimilarContentListTransformer(), n, "Radio.SAT", "SATSimilarContentList");
                break;
            }
            case 1310: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATSATReplaceAlertListTransformer(), n, "Radio.SAT", "SATReplaceAlertList");
                break;
            }
            case 1311: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATManageAlertsListTransformer(), n, "Radio.SAT", "ManageAlertsList");
                break;
            }
            case 1312: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATSATAlertInfoTransformer(), n, "Radio.SAT", "SATAlertInfo");
                genericASLList.updateList(new RadioSATSATAlertInfoCollector[]{new RadioSATSATAlertInfoCollector()});
                break;
            }
            case 1313: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATSATPresetListInfoTransformer(), n, "Radio.SAT", "SATPresetListInfo");
                break;
            }
            case 1314: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATTrafficMarketListTransformer(), n, "Radio.SAT", "TrafficMarketList");
                break;
            }
            case 2410006: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATCategoryListInfo_CommandListTransformer(), n, "Radio.SAT", "CategoryListInfo_CommandList");
                break;
            }
            case 2410007: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATSATPresetListInfo_CommandListTransformer(), n, "Radio.SAT", "SATPresetListInfo_CommandList");
                break;
            }
            case 2410008: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioSATChannelListInfo_CommandListTransformer(), n, "Radio.SAT", "ChannelListInfo_CommandList");
                break;
            }
            case 1273: {
                genericASLList = aSLListFactory.createGenericASLList(ASLRadioSATDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "CategoryListInfo_Command"), n, "Radio.SAT", "CategoryListInfo_Command");
                break;
            }
            case 1275: {
                genericASLList = aSLListFactory.createGenericASLList(ASLRadioSATDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "ChannelListInfo_Command"), n, "Radio.SAT", "ChannelListInfo_Command");
                break;
            }
            case 1284: {
                genericASLList = aSLListFactory.createGenericASLList(ASLRadioSATDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "SATPresetListInfo_Command"), n, "Radio.SAT", "SATPresetListInfo_Command");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Radio.SAT: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 1273: {
                string3 = "de.vw.mib.asl.internal.radio.sat.transformer.";
                string2 = "RadioSATCategoryListInfo_CommandTransformer";
                break;
            }
            case 1275: {
                string3 = "de.vw.mib.asl.internal.radio.sat.transformer.";
                string2 = "RadioSATChannelListInfo_CommandTransformer";
                break;
            }
            case 1284: {
                string3 = "de.vw.mib.asl.internal.radio.sat.transformer.";
                string2 = "RadioSATSATPresetListInfo_CommandTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Radio.SAT: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Radio.SAT", string);
    }
}

