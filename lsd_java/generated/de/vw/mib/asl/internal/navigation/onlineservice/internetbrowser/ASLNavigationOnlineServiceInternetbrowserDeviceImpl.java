/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.onlineservice.internetbrowser;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationOnlineServiceInternetbrowserDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationOnlineServiceInternetbrowserDeviceImpl INSTANCE = new ASLNavigationOnlineServiceInternetbrowserDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavigationOnlineServiceInternetbrowserDeviceImpl() {
    }

    public static ASLNavigationOnlineServiceInternetbrowserDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.OnlineService.Internetbrowser";
    }

    @Override
    public int getTargetId() {
        return 12110;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(449384512, 12110);
        serviceRegister.registerService(466161728, 12110);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.OnlineService.Internetbrowser: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.OnlineService.Internetbrowser: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.OnlineService.Internetbrowser: ").append(n).toString());
    }
}

