/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.content;

import de.vw.mib.asl.api.system.content.ContentIdValidator;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.log4mib.Logger;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ContentIdValidatorImpl
implements ContentIdValidator {
    private final ArrayList contentIdList;
    private final SystemLogger systemLogger;
    static /* synthetic */ Class class$de$vw$mib$configuration$internal$generated$AppAssemblyConfiguration$ContentId;

    public ContentIdValidatorImpl(Logger logger) {
        Preconditions.checkArgumentNotNull(logger, "The given instance of class Logger must not be null.");
        this.systemLogger = new SystemLogger(logger, super.getClass());
        this.contentIdList = new ArrayList();
        Field[] fieldArray = (class$de$vw$mib$configuration$internal$generated$AppAssemblyConfiguration$ContentId == null ? (class$de$vw$mib$configuration$internal$generated$AppAssemblyConfiguration$ContentId = ContentIdValidatorImpl.class$("de.vw.mib.configuration.internal.generated.AppAssemblyConfiguration$ContentId")) : class$de$vw$mib$configuration$internal$generated$AppAssemblyConfiguration$ContentId).getFields();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            this.contentIdList.add(fieldArray[i2].getName());
        }
        this.contentIdList.add("HMI_OFF");
    }

    @Override
    public boolean isValid(String string) {
        return !this.isContentIdNull(string) && !this.isContentIdEmpty(string) && this.isContentIdExisting(string);
    }

    private boolean isContentIdNull(String string) {
        if (string == null) {
            this.systemLogger.error(new StringBuffer().append("Provided content id ").append(string).append(" is null.").toString());
            return true;
        }
        return false;
    }

    private boolean isContentIdEmpty(String string) {
        if (string.equals("")) {
            this.systemLogger.error(new StringBuffer().append("Provided content id ").append(string).append(" is empty.").toString());
            return true;
        }
        return false;
    }

    private boolean isContentIdExisting(String string) {
        boolean bl = this.contentIdList.contains(string);
        if (!bl) {
            this.systemLogger.error(new StringBuffer().append("Provided content id ").append(string).append(" is not existing.").toString());
        }
        return bl;
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

