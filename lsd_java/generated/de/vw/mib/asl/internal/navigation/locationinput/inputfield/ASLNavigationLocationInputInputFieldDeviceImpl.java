/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationLocationInputInputFieldDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavigationLocationInputInputFieldDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField";
    }

    @Override
    public int getTargetId() {
        return 10121;
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
        serviceRegister.registerService(1929904192, 10121);
        serviceRegister.registerService(1946681408, 10121);
        serviceRegister.registerService(1963458624, 10121);
        serviceRegister.registerService(1980235840, 10121);
        serviceRegister.registerService(1997013056, 10121);
        serviceRegister.registerService(63508544, 10121);
        serviceRegister.registerService(2013790272, 10121);
        serviceRegister.registerService(2030567488, 10121);
        serviceRegister.registerService(2047344704, 10121);
        serviceRegister.registerService(2064121920, 10121);
        serviceRegister.registerService(2080899136, 10121);
        serviceRegister.registerService(2097676352, 10121);
        serviceRegister.registerService(2114453568, 10121);
        serviceRegister.registerService(2131230784, 10121);
        serviceRegister.registerService(-2146959296, 10121);
        serviceRegister.registerService(-2130182080, 10121);
        serviceRegister.registerService(1393098816, 10121);
        serviceRegister.registerService(1858670656, 10121);
        serviceRegister.registerService(1875447872, 10121);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField: ").append(n).toString());
    }
}

