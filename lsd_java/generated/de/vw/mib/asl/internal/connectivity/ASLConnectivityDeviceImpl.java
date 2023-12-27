/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityConfigurationListTransformer;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityNetworkProviderListTransformer;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityPortListTransformer;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityWLANAvailableChannelsTransformer;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityWLANHotspotHotspotListNotAvailableNameTransformer;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityWLANHotspotHotspotListTransformer;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityWizardWlanHotspotListTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.connectivity.transformer.ConnectivityBlockedAccessDetailsCollector;
import generated.de.vw.mib.asl.internal.connectivity.transformer.ConnectivityBlockedAccessDetailsTransformer;
import generated.de.vw.mib.asl.internal.connectivity.transformer.ConnectivityCurrentConnectionDetailsCollector;
import generated.de.vw.mib.asl.internal.connectivity.transformer.ConnectivityCurrentConnectionDetailsTransformer;

public final class ASLConnectivityDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLConnectivityDeviceImpl INSTANCE = new ASLConnectivityDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(9);
    private ASLListFactory listFactory;

    private ASLConnectivityDeviceImpl() {
    }

    public static ASLConnectivityDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Connectivity";
    }

    @Override
    public int getTargetId() {
        return 10024;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(364, this);
        aSLListRegistry.registerASLDevice(1379140352, this);
        aSLListRegistry.registerASLDevice(365, this);
        aSLListRegistry.registerASLDevice(366, this);
        aSLListRegistry.registerASLDevice(367, this);
        aSLListRegistry.registerASLDevice(4004, this);
        aSLListRegistry.registerASLDevice(1899234048, this);
        aSLListRegistry.registerASLDevice(352, this);
        aSLListRegistry.registerASLDevice(4023, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(33620032, 10024);
        serviceRegister.registerService(235601984, 10024);
        serviceRegister.registerService(940179520, 10024);
        serviceRegister.registerService(1393361728, 10024);
        serviceRegister.registerService(1410138944, 10024);
        serviceRegister.registerService(1124926272, 10024);
        serviceRegister.registerService(1963655232, 10024);
        serviceRegister.registerService(269156416, 10024);
        serviceRegister.registerService(587923520, 10024);
        serviceRegister.registerService(1259144000, 10024);
        serviceRegister.registerService(906690624, 10024);
        serviceRegister.registerService(1359807296, 10024);
        serviceRegister.registerService(1561133888, 10024);
        serviceRegister.registerService(1594688320, 10024);
        serviceRegister.registerService(956956736, 10024);
        serviceRegister.registerService(50397248, 10024);
        serviceRegister.registerService(0x4010040, 10024);
        serviceRegister.registerService(1242366784, 10024);
        serviceRegister.registerService(83951680, 10024);
        serviceRegister.registerService(1074594624, 10024);
        serviceRegister.registerService(1544159296, 10024);
        serviceRegister.registerService(100728896, 10024);
        serviceRegister.registerService(117506112, 10024);
        serviceRegister.registerService(134283328, 10024);
        serviceRegister.registerService(151060544, 10024);
        serviceRegister.registerService(167837760, 10024);
        serviceRegister.registerService(184614976, 10024);
        serviceRegister.registerService(252379200, 10024);
        serviceRegister.registerService(201392192, 10024);
        serviceRegister.registerService(218169408, 10024);
        serviceRegister.registerService(234946624, 10024);
        serviceRegister.registerService(285933632, 10024);
        serviceRegister.registerService(1477247808, 10024);
        serviceRegister.registerService(1108149056, 10024);
        serviceRegister.registerService(1091371840, 10024);
        serviceRegister.registerService(1208680512, 10024);
        serviceRegister.registerService(251723840, 10024);
        serviceRegister.registerService(0x10010040, 10024);
        serviceRegister.registerService(0x11010040, 10024);
        serviceRegister.registerService(302055488, 10024);
        serviceRegister.registerService(1007288384, 10024);
        serviceRegister.registerService(1275789376, 10024);
        serviceRegister.registerService(1024065600, 10024);
        serviceRegister.registerService(1040842816, 10024);
        serviceRegister.registerService(-1224081344, 10024);
        serviceRegister.registerService(1057620032, 10024);
        serviceRegister.registerService(-1207304128, 10024);
        serviceRegister.registerService(0x400A0040, 10024);
        serviceRegister.registerService(1175257920, 10024);
        serviceRegister.registerService(1192035136, 10024);
        serviceRegister.registerService(1208812352, 10024);
        serviceRegister.registerService(1225589568, 10024);
        serviceRegister.registerService(1477115968, 10024);
        serviceRegister.registerService(621477952, 10024);
        serviceRegister.registerService(638255168, 10024);
        serviceRegister.registerService(655032384, 10024);
        serviceRegister.registerService(671809600, 10024);
        serviceRegister.registerService(688586816, 10024);
        serviceRegister.registerService(705364032, 10024);
        serviceRegister.registerService(722141248, 10024);
        serviceRegister.registerService(738918464, 10024);
        serviceRegister.registerService(755695680, 10024);
        serviceRegister.registerService(772472896, 10024);
        serviceRegister.registerService(318832704, 10024);
        serviceRegister.registerService(0x14010040, 10024);
        serviceRegister.registerService(352387136, 10024);
        serviceRegister.registerService(369164352, 10024);
        serviceRegister.registerService(1695219776, 10024);
        serviceRegister.registerService(554303552, 10024);
        serviceRegister.registerService(402718784, 10024);
        serviceRegister.registerService(419496000, 10024);
        serviceRegister.registerService(1343030080, 10024);
        serviceRegister.registerService(1577911104, 10024);
        serviceRegister.registerService(1611465536, 10024);
        serviceRegister.registerService(453050432, 10024);
        serviceRegister.registerService(-1190526912, 10024);
        serviceRegister.registerService(469827648, 10024);
        serviceRegister.registerService(-703987648, 10024);
        serviceRegister.registerService(-670433216, 10024);
        serviceRegister.registerService(-1173749696, 10024);
        serviceRegister.registerService(486604864, 10024);
        serviceRegister.registerService(503382080, 10024);
        serviceRegister.registerService(520159296, 10024);
        serviceRegister.registerService(1376584512, 10024);
        serviceRegister.registerService(536936512, 10024);
        serviceRegister.registerService(553713728, 10024);
        serviceRegister.registerService(1275921216, 10024);
        serviceRegister.registerService(1292698432, 10024);
        serviceRegister.registerService(1494025024, 10024);
        serviceRegister.registerService(1443693376, 10024);
        serviceRegister.registerService(1426916160, 10024);
        serviceRegister.registerService(1460470592, 10024);
        serviceRegister.registerService(1510802240, 10024);
        serviceRegister.registerService(1527579456, 10024);
        serviceRegister.registerService(1544356672, 10024);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 364: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 210002: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 365: {
                nArray = ListColumnsUtil.getIntArrayByBits(532545536, 11);
                break;
            }
            case 366: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 367: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 4004: {
                nArray = ListColumnsUtil.getIntArrayByBits(253, 7);
                break;
            }
            case 210033: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 352: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 4023: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Connectivity: ").append(n).toString());
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
        return ASLConnectivityDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLConnectivityDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 364: {
                genericASLList = aSLListFactory.createGenericASLList(new ConnectivityPortListTransformer(), n, "Connectivity", "PortList");
                break;
            }
            case 210002: {
                genericASLList = aSLListFactory.createGenericASLList(new ConnectivityNetworkProviderListTransformer(), n, "Connectivity", "NetworkProviderList");
                break;
            }
            case 365: {
                genericASLList = aSLListFactory.createGenericASLList(new ConnectivityCurrentConnectionDetailsTransformer(), n, "Connectivity", "CurrentConnectionDetails");
                genericASLList.updateList(new ConnectivityCurrentConnectionDetailsCollector[]{new ConnectivityCurrentConnectionDetailsCollector()});
                break;
            }
            case 366: {
                genericASLList = aSLListFactory.createGenericASLList(new ConnectivityBlockedAccessDetailsTransformer(), n, "Connectivity", "BlockedAccessDetails");
                genericASLList.updateList(new ConnectivityBlockedAccessDetailsCollector[]{new ConnectivityBlockedAccessDetailsCollector()});
                break;
            }
            case 367: {
                genericASLList = aSLListFactory.createGenericASLList(new ConnectivityConfigurationListTransformer(), n, "Connectivity", "ConfigurationList");
                break;
            }
            case 4004: {
                genericASLList = aSLListFactory.createGenericASLList(new ConnectivityWLANHotspotHotspotListTransformer(), n, "Connectivity", "WLANHotspotHotspotList");
                break;
            }
            case 210033: {
                genericASLList = aSLListFactory.createGenericASLList(new ConnectivityWizardWlanHotspotListTransformer(), n, "Connectivity", "WizardWlanHotspotList");
                break;
            }
            case 352: {
                genericASLList = aSLListFactory.createGenericASLList(new ConnectivityWLANAvailableChannelsTransformer(), n, "Connectivity", "WLANAvailableChannels");
                break;
            }
            case 4023: {
                genericASLList = aSLListFactory.createGenericASLList(new ConnectivityWLANHotspotHotspotListNotAvailableNameTransformer(), n, "Connectivity", "WLANHotspotHotspotListNotAvailableName");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Connectivity: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

