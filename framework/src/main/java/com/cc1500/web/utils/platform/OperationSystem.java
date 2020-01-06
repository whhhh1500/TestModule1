package com.cc1500.web.utils.platform;

/**
 * @Author 明建新
 * @Create 2019/8/29 14:11
 * @Version 1.0
 */
public class OperationSystem {
    private static String systemName=null;
    private void set() {
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            systemName="windows";
        }else if(os.toLowerCase().startsWith("lin")){
            systemName="linux";
        }

    }
    public static void setSystem(){
        OperationSystem setOperationSystem=new OperationSystem();
        setOperationSystem.set();
    }
    public static boolean isWindos(){
        setSystem();
        if("windows".equals(systemName)){
            return true;
        }
        return false;
    }

    public static boolean isLinux(){
        setSystem();
        if("linux".equals(systemName)){
            return true;
        }
        return false;
    }







}
