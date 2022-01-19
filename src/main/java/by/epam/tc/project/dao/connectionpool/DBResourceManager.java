package by.epam.tc.project.dao.connectionpool;

import java.util.ResourceBundle;

public class DBResourceManager {

    private final static String DB = "database";
    private final static DBResourceManager instance = new DBResourceManager();

    private ResourceBundle bundle = ResourceBundle.getBundle(DB);

    private DBResourceManager(){}

    public static DBResourceManager getInstance(){
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}
