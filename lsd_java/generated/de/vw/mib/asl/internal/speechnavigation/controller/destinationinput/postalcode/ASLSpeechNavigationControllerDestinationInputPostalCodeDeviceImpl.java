/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.postalcode;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerDestinationInputPostalCodeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerDestinationInputPostalCodeDeviceImpl INSTANCE = new ASLSpeechNavigationControllerDestinationInputPostalCodeDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechNavigationControllerDestinationInputPostalCodeDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerDestinationInputPostalCodeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.DestinationInput.PostalCode";
    }

    @Override
    public int getTargetId() {
        return 14418;
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
        serviceRegister.registerService(-1864289472, 14418);
        serviceRegister.registerService(-1847512256, 14418);
        serviceRegister.registerService(-102681792, 14418);
        serviceRegister.registerService(-85904576, 14418);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.PostalCode: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.PostalCode: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.PostalCode: ").append(n).toString());
    }
}

