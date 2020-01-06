package com.cc1500.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class CommondUtils {
  /**
     * 传入需要连接的IP，返回是否连接成功
     * @param remoteInetAddr
     * @return
     */
    public static boolean isReachable(String remoteInetAddr) {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(remoteInetAddr);
            reachable = address.isReachable(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reachable;
    }
//    public static void netst( ) {
//
//        URL url = null;
//        Boolean bon = false;
//        try {
//            url = new URL("http://baicu.com/");
//            InputStream in = url.openStream();//打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream
//            System.out.println("连接正常");
//            in.close();//关闭此输入流并释放与该流关联的所有系统资源。
//        } catch (IOException e) {
//            System.out.println("无法连接到网络" );
//        }
//        bon = isReachable(remoteInetAddr);
//        System.out.println("pingIP：" + bon);
//    }
    /**
     * import java.lang.reflect.Field;
     * 判断对象是否为空，且对象的所有属性都为空
     * ps: boolean类型会有默认值false 判断结果不会为null 会影响判断结果
     *     序列化的默认值也会影响判断结果
     * @param object
     * @return
     */

    public static boolean objCheckIsNull(Object object){
        Class clazz = (Class)object.getClass();
        // 得到类对象
        Field fields[] = clazz.getDeclaredFields();
        // 得到所有属性
        boolean flag = true;
        //定义返回结果，默认为true
        for(Field field : fields){
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                fieldValue = field.get(object);
                //得到属性值
                Type fieldType =field.getGenericType();
                //得到属性类型
                String fieldName = field.getName();
                // 得到属性名
                //  System.out.println("属性类型："+fieldType+",属性名："+fieldName+",属性值："+fieldValue);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(fieldValue != null){
                //只要有一个属性值不为null 就返回false 表示对象不为null
                flag = false;
                break;
            }
        }
        return flag;
    }
    /**
     * 按分隔符截取字符串，返回一个list
     * **/
    public static List<String> mySplit(String str, String delim){
        List<String> stringList = new ArrayList<>();
        while(true) {
            int k = str.indexOf(delim);
            if (k < 0){
                stringList.add(str);
                break;
            }
            String s = str.substring(0, k);
            stringList.add(s);
            str = str.substring(k+1);
        }
        return stringList;
    }
    /**
     * 按分隔符截取字符串，返回一个list
     * **/
    public static String CurrentTimeyyyyMMddHHmmss(String DateFormat){
        //"yyyy-MM-dd HH:mm ss"
    SimpleDateFormat sdFormatter = new SimpleDateFormat( DateFormat );
     return sdFormatter.format( new Date( System.currentTimeMillis() ) );
    }
    /**
     * 按分隔符截取字符串，返回一个list
     * **/
    public static String [] MapKeyTolist(HashMap map) {
        String[] Liststring = new String[map.size()];
        int icon = 0;
        for (Object key : map.keySet()) {
            Liststring[icon] = key.toString();
            icon++;
        }
        return  Liststring;
    }
    public static List<String> MapKeyTolist1(HashMap map) {
        List<String> Liststring = new ArrayList<>(map.size());
        int icon = 0;
        for (Object key : map.keySet()) {
            Liststring.add( key.toString());
            icon++;
        }
        return  Liststring;
    }
    /**
     *
     * 读取alm.json文件 ====>>>System.getProperty("user.dir")+"\\src\\main\\resources\\static\\alm.json";
     * 把limit写入 HashMap<String,AlarmLimit>
     * **/
//    private  void  setUpreadTree() {
//         String  pat=  System.getProperty("user.dir")+"\\src\\main\\resources\\static\\alm.json";
//        ObjectMapper objMap = new ObjectMapper();
////        HashMap<String,AlarmLimit> almLimit = new HashMap<>();
//        JsonNode root1 = null;
//        //AlarmLimit
//        try {
//            root1  = objMap.readTree(new File(pat));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        HashMap urMap = null;
//        try {
//            urMap = objMap.readValue(root1.toString(), HashMap.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        AlarmLimit alm =new AlarmLimit();
//
//        for(Object key:urMap.keySet())
//        {
//            HashMap m3=   (HashMap) urMap.get( key );
//            alm.setLowerAlm( Float.parseFloat(m3.get( "lpperAlm" ).toString()) );
//            alm.setUpperAlm(  Float.parseFloat(m3.get( "upperAlm" ).toString()) );
//            alm.setIsflg(  getBoolean( m3.get( "isflg ").toString()) );
//            almLimit.put( key.toString(), alm);
//        }
//    }
//    /**
//     * 测试用
//     * 拟定limit
//     * 写入alm.json文件 ====>>> System.getProperty("user.dir")+"\\src\\main\\resources\\static\\alm.json";
//     * **/
//    private  void writeTree() {
//        ObjectMapper mapper1 = new ObjectMapper();
//        String  pat=  System.getProperty("user.dir")+"\\src\\main\\resources\\static\\alm.json";
//        Map<String,String> mp3=new HashMap<>(15);
//        System.out.println(pat);
//        java.util.logging.Logger.getLogger("org.jinterop").setLevel(java.util.logging.Level.OFF);
//        /**    itemId[] 筛选字符串  */
//        List ScreenID =ScreenService.selectScreenIDByScreening( "1" );;//
//        try {
//            mp3 = GetMapByFlo(ScreenID);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JsonNode root =null;
//        ObjectNode objNode = mapper1.createObjectNode();
//        for (String key : mp3.keySet()) {
//            AlarmLimit Alm= new AlarmLimit();
//            ObjectNode objNode1= mapper1.createObjectNode();
//            objNode1.put("UpperAlm",55.822f);
//            objNode1.put("LowerAlm",12.822f);
//            objNode1.put("Isflg",true);
//            objNode.set(key,objNode1);
//        }
//        JsonFactory jsonFactory = null;
//        try {
//            jsonFactory = new JsonFactory();
//            JsonGenerator jsonGenerator = jsonFactory.createGenerator(
//                    new File(pat), JsonEncoding.UTF8);
//            mapper1.writeTree(jsonGenerator, objNode);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
