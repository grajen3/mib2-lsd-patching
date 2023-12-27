/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.statusbar;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarEtcCollector;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarEtcTransformer;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarNavigationTargetCollector;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarNavigationTargetTransformer;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarNavigationTimeCollector;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarNavigationTimeTransformer;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarVicsCollector;
import generated.de.vw.mib.asl.internal.statusbar.transformer.StatusbarVicsTransformer;

public final class ASLStatusbarDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLStatusbarDeviceImpl INSTANCE = new ASLStatusbarDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(4);
    private ASLListFactory listFactory;

    private ASLStatusbarDeviceImpl() {
    }

    public static ASLStatusbarDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Statusbar";
    }

    @Override
    public int getTargetId() {
        return 16101;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-185053952, this);
        aSLListRegistry.registerASLDevice(-168276736, this);
        aSLListRegistry.registerASLDevice(-134722304, this);
        aSLListRegistry.registerASLDevice(-117945088, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5110004: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 5110005: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 5110007: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 5110008: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Statusbar: ").append(n).toString());
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
        return ASLStatusbarDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLStatusbarDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5110004: {
                genericASLList = aSLListFactory.createGenericASLList(new StatusbarNavigationTargetTransformer(), n, "Statusbar", "NavigationTarget");
                genericASLList.updateList(new StatusbarNavigationTargetCollector[]{new StatusbarNavigationTargetCollector()});
                break;
            }
            case 5110005: {
                genericASLList = aSLListFactory.createGenericASLList(new StatusbarNavigationTimeTransformer(), n, "Statusbar", "NavigationTime");
                genericASLList.updateList(new StatusbarNavigationTimeCollector[]{new StatusbarNavigationTimeCollector()});
                break;
            }
            case 5110007: {
                genericASLList = aSLListFactory.createGenericASLList(new StatusbarVicsTransformer(), n, "Statusbar", "Vics");
                genericASLList.updateList(new StatusbarVicsCollector[]{new StatusbarVicsCollector()});
                break;
            }
            case 5110008: {
                genericASLList = aSLListFactory.createGenericASLList(new StatusbarEtcTransformer(), n, "Statusbar", "Etc");
                genericASLList.updateList(new StatusbarEtcCollector[]{new StatusbarEtcCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Statusbar: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

