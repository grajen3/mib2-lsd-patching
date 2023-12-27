/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.online;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.online.transformer.OnlineActiveTrackingServices2Transformer;
import de.vw.mib.asl.internal.online.transformer.OnlineAvailableDownloadListTransformer;
import de.vw.mib.asl.internal.online.transformer.OnlineAvailableServerListTransformer;
import de.vw.mib.asl.internal.online.transformer.OnlineOnlineApplicationTransformer;
import de.vw.mib.asl.internal.online.transformer.OnlineOnlineDownloadPackageMainTransformer;
import de.vw.mib.asl.internal.online.transformer.OnlineOnlineDownloadPackageSubTransformer;
import de.vw.mib.asl.internal.online.transformer.OnlineOnlineServiceItemTransformer;
import de.vw.mib.asl.internal.online.transformer.OnlineOnlineServicePackageTransformer;
import de.vw.mib.asl.internal.online.transformer.OnlineOnlineServiceTransformer;
import de.vw.mib.asl.internal.online.transformer.OnlineOnlineServicesListTransformer;
import de.vw.mib.asl.internal.online.transformer.OnlineOnlineUpdatePackageListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlDowPacCurDow1310032Collector;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlDowPacCurDow1310032Transformer;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineDownloadPackageCurrentlySelectedCollector;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineDownloadPackageCurrentlySelectedTransformer;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineOCUUpdateCollector;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineOCUUpdateTransformer;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineServiceInfoCollector;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineServiceInfoTransformer;

public final class ASLOnlineDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLOnlineDeviceImpl INSTANCE = new ASLOnlineDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(18);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLOnlineDeviceImpl() {
    }

    public static ASLOnlineDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Online";
    }

    @Override
    public int getTargetId() {
        return 10150;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(4046, this);
        aSLListRegistry.registerASLDevice(956109568, this);
        aSLListRegistry.registerASLDevice(1224545024, this);
        aSLListRegistry.registerASLDevice(1241322240, this);
        aSLListRegistry.registerASLDevice(1543312128, this);
        aSLListRegistry.registerASLDevice(1560089344, this);
        aSLListRegistry.registerASLDevice(1576866560, this);
        aSLListRegistry.registerASLDevice(1778193152, this);
        aSLListRegistry.registerASLDevice(1325208320, this);
        aSLListRegistry.registerASLDevice(1341985536, this);
        aSLListRegistry.registerASLDevice(1358762752, this);
        aSLListRegistry.registerASLDevice(1375539968, this);
        aSLListRegistry.registerASLDevice(872223488, this);
        aSLListRegistry.registerASLDevice(972886784, this);
        aSLListRegistry.registerASLDevice(1711084288, this);
        aSLListRegistry.registerASLDevice(1476203264, this);
        aSLListRegistry.registerASLDevice(1492980480, this);
        aSLListRegistry.registerASLDevice(1744638720, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(957022272, 10150);
        serviceRegister.registerService(718672704, 10150);
        serviceRegister.registerService(651563840, 10150);
        serviceRegister.registerService(769004352, 10150);
        serviceRegister.registerService(668341056, 10150);
        serviceRegister.registerService(567677760, 10150);
        serviceRegister.registerService(1356206912, 10150);
        serviceRegister.registerService(1372984128, 10150);
        serviceRegister.registerService(886444864, 10150);
        serviceRegister.registerService(1389761344, 10150);
        serviceRegister.registerService(1406538560, 10150);
        serviceRegister.registerService(903222080, 10150);
        serviceRegister.registerService(1423315776, 10150);
        serviceRegister.registerService(1440092992, 10150);
        serviceRegister.registerService(919999296, 10150);
        serviceRegister.registerService(1456870208, 10150);
        serviceRegister.registerService(1473647424, 10150);
        serviceRegister.registerService(936776512, 10150);
        serviceRegister.registerService(1490424640, 10150);
        serviceRegister.registerService(1507201856, 10150);
        serviceRegister.registerService(953553728, 10150);
        serviceRegister.registerService(550900544, 10150);
        serviceRegister.registerService(1326121024, 10150);
        serviceRegister.registerService(735449920, 10150);
        serviceRegister.registerService(584454976, 10150);
        serviceRegister.registerService(601232192, 10150);
        serviceRegister.registerService(618009408, 10150);
        serviceRegister.registerService(1561002048, 10150);
        serviceRegister.registerService(634786624, 10150);
        serviceRegister.registerService(685118272, 10150);
        serviceRegister.registerService(1577779264, 10150);
        serviceRegister.registerService(1342898240, 10150);
        serviceRegister.registerService(701895488, 10150);
        serviceRegister.registerService(1359675456, 10150);
        serviceRegister.registerService(1376452672, 10150);
        serviceRegister.registerService(785781568, 10150);
        serviceRegister.registerService(970330944, 10150);
        serviceRegister.registerService(987108160, 10150);
        serviceRegister.registerService(1003885376, 10150);
        serviceRegister.registerService(1020662592, 10150);
        serviceRegister.registerService(1037439808, 10150);
        serviceRegister.registerService(1070994240, 10150);
        serviceRegister.registerService(1154880320, 10150);
        serviceRegister.registerService(1205211968, 10150);
        serviceRegister.registerService(1171657536, 10150);
        serviceRegister.registerService(1188434752, 10150);
        serviceRegister.registerService(1054217024, 10150);
        serviceRegister.registerService(1523979072, 10150);
        serviceRegister.registerService(1087771456, 10150);
        serviceRegister.registerService(1104548672, 10150);
        serviceRegister.registerService(1121325888, 10150);
        serviceRegister.registerService(1138103104, 10150);
        serviceRegister.registerService(1221989184, 10150);
        serviceRegister.registerService(1238766400, 10150);
        serviceRegister.registerService(1255543616, 10150);
        serviceRegister.registerService(1272320832, 10150);
        serviceRegister.registerService(1289098048, 10150);
        serviceRegister.registerService(1305875264, 10150);
        serviceRegister.registerService(1322652480, 10150);
        serviceRegister.registerService(1339429696, 10150);
        serviceRegister.registerService(1540756288, 10150);
        serviceRegister.registerService(1557533504, 10150);
        serviceRegister.registerService(1574310720, 10150);
        serviceRegister.registerService(1758860096, 10150);
        serviceRegister.registerService(1591087936, 10150);
        serviceRegister.registerService(1607865152, 10150);
        serviceRegister.registerService(1624642368, 10150);
        serviceRegister.registerService(1641419584, 10150);
        serviceRegister.registerService(1742082880, 10150);
        serviceRegister.registerService(1658196800, 10150);
        serviceRegister.registerService(1674974016, 10150);
        serviceRegister.registerService(1691751232, 10150);
        serviceRegister.registerService(1708528448, 10150);
        serviceRegister.registerService(1725305664, 10150);
        serviceRegister.registerService(1775637312, 10150);
        serviceRegister.registerService(1792414528, 10150);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 4046: {
                nArray = ListColumnsUtil.getIntArrayByBits(56, 3);
                break;
            }
            case 1310008: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 1310024: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 1310025: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 1310043: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1310044: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 1310045: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 1310057: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 1310030: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1310031: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1310032: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1310033: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1310003: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1310009: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1310053: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1310039: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1310040: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1310055: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Online: ").append(n).toString());
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
        return ASLOnlineDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLOnlineDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 4046: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineServicesListTransformer(), n, "Online", "OnlineServicesList");
                break;
            }
            case 1310008: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineUpdatePackageListTransformer(), n, "Online", "OnlineUpdatePackageList");
                break;
            }
            case 1310024: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineApplicationTransformer(), n, "Online", "OnlineApplication");
                break;
            }
            case 1310025: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineServiceTransformer(), n, "Online", "OnlineService");
                break;
            }
            case 1310043: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineServicePackageTransformer(), n, "Online", "OnlineServicePackage");
                break;
            }
            case 1310044: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineServiceItemTransformer(), n, "Online", "OnlineServiceItem");
                break;
            }
            case 1310045: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineServiceInfoTransformer(), n, "Online", "OnlineServiceInfo");
                genericASLList.updateList(new OnlineOnlineServiceInfoCollector[]{new OnlineOnlineServiceInfoCollector()});
                break;
            }
            case 1310057: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineOCUUpdateTransformer(), n, "Online", "OnlineOCUUpdate");
                genericASLList.updateList(new OnlineOnlineOCUUpdateCollector[]{new OnlineOnlineOCUUpdateCollector()});
                break;
            }
            case 1310030: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineDownloadPackageMainTransformer(), n, "Online", "OnlineDownloadPackageMain");
                break;
            }
            case 1310031: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineDownloadPackageSubTransformer(), n, "Online", "OnlineDownloadPackageSub");
                break;
            }
            case 1310032: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlDowPacCurDow1310032Transformer(), n, "Online", "OnlineDownloadPackageCurrentlyDownloading");
                genericASLList.updateList(new OnlineOnlDowPacCurDow1310032Collector[]{new OnlineOnlDowPacCurDow1310032Collector()});
                break;
            }
            case 1310033: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineOnlineDownloadPackageCurrentlySelectedTransformer(), n, "Online", "OnlineDownloadPackageCurrentlySelected");
                genericASLList.updateList(new OnlineOnlineDownloadPackageCurrentlySelectedCollector[]{new OnlineOnlineDownloadPackageCurrentlySelectedCollector()});
                break;
            }
            case 1310003: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineAvailableDownloadListTransformer(), n, "Online", "AvailableDownloadList");
                break;
            }
            case 1310009: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineAvailableServerListTransformer(), n, "Online", "AvailableServerList");
                break;
            }
            case 1310053: {
                genericASLList = aSLListFactory.createGenericASLList(ASLOnlineDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "AutomaticDownloadOfUpdatesActive"), n, "Online", "AutomaticDownloadOfUpdatesActive");
                break;
            }
            case 1310039: {
                genericASLList = aSLListFactory.createGenericASLList(ASLOnlineDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "ActiveTrackingServices"), n, "Online", "ActiveTrackingServices");
                break;
            }
            case 1310040: {
                genericASLList = aSLListFactory.createGenericASLList(ASLOnlineDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "ActiveTrackingServices1"), n, "Online", "ActiveTrackingServices1");
                break;
            }
            case 1310055: {
                genericASLList = aSLListFactory.createGenericASLList(new OnlineActiveTrackingServices2Transformer(), n, "Online", "ActiveTrackingServices2");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Online: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 1310053: {
                string3 = "de.vw.mib.asl.internal.online.transformer.";
                string2 = "OnlineAutomaticDownloadOfUpdatesActiveTransformer";
                break;
            }
            case 1310039: {
                string3 = "de.vw.mib.asl.internal.online.transformer.";
                string2 = "OnlineActiveTrackingServicesTransformer";
                break;
            }
            case 1310040: {
                string3 = "de.vw.mib.asl.internal.online.transformer.";
                string2 = "OnlineActiveTrackingServices1Transformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Online: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Online", string);
    }
}

