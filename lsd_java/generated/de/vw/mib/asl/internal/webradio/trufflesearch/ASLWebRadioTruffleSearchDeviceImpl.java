/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.webradio.trufflesearch;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLWebRadioTruffleSearchDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLWebRadioTruffleSearchDeviceImpl INSTANCE = new ASLWebRadioTruffleSearchDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLWebRadioTruffleSearchDeviceImpl() {
    }

    public static ASLWebRadioTruffleSearchDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "WebRadio.TruffleSearch";
    }

    @Override
    public int getTargetId() {
        return 17002;
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
        serviceRegister.registerService(-1718789312, 17002);
        serviceRegister.registerService(-1702012096, 17002);
        serviceRegister.registerService(-1685234880, 17002);
        serviceRegister.registerService(-1668457664, 17002);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device WebRadio.TruffleSearch: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device WebRadio.TruffleSearch: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device WebRadio.TruffleSearch: ").append(n).toString());
    }
}

