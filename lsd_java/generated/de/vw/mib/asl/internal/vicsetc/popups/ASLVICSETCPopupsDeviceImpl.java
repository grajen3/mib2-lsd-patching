/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.popups;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.asl.internal.vicsetc.popups.transformer.VICSETCPopupsMessageGraphicRLTransformer;
import de.vw.mib.asl.internal.vicsetc.popups.transformer.VICSETCPopupsMessageTextRLTransformer;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLVICSETCPopupsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLVICSETCPopupsDeviceImpl INSTANCE = new ASLVICSETCPopupsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLVICSETCPopupsDeviceImpl() {
    }

    public static ASLVICSETCPopupsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "VICSETC.Popups";
    }

    @Override
    public int getTargetId() {
        return 16607;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1771721984, this);
        aSLListRegistry.registerASLDevice(1788499200, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(108221760, 16607);
        serviceRegister.registerService(359880000, 16607);
        serviceRegister.registerService(376657216, 16607);
        serviceRegister.registerService(1148409152, 16607);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5610089: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610090: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.Popups: ").append(n).toString());
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
        return ASLVICSETCPopupsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLVICSETCPopupsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5610089: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCPopupsMessageTextRLTransformer(), n, "VICSETC.Popups", "MessageTextRL");
                break;
            }
            case 5610090: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCPopupsMessageGraphicRLTransformer(), n, "VICSETC.Popups", "MessageGraphicRL");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device VICSETC.Popups: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

