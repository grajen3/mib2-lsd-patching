/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechmedia.tracks;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechMediaTracksDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechMediaTracksDeviceImpl INSTANCE = new ASLSpeechMediaTracksDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechMediaTracksDeviceImpl() {
    }

    public static ASLSpeechMediaTracksDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechMedia.Tracks";
    }

    @Override
    public int getTargetId() {
        return 14308;
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
        serviceRegister.registerService(-1185271232, 14308);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.Tracks: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.Tracks: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechMedia.Tracks: ").append(n).toString());
    }
}

