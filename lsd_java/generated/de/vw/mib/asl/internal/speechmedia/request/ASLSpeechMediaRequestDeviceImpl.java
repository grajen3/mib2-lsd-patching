/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechmedia.request;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechMediaRequestDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechMediaRequestDeviceImpl INSTANCE = new ASLSpeechMediaRequestDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechMediaRequestDeviceImpl() {
    }

    public static ASLSpeechMediaRequestDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechMedia.Request";
    }

    @Override
    public int getTargetId() {
        return 14303;
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
        serviceRegister.registerService(-916835776, 14303);
        serviceRegister.registerService(-1520815552, 14303);
        serviceRegister.registerService(-1604701632, 14303);
        serviceRegister.registerService(-1587924416, 14303);
        serviceRegister.registerService(-1571147200, 14303);
        serviceRegister.registerService(-1504038336, 14303);
        serviceRegister.registerService(-1403375040, 14303);
        serviceRegister.registerService(-1000721856, 14303);
        serviceRegister.registerService(-983944640, 14303);
        serviceRegister.registerService(-967167424, 14303);
        serviceRegister.registerService(-1554369984, 14303);
        serviceRegister.registerService(-1537592768, 14303);
        serviceRegister.registerService(-1487261120, 14303);
        serviceRegister.registerService(-1470483904, 14303);
        serviceRegister.registerService(-1453706688, 14303);
        serviceRegister.registerService(-1436929472, 14303);
        serviceRegister.registerService(-1420152256, 14303);
        serviceRegister.registerService(-1101385152, 14303);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.Request: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.Request: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.Request: ").append(n).toString());
    }
}

