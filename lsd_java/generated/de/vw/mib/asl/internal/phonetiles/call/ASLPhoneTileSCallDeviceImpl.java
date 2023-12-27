/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phonetiles.call;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.phonetiles.call.transformer.PhoneTileSCallCallInformationsCollector;
import generated.de.vw.mib.asl.internal.phonetiles.call.transformer.PhoneTileSCallCallInformationsTransformer;

public final class ASLPhoneTileSCallDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneTileSCallDeviceImpl INSTANCE = new ASLPhoneTileSCallDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLPhoneTileSCallDeviceImpl() {
    }

    public static ASLPhoneTileSCallDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "PhoneTileS.Call";
    }

    @Override
    public int getTargetId() {
        return 17703;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-127769088, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-163879360, 17703);
        serviceRegister.registerService(-532978112, 17703);
        serviceRegister.registerService(-331651520, 17703);
        serviceRegister.registerService(-516200896, 17703);
        serviceRegister.registerService(-314874304, 17703);
        serviceRegister.registerService(-499423680, 17703);
        serviceRegister.registerService(-298097088, 17703);
        serviceRegister.registerService(-482646464, 17703);
        serviceRegister.registerService(-281319872, 17703);
        serviceRegister.registerService(-465869248, 17703);
        serviceRegister.registerService(-264542656, 17703);
        serviceRegister.registerService(-449092032, 17703);
        serviceRegister.registerService(-247765440, 17703);
        serviceRegister.registerService(-432314816, 17703);
        serviceRegister.registerService(-230988224, 17703);
        serviceRegister.registerService(-415537600, 17703);
        serviceRegister.registerService(-214211008, 17703);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 6710008: {
                nArray = ListColumnsUtil.getSimpleIntArray(16);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneTileS.Call: ").append(n).toString());
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
        return ASLPhoneTileSCallDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneTileSCallDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 6710008: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneTileSCallCallInformationsTransformer(), n, "PhoneTileS.Call", "callInformations");
                genericASLList.updateList(new PhoneTileSCallCallInformationsCollector[]{new PhoneTileSCallCallInformationsCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device PhoneTileS.Call: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

