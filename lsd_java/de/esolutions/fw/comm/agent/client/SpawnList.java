/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.naming.INameService;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.serializer.connection.ConnectionFactoryException;
import de.esolutions.fw.util.serializer.connection.IConnectionFactoryProvider;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class SpawnList {
    private final IConnectionFactoryProvider provider;
    private final ISpawnedConnectionListener listener;
    private final ArrayList factories;

    public SpawnList(INameService iNameService, IConnectionFactoryProvider iConnectionFactoryProvider, ISpawnedConnectionListener iSpawnedConnectionListener) {
        this.provider = iConnectionFactoryProvider;
        this.listener = iSpawnedConnectionListener;
        this.factories = new ArrayList();
        String[] stringArray = iNameService.getNodeNames();
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string = stringArray[i2];
                ISpawnConnectionFactory iSpawnConnectionFactory = this.createFactoryForNode(string);
                if (iSpawnConnectionFactory == null || this.isFactoryAvailable(iSpawnConnectionFactory)) continue;
                this.factories.add(iSpawnConnectionFactory);
                CommAgentTracing.AGENT.log((short)2, "added spawn factory %1", (Object)iSpawnConnectionFactory.getDescription());
            }
        }
    }

    public void enableSpawning() {
        ListIterator listIterator = this.factories.listIterator();
        while (listIterator.hasNext()) {
            ISpawnConnectionFactory iSpawnConnectionFactory = (ISpawnConnectionFactory)listIterator.next();
            try {
                iSpawnConnectionFactory.enableSpawning();
            }
            catch (IOException iOException) {
                CommAgentTracing.AGENT.log((short)4, "error enabling spawning: %1: %2", (Object)iSpawnConnectionFactory.getDescription(), (Object)iOException);
            }
        }
    }

    public void disableSpawning() {
        ListIterator listIterator = this.factories.listIterator();
        while (listIterator.hasNext()) {
            ISpawnConnectionFactory iSpawnConnectionFactory = (ISpawnConnectionFactory)listIterator.next();
            iSpawnConnectionFactory.disableSpawning();
        }
    }

    private boolean isFactoryAvailable(ISpawnConnectionFactory iSpawnConnectionFactory) {
        String string = iSpawnConnectionFactory.getDescription();
        for (int i2 = 0; i2 < this.factories.size(); ++i2) {
            ISpawnConnectionFactory iSpawnConnectionFactory2 = (ISpawnConnectionFactory)this.factories.get(i2);
            if (!iSpawnConnectionFactory2.getDescription().equals(string)) continue;
            return true;
        }
        return false;
    }

    private ISpawnConnectionFactory createFactoryForNode(String string) {
        try {
            CommAgentTracing.AGENT.log((short)2, "creating spawn connection factory for 'comm:%1'", (Object)string);
            ISpawnConnectionFactory iSpawnConnectionFactory = this.provider.createSpawnConnectionFactory("comm", string);
            iSpawnConnectionFactory.setListener(this.listener);
            CommAgentTracing.AGENT.log((short)2, "factory for 'comm:%1' is %2", (Object)string, (Object)iSpawnConnectionFactory.getDescription());
            return iSpawnConnectionFactory;
        }
        catch (ConnectionFactoryException connectionFactoryException) {
            CommAgentTracing.AGENT.log((short)2, "no spawn factory found for 'comm:%1'. Disabling spawning: %2", (Object)string, (Object)connectionFactoryException);
            return null;
        }
    }
}

