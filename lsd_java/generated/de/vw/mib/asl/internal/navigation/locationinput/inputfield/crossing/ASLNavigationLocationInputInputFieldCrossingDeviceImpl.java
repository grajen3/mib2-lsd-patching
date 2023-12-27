/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.crossing;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.crossing.transformer.NavigationLocationInputInputFieldCrossingListTransformer;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.crossing.transformer.NavigationLocationInputInputFieldCrossingPreviewListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.crossing.transformer.NavigationLocationInputInputFieldCrossingListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.crossing.transformer.NavigationLocationInputInputFieldCrossingListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldCrossingDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldCrossingDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldCrossingDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldCrossingDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldCrossingDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.Crossing";
    }

    @Override
    public int getTargetId() {
        return 10129;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3072, this);
        aSLListRegistry.registerASLDevice(3073, this);
        aSLListRegistry.registerASLDevice(3074, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3072: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3073: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3074: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.Crossing: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldCrossingDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldCrossingDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3072: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldCrossingPreviewListTransformer(), n, "Navigation.LocationInput.InputField.Crossing", "PreviewList");
                break;
            }
            case 3073: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldCrossingListTransformer(), n, "Navigation.LocationInput.InputField.Crossing", "List");
                break;
            }
            case 3074: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldCrossingListInfoTransformer(), n, "Navigation.LocationInput.InputField.Crossing", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldCrossingListInfoCollector[]{new NavigationLocationInputInputFieldCrossingListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.Crossing: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

