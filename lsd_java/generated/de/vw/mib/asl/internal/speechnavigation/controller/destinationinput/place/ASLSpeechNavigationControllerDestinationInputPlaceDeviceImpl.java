/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.place;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerDestinationInputPlaceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerDestinationInputPlaceDeviceImpl INSTANCE = new ASLSpeechNavigationControllerDestinationInputPlaceDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechNavigationControllerDestinationInputPlaceDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerDestinationInputPlaceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.DestinationInput.Place";
    }

    @Override
    public int getTargetId() {
        return 14431;
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
        serviceRegister.registerService(-673107136, 14431);
        serviceRegister.registerService(-656329920, 14431);
        serviceRegister.registerService(-253676736, 14431);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.Place: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.Place: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.Place: ").append(n).toString());
    }
}

