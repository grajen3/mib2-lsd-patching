/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.mapcode;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.mapcode.transformer.NavigationLocationInputInputFieldMapcodeListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.mapcode.transformer.NavigationLocationInputInputFieldMapcodeListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldMapcodeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldMapcodeDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldMapcodeDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldMapcodeDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldMapcodeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.Mapcode";
    }

    @Override
    public int getTargetId() {
        return 12116;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-856682496, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1110220: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.Mapcode: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldMapcodeDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldMapcodeDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1110220: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldMapcodeListInfoTransformer(), n, "Navigation.LocationInput.InputField.Mapcode", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldMapcodeListInfoCollector[]{new NavigationLocationInputInputFieldMapcodeListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.Mapcode: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

