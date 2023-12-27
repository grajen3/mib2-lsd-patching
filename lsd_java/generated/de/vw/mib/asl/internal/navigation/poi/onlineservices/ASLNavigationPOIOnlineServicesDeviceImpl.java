/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi.onlineservices;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.NavigationPOIOnlineServicesResultListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.NavigationPOIOnlineServicesGoogleLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.NavigationPOIOnlineServicesGoogleLocationTransformer;

public final class ASLNavigationPOIOnlineServicesDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationPOIOnlineServicesDeviceImpl INSTANCE = new ASLNavigationPOIOnlineServicesDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationPOIOnlineServicesDeviceImpl() {
    }

    public static ASLNavigationPOIOnlineServicesDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.POI.OnlineServices";
    }

    @Override
    public int getTargetId() {
        return 10143;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3748, this);
        aSLListRegistry.registerASLDevice(3760, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1861615552, 10143);
        serviceRegister.registerService(1846149184, 10143);
        serviceRegister.registerService(1862926400, 10143);
        serviceRegister.registerService(1879703616, 10143);
        serviceRegister.registerService(-1878392768, 10143);
        serviceRegister.registerService(1896480832, 10143);
        serviceRegister.registerService(-1794506688, 10143);
        serviceRegister.registerService(-1844838336, 10143);
        serviceRegister.registerService(1913258048, 10143);
        serviceRegister.registerService(1930035264, 10143);
        serviceRegister.registerService(-1727397824, 10143);
        serviceRegister.registerService(1946812480, 10143);
        serviceRegister.registerService(-1257635776, 10143);
        serviceRegister.registerService(1963589696, 10143);
        serviceRegister.registerService(1980366912, 10143);
        serviceRegister.registerService(-1559625664, 10143);
        serviceRegister.registerService(-1576402880, 10143);
        serviceRegister.registerService(1997144128, 10143);
        serviceRegister.registerService(2013921344, 10143);
        serviceRegister.registerService(2030698560, 10143);
        serviceRegister.registerService(2047475776, 10143);
        serviceRegister.registerService(-1811283904, 10143);
        serviceRegister.registerService(-1828061120, 10143);
        serviceRegister.registerService(2064252992, 10143);
        serviceRegister.registerService(2081030208, 10143);
        serviceRegister.registerService(2097807424, 10143);
        serviceRegister.registerService(2114584640, 10143);
        serviceRegister.registerService(2131361856, 10143);
        serviceRegister.registerService(-2146828224, 10143);
        serviceRegister.registerService(-2130051008, 10143);
        serviceRegister.registerService(-2113273792, 10143);
        serviceRegister.registerService(-2096496576, 10143);
        serviceRegister.registerService(-2079719360, 10143);
        serviceRegister.registerService(-2062942144, 10143);
        serviceRegister.registerService(-2029387712, 10143);
        serviceRegister.registerService(-2012610496, 10143);
        serviceRegister.registerService(-1995833280, 10143);
        serviceRegister.registerService(-1979056064, 10143);
        serviceRegister.registerService(-1962278848, 10143);
        serviceRegister.registerService(-1945501632, 10143);
        serviceRegister.registerService(-1744175040, 10143);
        serviceRegister.registerService(-1760952256, 10143);
        serviceRegister.registerService(-1928724416, 10143);
        serviceRegister.registerService(-1777729472, 10143);
        serviceRegister.registerService(-1911947200, 10143);
        serviceRegister.registerService(-1895169984, 10143);
        serviceRegister.registerService(-1710620608, 10143);
        serviceRegister.registerService(-70774720, 10143);
        serviceRegister.registerService(-53997504, 10143);
        serviceRegister.registerService(-37220288, 10143);
        serviceRegister.registerService(113840192, 10143);
        serviceRegister.registerService(1170804800, 10143);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3748: {
                nArray = ListColumnsUtil.getSimpleIntArray(9);
                break;
            }
            case 3760: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.POI.OnlineServices: ").append(n).toString());
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
        return ASLNavigationPOIOnlineServicesDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationPOIOnlineServicesDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3748: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOIOnlineServicesResultListTransformer(), n, "Navigation.POI.OnlineServices", "ResultList");
                break;
            }
            case 3760: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOIOnlineServicesGoogleLocationTransformer(), n, "Navigation.POI.OnlineServices", "GoogleLocation");
                genericASLList.updateList(new NavigationPOIOnlineServicesGoogleLocationCollector[]{new NavigationPOIOnlineServicesGoogleLocationCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.POI.OnlineServices: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

