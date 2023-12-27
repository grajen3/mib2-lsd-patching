/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.audio.browser.search;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLAVDCAudioBrowserSearchDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAVDCAudioBrowserSearchDeviceImpl INSTANCE = new ASLAVDCAudioBrowserSearchDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLAVDCAudioBrowserSearchDeviceImpl() {
    }

    public static ASLAVDCAudioBrowserSearchDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AVDC.Audio.Browser.Search";
    }

    @Override
    public int getTargetId() {
        return 10006;
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
        serviceRegister.registerService(1476395072, 10006);
        serviceRegister.registerService(1493172288, 10006);
        serviceRegister.registerService(1509949504, 10006);
        serviceRegister.registerService(1526726720, 10006);
        serviceRegister.registerService(1543503936, 10006);
        serviceRegister.registerService(1560281152, 10006);
        serviceRegister.registerService(406129728, 10006);
        serviceRegister.registerService(2114388032, 10006);
        serviceRegister.registerService(339020864, 10006);
        serviceRegister.registerService(1577058368, 10006);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Audio.Browser.Search: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Audio.Browser.Search: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Audio.Browser.Search: ").append(n).toString());
    }
}

