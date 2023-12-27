/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.province;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.province.transformer.NavigationLocationInputInputFieldProvinceListTransformer;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.province.transformer.NavigationLocationInputInputFieldProvincePreviewListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.province.transformer.NavigationLocationInputInputFieldProvinceListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.province.transformer.NavigationLocationInputInputFieldProvinceListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldProvinceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldProvinceDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldProvinceDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldProvinceDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldProvinceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.Province";
    }

    @Override
    public int getTargetId() {
        return 10124;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3039, this);
        aSLListRegistry.registerASLDevice(3040, this);
        aSLListRegistry.registerASLDevice(3041, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3039: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3040: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3041: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.Province: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldProvinceDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldProvinceDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3039: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldProvincePreviewListTransformer(), n, "Navigation.LocationInput.InputField.Province", "PreviewList");
                break;
            }
            case 3040: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldProvinceListTransformer(), n, "Navigation.LocationInput.InputField.Province", "List");
                break;
            }
            case 3041: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldProvinceListInfoTransformer(), n, "Navigation.LocationInput.InputField.Province", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldProvinceListInfoCollector[]{new NavigationLocationInputInputFieldProvinceListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.Province: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

