/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.state;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerDestinationInputStateDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerDestinationInputStateDeviceImpl INSTANCE = new ASLSpeechNavigationControllerDestinationInputStateDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechNavigationControllerDestinationInputStateDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerDestinationInputStateDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.DestinationInput.State";
    }

    @Override
    public int getTargetId() {
        return 14427;
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
        serviceRegister.registerService(-1042205888, 14427);
        serviceRegister.registerService(-1025428672, 14427);
        serviceRegister.registerService(-941542592, 14427);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.State: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.State: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.State: ").append(n).toString());
    }
}

