/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputLocationTransformer;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputNextRefinementsCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.transformer.NavigationLocationInputNextRefinementsTransformer;

public final class ASLNavigationLocationInputDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputDeviceImpl INSTANCE = new ASLNavigationLocationInputDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputDeviceImpl() {
    }

    public static ASLNavigationLocationInputDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput";
    }

    @Override
    public int getTargetId() {
        return 10120;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2829, this);
        aSLListRegistry.registerASLDevice(2830, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-385286080, 10120);
        serviceRegister.registerService(1208614976, 10120);
        serviceRegister.registerService(1795686464, 10120);
        serviceRegister.registerService(1812463680, 10120);
        serviceRegister.registerService(1829240896, 10120);
        serviceRegister.registerService(1846018112, 10120);
        serviceRegister.registerService(1862795328, 10120);
        serviceRegister.registerService(1879572544, 10120);
        serviceRegister.registerService(218759232, 10120);
        serviceRegister.registerService(1913126976, 10120);
        serviceRegister.registerService(336265280, 10120);
        serviceRegister.registerService(46731328, 10120);
        serviceRegister.registerService(1204359232, 10120);
        serviceRegister.registerService(1825116224, 10120);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2829: {
                nArray = ListColumnsUtil.getIntArrayByBits(-1075904256, 15);
                break;
            }
            case 2830: {
                nArray = ListColumnsUtil.getSimpleIntArray(33);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput: ").append(n).toString());
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
        return ASLNavigationLocationInputDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2829: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputNextRefinementsTransformer(), n, "Navigation.LocationInput", "NextRefinements");
                genericASLList.updateList(new NavigationLocationInputNextRefinementsCollector[]{new NavigationLocationInputNextRefinementsCollector()});
                break;
            }
            case 2830: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputLocationTransformer(), n, "Navigation.LocationInput", "Location");
                genericASLList.updateList(new NavigationLocationInputLocationCollector[]{new NavigationLocationInputLocationCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

