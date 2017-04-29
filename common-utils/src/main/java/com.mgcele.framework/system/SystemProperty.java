package com.mgcele.framework.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Properties;

/**
 * @author mgcele on 2017/4/29.
 */
public final class SystemProperty {

    private Logger logger = LoggerFactory.getLogger(SystemProperty.class);

    private Properties stProps;
    private static SystemProperty instance;
    private static String _ST_PROPERTIES = "system.properties";
    private static String _KEY_ST_NAME = "stName";
    private static String _KEY_HOSTNAME = "hostAlias";
    private static String _MACHINE_ID = null;

    private SystemProperty()
    {
        init(_ST_PROPERTIES);
    }

    private SystemProperty(String propFile)
    {
        init(propFile);
    }

    public static SystemProperty getInstance()
    {
        if (instance == null) {
            instance = new SystemProperty();
        }
        return instance;
    }

    private void init(String propFile)
    {
        this.hostname = getHostName();
        if (this.stProps == null)
        {
            URL url = getClassLoader().getResource(propFile);
            if (url == null)
            {
                if (logger.isDebugEnabled()) {
                    logger.debug("try to load syst-property from file:" + _ST_PROPERTIES + ",but not exists!");
                }
                return;
            }
            if (logger.isDebugEnabled()) {
                logger.debug("try to load syst-property from file:" + _ST_PROPERTIES);
            }
            try
            {
                InputStream is = url.openStream();
                this.stProps = new Properties();
                this.stProps.load(is);
            }
            catch (Exception e)
            {
                logger.error("load syst-property from file:" + _ST_PROPERTIES + " failed!the url is:" + url.toExternalForm(), e);
            }
        }
    }

    public String getSysName()
    {
        return getSystProperty(_KEY_ST_NAME);
    }

    private String hostname = null;

    private String getHostName()
    {
        String hn = null;
        try
        {
            hn = InetAddress.getLocalHost().getHostName();
        }
        catch (Exception e)
        {
            logger.error("get Machineid failed for:", e);
        }
        return hn;
    }

    public String getMachineID()
    {
        _MACHINE_ID = getInnerSystProperty(_KEY_HOSTNAME);
        if (_MACHINE_ID == null)
        {
            if (this.hostname == null) {
                this.hostname = getHostName();
            }
            if (this.hostname != null) {
                try
                {
                    _MACHINE_ID = this.hostname.substring(this.hostname.length() < 2 ? 0 : this.hostname.length() - 2);
                }
                catch (Exception e)
                {
                    logger.error("get Machineid failed for:", e);
                }
            }
        }
        return _MACHINE_ID;
    }

    public String getSystProperty(String key)
    {
        if (this.stProps == null) {
            return getInnerSystProperty(key);
        }
        String value = this.stProps.getProperty(key);
        if (value == null) {
            return getInnerSystProperty(key);
        }
        return value;
    }

    private String getInnerSystProperty(String key)
    {
        String value = System.getProperty(key);
        return value;
    }

    private ClassLoader getClassLoader()
    {
        try
        {
            return Thread.currentThread().getContextClassLoader();
        }
        catch (Exception e) {}
        return ResourceUtils.class.getClassLoader();
    }

}
