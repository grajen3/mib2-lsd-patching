/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.system.transformer.SystemAddSpeLanLis_ISO_Vec2595Transformer;
import de.vw.mib.asl.internal.system.transformer.SystemAdditionalSpellerLanguageListTransformer;
import de.vw.mib.asl.internal.system.transformer.SystemCalendarListCurrentMonthTransformer;
import de.vw.mib.asl.internal.system.transformer.SystemCalendarListLastMonthTransformer;
import de.vw.mib.asl.internal.system.transformer.SystemCalendarListNextMonthTransformer;
import de.vw.mib.asl.internal.system.transformer.SystemCopyrightInfoTextList2Transformer;
import de.vw.mib.asl.internal.system.transformer.SystemLangErrorList_LangIsoTransformer;
import de.vw.mib.asl.internal.system.transformer.SystemPersistedProfileTransformer;
import de.vw.mib.asl.internal.system.transformer.SystemSetupAvailableLanguagesList_ISOTransformer;
import de.vw.mib.asl.internal.system.transformer.SystemSkinListTransformer;
import de.vw.mib.asl.internal.system.transformer.SystemTestmodeDiagDataListTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.system.transformer.SystemCurrentLanguageConfigurationCollector;
import generated.de.vw.mib.asl.internal.system.transformer.SystemCurrentLanguageConfigurationTransformer;

public final class ASLSystemDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSystemDeviceImpl INSTANCE = new ASLSystemDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(12);
    private ASLListFactory listFactory;

    private ASLSystemDeviceImpl() {
    }

    public static ASLSystemDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "System";
    }

    @Override
    public int getTargetId() {
        return 10111;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3566, this);
        aSLListRegistry.registerASLDevice(1718, this);
        aSLListRegistry.registerASLDevice(3624, this);
        aSLListRegistry.registerASLDevice(1228021760, this);
        aSLListRegistry.registerASLDevice(1579, this);
        aSLListRegistry.registerASLDevice(1580, this);
        aSLListRegistry.registerASLDevice(1581, this);
        aSLListRegistry.registerASLDevice(2595, this);
        aSLListRegistry.registerASLDevice(3495, this);
        aSLListRegistry.registerASLDevice(3616, this);
        aSLListRegistry.registerASLDevice(2353, this);
        aSLListRegistry.registerASLDevice(1622, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(839188544, 10111);
        serviceRegister.registerService(1476722752, 10111);
        serviceRegister.registerService(-1828192192, 10111);
        serviceRegister.registerService(-1492582336, 10111);
        serviceRegister.registerService(855965760, 10111);
        serviceRegister.registerService(872742976, 10111);
        serviceRegister.registerService(889520192, 10111);
        serviceRegister.registerService(906297408, 10111);
        serviceRegister.registerService(923074624, 10111);
        serviceRegister.registerService(939851840, 10111);
        serviceRegister.registerService(956629056, 10111);
        serviceRegister.registerService(973406272, 10111);
        serviceRegister.registerService(990183488, 10111);
        serviceRegister.registerService(1006960704, 10111);
        serviceRegister.registerService(554377280, 10111);
        serviceRegister.registerService(1023737920, 10111);
        serviceRegister.registerService(587931712, 10111);
        serviceRegister.registerService(1040916544, 10111);
        serviceRegister.registerService(17432640, 10111);
        serviceRegister.registerService(1057693760, 10111);
        serviceRegister.registerService(1074470976, 10111);
        serviceRegister.registerService(873144384, 10111);
        serviceRegister.registerService(940253248, 10111);
        serviceRegister.registerService(1040515136, 10111);
        serviceRegister.registerService(1057292352, 10111);
        serviceRegister.registerService(0x40050040, 10111);
        serviceRegister.registerService(1090846784, 10111);
        serviceRegister.registerService(1107624000, 10111);
        serviceRegister.registerService(1124401216, 10111);
        serviceRegister.registerService(0x44050040, 10111);
        serviceRegister.registerService(0x45050040, 10111);
        serviceRegister.registerService(1174732864, 10111);
        serviceRegister.registerService(1191510080, 10111);
        serviceRegister.registerService(34209856, 10111);
        serviceRegister.registerService(-1106706368, 10111);
        serviceRegister.registerService(1208287296, 10111);
        serviceRegister.registerService(1225064512, 10111);
        serviceRegister.registerService(587857984, 10111);
        serviceRegister.registerService(1241841728, 10111);
        serviceRegister.registerService(755703872, 10111);
        serviceRegister.registerService(906698816, 10111);
        serviceRegister.registerService(1258618944, 10111);
        serviceRegister.registerService(1292173376, 10111);
        serviceRegister.registerService(705372224, 10111);
        serviceRegister.registerService(722149440, 10111);
        serviceRegister.registerService(1308950592, 10111);
        serviceRegister.registerService(1325727808, 10111);
        serviceRegister.registerService(772481088, 10111);
        serviceRegister.registerService(-1844969408, 10111);
        serviceRegister.registerService(0x50050040, 10111);
        serviceRegister.registerService(1359282240, 10111);
        serviceRegister.registerService(0x54050040, 10111);
        serviceRegister.registerService(0x55050040, 10111);
        serviceRegister.registerService(738926656, 10111);
        serviceRegister.registerService(-1006108608, 10111);
        serviceRegister.registerService(822812736, 10111);
        serviceRegister.registerService(806035520, 10111);
        serviceRegister.registerService(537600064, 10111);
        serviceRegister.registerService(-267780032, 10111);
        serviceRegister.registerService(-251002816, 10111);
        serviceRegister.registerService(571154496, 10111);
        serviceRegister.registerService(1443168320, 10111);
        serviceRegister.registerService(1459945536, 10111);
        serviceRegister.registerService(1829044288, 10111);
        serviceRegister.registerService(1795489856, 10111);
        serviceRegister.registerService(1527054400, 10111);
        serviceRegister.registerService(1543831616, 10111);
        serviceRegister.registerService(923476032, 10111);
        serviceRegister.registerService(1845821504, 10111);
        serviceRegister.registerService(1644494912, 10111);
        serviceRegister.registerService(1493499968, 10111);
        serviceRegister.registerService(1560608832, 10111);
        serviceRegister.registerService(638263360, 10111);
        serviceRegister.registerService(990584896, 10111);
        serviceRegister.registerService(1007362112, 10111);
        serviceRegister.registerService(1024139328, 10111);
        serviceRegister.registerService(1812267072, 10111);
        serviceRegister.registerService(1510277184, 10111);
        serviceRegister.registerService(789258304, 10111);
        serviceRegister.registerService(889921600, 10111);
        serviceRegister.registerService(1577386048, 10111);
        serviceRegister.registerService(1594163264, 10111);
        serviceRegister.registerService(1610940480, 10111);
        serviceRegister.registerService(1627717696, 10111);
        serviceRegister.registerService(1661272128, 10111);
        serviceRegister.registerService(1678049344, 10111);
        serviceRegister.registerService(1694826560, 10111);
        serviceRegister.registerService(-1089929152, 10111);
        serviceRegister.registerService(1711603776, 10111);
        serviceRegister.registerService(1728380992, 10111);
        serviceRegister.registerService(-1156972480, 10111);
        serviceRegister.registerService(839589952, 10111);
        serviceRegister.registerService(856367168, 10111);
        serviceRegister.registerService(957030464, 10111);
        serviceRegister.registerService(973807680, 10111);
        serviceRegister.registerService(1392836672, 10111);
        serviceRegister.registerService(1376059456, 10111);
        serviceRegister.registerService(1745158208, 10111);
        serviceRegister.registerService(1761935424, 10111);
        serviceRegister.registerService(1275396160, 10111);
        serviceRegister.registerService(1778712640, 10111);
        serviceRegister.registerService(1091248192, 10111);
        serviceRegister.registerService(1108025408, 10111);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3566: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 1718: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3624: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2110025: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1579: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1580: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1581: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2595: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3495: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3616: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2353: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1622: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device System: ").append(n).toString());
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
        return ASLSystemDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSystemDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3566: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemTestmodeDiagDataListTransformer(), n, "System", "TestmodeDiagDataList");
                break;
            }
            case 1718: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemAdditionalSpellerLanguageListTransformer(), n, "System", "AdditionalSpellerLanguageList");
                break;
            }
            case 3624: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemCurrentLanguageConfigurationTransformer(), n, "System", "CurrentLanguageConfiguration");
                genericASLList.updateList(new SystemCurrentLanguageConfigurationCollector[]{new SystemCurrentLanguageConfigurationCollector()});
                break;
            }
            case 2110025: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemPersistedProfileTransformer(), n, "System", "PersistedProfile");
                break;
            }
            case 1579: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemCalendarListCurrentMonthTransformer(), n, "System", "CalendarListCurrentMonth");
                break;
            }
            case 1580: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemCalendarListLastMonthTransformer(), n, "System", "CalendarListLastMonth");
                break;
            }
            case 1581: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemCalendarListNextMonthTransformer(), n, "System", "CalendarListNextMonth");
                break;
            }
            case 2595: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemAddSpeLanLis_ISO_Vec2595Transformer(), n, "System", "AdditionalSpellerLanguagesList_ISO_Vector");
                break;
            }
            case 3495: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemCopyrightInfoTextList2Transformer(), n, "System", "CopyrightInfoTextList2");
                break;
            }
            case 3616: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemLangErrorList_LangIsoTransformer(), n, "System", "LangErrorList_LangIso");
                break;
            }
            case 2353: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemSetupAvailableLanguagesList_ISOTransformer(), n, "System", "SetupAvailableLanguagesList_ISO");
                break;
            }
            case 1622: {
                genericASLList = aSLListFactory.createGenericASLList(new SystemSkinListTransformer(), n, "System", "SkinList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device System: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

