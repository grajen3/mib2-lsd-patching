/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASAPI;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import de.vw.mib.has.HASInitializer;

public final class HAS
implements HASAPI {
    private static final HAS INSTANCE = new HAS();
    private final HASEngineAPI engine = (HASEngineAPI)HAS.createAPIInstance(class$de$vw$mib$has$HASEngineAPI == null ? (class$de$vw$mib$has$HASEngineAPI = HAS.class$("de.vw.mib.has.HASEngineAPI")) : class$de$vw$mib$has$HASEngineAPI);
    private final HASFactory factory = (HASFactory)HAS.createGeneratedInstance(class$de$vw$mib$has$HASFactory == null ? (class$de$vw$mib$has$HASFactory = HAS.class$("de.vw.mib.has.HASFactory")) : class$de$vw$mib$has$HASFactory);
    static /* synthetic */ Class class$de$vw$mib$has$HASEngineAPI;
    static /* synthetic */ Class class$de$vw$mib$has$HASFactory;
    static /* synthetic */ Class class$de$vw$mib$has$HASInitializer;

    public static HAS getInstance() {
        return INSTANCE;
    }

    private HAS() {
        ((HASInitializer)HAS.createGeneratedInstance(class$de$vw$mib$has$HASInitializer == null ? (class$de$vw$mib$has$HASInitializer = HAS.class$("de.vw.mib.has.HASInitializer")) : class$de$vw$mib$has$HASInitializer)).init(this.factory, this.engine);
    }

    @Override
    public HASEngineAPI getEngine() {
        return this.engine;
    }

    @Override
    public HASFactory getFactory() {
        return this.factory;
    }

    private static Object createAPIInstance(Class clazz) {
        String string = clazz.getName();
        int n = string.lastIndexOf(46);
        string = new StringBuffer().append(string.substring(0, n)).append(".internal").append(string.substring(n)).append("Impl").toString();
        return HAS.createInstance(string);
    }

    private static Object createGeneratedInstance(Class clazz) {
        return HAS.createInstance(new StringBuffer().append("generated.").append(clazz.getName()).append("Impl").toString());
    }

    private static Object createInstance(String string) {
        Object object;
        try {
            Class clazz = Class.forName(string);
            object = clazz.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException("Could not initialize HAS", exception);
        }
        return object;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

