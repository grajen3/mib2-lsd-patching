/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.state;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.state.transformer.NavigationLocationInputInputFieldStateListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.state.transformer.NavigationLocationInputInputFieldStateListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.state.transformer.NavigationLocationInputInputFieldStateListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldStateDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldStateDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldStateDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldStateDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldStateDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.State";
    }

    @Override
    public int getTargetId() {
        return 10123;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3033, this);
        aSLListRegistry.registerASLDevice(3034, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3033: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3034: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.State: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldStateDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldStateDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3033: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldStateListTransformer(), n, "Navigation.LocationInput.InputField.State", "List");
                break;
            }
            case 3034: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldStateListInfoTransformer(), n, "Navigation.LocationInput.InputField.State", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldStateListInfoCollector[]{new NavigationLocationInputInputFieldStateListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.State: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

