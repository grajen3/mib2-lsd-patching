/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechmedia.listhandling;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechMediaListHandlingDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechMediaListHandlingDeviceImpl INSTANCE = new ASLSpeechMediaListHandlingDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechMediaListHandlingDeviceImpl() {
    }

    public static ASLSpeechMediaListHandlingDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechMedia.ListHandling";
    }

    @Override
    public int getTargetId() {
        return 14306;
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
        serviceRegister.registerService(-1386597824, 14306);
        serviceRegister.registerService(-1034276288, 14306);
        serviceRegister.registerService(-1017499072, 14306);
        serviceRegister.registerService(-900058560, 14306);
        serviceRegister.registerService(-1353043392, 14306);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.ListHandling: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.ListHandling: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.ListHandling: ").append(n).toString());
    }
}

