/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.fmtext;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.asl.internal.vicsetc.fmtext.transformer.VICSETCFmTextMessageImagesRLTransformer;
import de.vw.mib.asl.internal.vicsetc.fmtext.transformer.VICSETCFmTextMessageTopicsTransformer;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLVICSETCFmTextDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLVICSETCFmTextDeviceImpl INSTANCE = new ASLVICSETCFmTextDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLVICSETCFmTextDeviceImpl() {
    }

    public static ASLVICSETCFmTextDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "VICSETC.FmText";
    }

    @Override
    public int getTargetId() {
        return 16602;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(328881408, this);
        aSLListRegistry.registerASLDevice(345658624, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(7558464, 16602);
        serviceRegister.registerService(24335680, 16602);
        serviceRegister.registerService(930305344, 16602);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5610003: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610004: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.FmText: ").append(n).toString());
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
        return ASLVICSETCFmTextDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLVICSETCFmTextDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5610003: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCFmTextMessageTopicsTransformer(), n, "VICSETC.FmText", "MessageTopics");
                break;
            }
            case 5610004: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCFmTextMessageImagesRLTransformer(), n, "VICSETC.FmText", "MessageImagesRL");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device VICSETC.FmText: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

