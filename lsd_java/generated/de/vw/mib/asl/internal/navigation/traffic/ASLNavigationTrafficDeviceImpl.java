/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCOverviewListTransformer;
import de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCOverviewSubListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCMessageDetailCollector;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCMessageDetailTransformer;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCXUrgentMessageCollector;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCXUrgentMessageTransformer;

public final class ASLNavigationTrafficDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationTrafficDeviceImpl INSTANCE = new ASLNavigationTrafficDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(4);
    private ASLListFactory listFactory;

    private ASLNavigationTrafficDeviceImpl() {
    }

    public static ASLNavigationTrafficDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Traffic";
    }

    @Override
    public int getTargetId() {
        return 10060;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1016, this);
        aSLListRegistry.registerASLDevice(1017, this);
        aSLListRegistry.registerASLDevice(1018, this);
        aSLListRegistry.registerASLDevice(2471, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(134414400, 10060);
        serviceRegister.registerService(151191616, 10060);
        serviceRegister.registerService(167968832, 10060);
        serviceRegister.registerService(184746048, 10060);
        serviceRegister.registerService(201523264, 10060);
        serviceRegister.registerService(218300480, 10060);
        serviceRegister.registerService(235077696, 10060);
        serviceRegister.registerService(251854912, 10060);
        serviceRegister.registerService(268632128, 10060);
        serviceRegister.registerService(285409344, 10060);
        serviceRegister.registerService(302186560, 10060);
        serviceRegister.registerService(318963776, 10060);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1016: {
                nArray = ListColumnsUtil.getIntArrayByBits(117587200, 9);
                break;
            }
            case 1017: {
                nArray = ListColumnsUtil.getIntArrayByBits(-1209466880, 11);
                break;
            }
            case 1018: {
                nArray = ListColumnsUtil.getIntArrayByBits(1121, 4);
                break;
            }
            case 2471: {
                nArray = ListColumnsUtil.getSimpleIntArray(13);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Traffic: ").append(n).toString());
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
        return ASLNavigationTrafficDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationTrafficDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1016: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationTrafficTMCMessageDetailTransformer(), n, "Navigation.Traffic", "TMCMessageDetail");
                genericASLList.updateList(new NavigationTrafficTMCMessageDetailCollector[]{new NavigationTrafficTMCMessageDetailCollector()});
                break;
            }
            case 1017: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationTrafficTMCOverviewListTransformer(), n, "Navigation.Traffic", "TMCOverviewList");
                break;
            }
            case 1018: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationTrafficTMCOverviewSubListTransformer(), n, "Navigation.Traffic", "TMCOverviewSubList");
                break;
            }
            case 2471: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationTrafficTMCXUrgentMessageTransformer(), n, "Navigation.Traffic", "TMCXUrgentMessage");
                genericASLList.updateList(new NavigationTrafficTMCXUrgentMessageCollector[]{new NavigationTrafficTMCXUrgentMessageCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Traffic: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

