/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features;

import de.vw.mib.asl.api.speechengine.features.GenericTargetFeature;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import java.lang.reflect.Field;

public abstract class AbstractGenericFeature
implements GenericTargetFeature {
    final AbstractClassifiedLogger logger;
    static /* synthetic */ Class array$Lde$vw$mib$asl$api$speechengine$features$model$Command;
    static /* synthetic */ Class array$Lde$vw$mib$asl$api$speechengine$features$model$Prompt;

    public AbstractGenericFeature(AbstractClassifiedLogger abstractClassifiedLogger) {
        this.logger = abstractClassifiedLogger;
    }

    @Override
    public void setInt(int n, int n2) {
        this.logger.error().append(new StringBuffer().append("setInt() called with unknown keyId : ").append(n).append(" on feature : ").append(super.getClass().getName()).append(" with featureId : ").append(this.getFeatureType()).toString()).log();
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        this.logger.error().append(new StringBuffer().append("setBoolean() called with unknown keyId : ").append(n).append(" on feature : ").append(super.getClass().getName()).append(" with featureId : ").append(this.getFeatureType()).toString());
    }

    @Override
    public void setOrderedPrompts(int n, OrderedPrompts orderedPrompts) {
        this.logger.error().append(new StringBuffer().append("setOrderedPrompts() called with unknown keyId : ").append(n).append(" on feature : ").append(super.getClass().getName()).append(" with featureId : ").append(this.getFeatureType()).toString());
    }

    @Override
    public void setEvent(int n, Event event) {
        this.logger.error().append(new StringBuffer().append("setEvent() called with unknown keyId : ").append(n).append(" on feature : ").append(super.getClass().getName()).append(" with featureId : ").append(this.getFeatureType()).toString());
    }

    public String toString() {
        String string = super.getClass().getName().substring(super.getClass().getName().lastIndexOf(".") + 1);
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.append("={");
        Field[] fieldArray = super.getClass().getDeclaredFields();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            fieldArray[i2].setAccessible(true);
            stringBuffer.append(fieldArray[i2].getName());
            stringBuffer.append("=");
            try {
                Object object = fieldArray[i2].get(this);
                if (object == null) {
                    stringBuffer.append("{null}");
                } else if (object.getClass() == (array$Lde$vw$mib$asl$api$speechengine$features$model$Command == null ? AbstractGenericFeature.class$("[Lde.vw.mib.asl.api.speechengine.features.model.Command;") : array$Lde$vw$mib$asl$api$speechengine$features$model$Command)) {
                    stringBuffer.append(this.commandArrayToString((Command[])object));
                } else if (object.getClass() == (array$Lde$vw$mib$asl$api$speechengine$features$model$Prompt == null ? AbstractGenericFeature.class$("[Lde.vw.mib.asl.api.speechengine.features.model.Prompt;") : array$Lde$vw$mib$asl$api$speechengine$features$model$Prompt)) {
                    stringBuffer.append(this.promptArrayToString((Prompt[])object));
                } else {
                    stringBuffer.append(object.toString());
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                stringBuffer.append("{???}");
            }
            catch (IllegalAccessException illegalAccessException) {
                stringBuffer.append("{???}");
            }
            if (i2 >= fieldArray.length - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private String commandArrayToString(Command[] commandArray) {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (int i2 = 0; i2 < commandArray.length; ++i2) {
            if (commandArray[i2] == null) {
                stringBuffer.append("{null}");
            } else {
                stringBuffer.append(commandArray[i2].toString());
            }
            if (i2 >= commandArray.length - 1) continue;
            stringBuffer.append(",");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private String promptArrayToString(Prompt[] promptArray) {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (int i2 = 0; i2 < promptArray.length; ++i2) {
            if (promptArray[i2] == null) {
                stringBuffer.append("{null}");
            } else {
                stringBuffer.append(promptArray[i2].toString());
            }
            if (i2 >= promptArray.length - 1) continue;
            stringBuffer.append(",");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
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

