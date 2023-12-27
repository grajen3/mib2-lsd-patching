/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.housenumber;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.housenumber.transformer.SpeechNavigationControllerDestinationInputHousenumberHousenumbersTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.housenumber.transformer.SpeechNavigationControllerDestinationInputHousenumberSelectedHousenumberTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl INSTANCE = new ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.DestinationInput.Housenumber";
    }

    @Override
    public int getTargetId() {
        return 14420;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2013803520, this);
        aSLListRegistry.registerASLDevice(2030580736, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1797180608, 14420);
        serviceRegister.registerService(-1713294528, 14420);
        serviceRegister.registerService(-1495190720, 14420);
        serviceRegister.registerService(-1478413504, 14420);
        serviceRegister.registerService(-874433728, 14420);
        serviceRegister.registerService(-857656512, 14420);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410040: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3410041: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.Housenumber: ").append(n).toString());
            }
        }
        return nArray;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.getGenericASLList(n);
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerDestinationInputHousenumberDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410040: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputHousenumberHousenumbersTransformer(), n, "SpeechNavigation.Controller.DestinationInput.Housenumber", "Housenumbers");
                break;
            }
            case 3410041: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputHousenumberSelectedHousenumberTransformer(), n, "SpeechNavigation.Controller.DestinationInput.Housenumber", "SelectedHousenumber");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.DestinationInput.Housenumber: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

