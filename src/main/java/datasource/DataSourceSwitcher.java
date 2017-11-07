package datasource;

/**
 * 利用 ThreadLocal 解决线程安全问题
 */
public class DataSourceSwitcher {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static final String DATA_SOURCE_A = "masterDataSource";
    public static final String DATA_SOURCE_B = "slaveDataSource";

    public static void setMaster() {
        clearDataSource();
    }

    public static void setSlave() {
        setDataSource("slave");
    }

    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}