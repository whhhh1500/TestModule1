package com.cc1500.controller;


import com.cc1500.utils.opcclient.OpcValBySyncAccessDataCallback;
import org.jinterop.dcom.common.JIException;
import org.jinterop.dcom.common.JISystem;
import org.openscada.opc.lib.da.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static com.cc1500.utils.CommondUtils.CurrentTimeyyyyMMddHHmmss;
import static com.cc1500.utils.CommondUtils.isReachable;
import static com.cc1500.utils.opcclient.BaseConfiguration.CONFIG_HOST;
import static com.cc1500.utils.opcclient.BaseConfiguration.getEntryValue;
import static com.cc1500.utils.opcclient.OpcUtils.*;


/**
 *
 * @author cc1500
 * @date 2019/8/2
 */
@RestController
@Component
public class MyStartRunner implements CommandLineRunner {

    /** //数据质量*/
    private static final int QUALITY = 10;
    private static final int PERIOD = 3000, SLEEP = 100;
    private static OpcValBySyncAccessDataCallback TestI = new OpcValBySyncAccessDataCallback();
    private static AccessBase access = null;
    private static Server server = CreaterServer();
    private static List<String> ItemIdMap = new ArrayList<>(  );
    private static Map<String, Map> fields = new HashMap<>();
    private long begin = System.currentTimeMillis();
    private long tagCount = 0,all=0;
    private int count=0;

    /**
     * itemid注册过程，大约为25~35秒
     */
    @Override
    public void run(String... args) {
        java.util.logging.Logger.getLogger( "org.jinterop" ).setLevel( java.util.logging.Level.OFF );
        /* //getItemIdMap();//获取所有itemid(tagid)放入全局变量ItemIdMap*/
        System.out.println("System.out.println(\" 执行StartRunner\")" + "\n}");
//        getInfo();//获取所有itemid的Properties和address()
//        callback();
   }




    private String callback() {
        String callbackflag;
        String host = getEntryValue( CONFIG_HOST );
        try {

            System.out.println( CurrentTimeyyyyMMddHHmmss( "yyyy-MM-dd HH:mm ss" ) + "     server.getServerState()  " + server.getServerState().getServerState().toString() );
            callbackflag = server.getServerState().getServerState().toString();
        } catch (Exception e) {
            callbackflag = "null";
        }
        if (!callbackflag.equals( "null" )) {
            return CurrentTimeyyyyMMddHHmmss( "yyyy-MM-dd HH:mm ss" ) + "    Server : " + callbackflag;
        }
        if (isReachable( host )) {
            ConnByConnectionInfo( server );
        } else {
            return CurrentTimeyyyyMMddHHmmss( "yyyy-MM-dd HH:mm ss" ) + "    无法连接到 " + host;
        }
        /*开始链接OPCserver**/
        System.out.println( CurrentTimeyyyyMMddHHmmss( "yyyy-MM-dd HH:mm ss" ) + "    开始注册到： " + host );


        List<String> ItemIdList =  ItemIdMap ;
        System.out.println("ItemIdList.size() :"+ ItemIdList.size() );

        try {
            SyncR( ItemIdList );
        } catch (Exception e) {

        }
        return "";
    }
    private static void  getItemIdMap(){
        try
        {
        /** .getBrowser会获取OpcServers所有ItemId/TagId,通过字符串筛选   数据库获取 itemId[] 筛选字符串  */
        List<String> ScreenID =new ArrayList<>();
        /*   //queryAlltarget ();//new ArrayList<>();  ScreenID.add( "G1" ); */
        ScreenID.add( "G1" );
        System.out.println("ScreenID"+ScreenID);
        ItemIdMap = GetMapByFlo( ScreenID );
    } catch(
    Exception e)

    {
        e.printStackTrace();
    }

}
    private static String getInfo() {
        Map map = new HashMap();
        long begin=System.currentTimeMillis();
        String[] list = new String[ItemIdMap.size()];
        for (int i=0;i<ItemIdMap.size();i++) {
            list[i]=ItemIdMap.get( i );
        }
        try {
            map=    GetProperties(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Object key = entry.getKey();
            Object val = entry.getValue();

            System.out.println(key + "  " + val);
        }
        long end=System.currentTimeMillis();
        return map.size()+ "....耗时为 " +String.format("%.3f",(double)(end-begin)/1000)+" S ";

    }


    /**    注册订阅 */
    private  void SyncR(List<String> itemIdArr  ) throws JIException, AddFailedException {
        try {
            access = new SyncAccess( server, PERIOD );
        } catch (Exception e) {
            SyncR( itemIdArr );
        }
        count=itemIdArr.size();
        for (final String str : itemIdArr) {
             access.addItem( str, (tag, state) -> {
                 if(state.getQuality()>10) {
                     tagCount++;
                     Map<String, String> tags = new HashMap<>();
                     int type = 0;
                     tags.put("item_id", tag.getId());
                     try {
                         type =    state.getValue().getType();
                         tags.put("item_value", getvalueByOPCUtils(type,state));
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
                     tags.put("value_type", String.valueOf( type ) );
                     tags.put("quality", String.valueOf( state.getQuality() ) );
                     tags.put("timestamp", state.getTimestamp().getTime().toString());
                     fields.put(tag.getId(),tags);

//                            point1 = influx.pointBuilder(measurement,System.currentTimeMillis(), tags, fields);
//                            batchPoints.point(point1);
//
//                            if(tagcount==(max*a>=count?count:max*a)){
//                               // System.out.println(tagcount+" "+a+" "+batchPoints.getPoints().size());
//                                a++;
                         if(tagCount==count){

                             tagCount=1;
                             long flg=System.currentTimeMillis();
                             System.out.println((all++)+ "   " +String.format("%.3f",(double)(flg-begin)/1000)+"s   "+ CurrentTimeyyyyMMddHHmmss( "yyyy-MM-dd HH:mm:ss" ));
                             begin=flg;
                         }
//                                System.out.println( "tag.toString()   " + tag.toString()
//                                        + "\n tag.getId() " + tag.getId()
//                                        + "\ntag.getClientHandle()   " + tag.getClientHandle()
//                                        + "\ntag.getGroup()   " + tag.getGroup()
//                                        + "\nGroup.getName()   " + tag.getGroup().getName().toString()
//                                        + "\nGroup.isActive()   " + tag.getGroup().isActive()
//                                        + "\ntag.getServerHandle()   " + tag.getServerHandle()
//                                        + "\nstate.toString()   " + state.toString()
//                                        + "\nstate.getValue()   " + state.getValue().toString()
//                                        + "\nstate.getObjectAsShort()   " + state.getValue().getObjectAsShort()
//                                        + "\nstate.getQuality()   " + state.getQuality()
//                                        + "\nstate.getTimestamp()   " + state.getTimestamp()
//                                        + "\nstate.getErrorCode()   " + state.getErrorCode()
//                                        + "\n\n\n\n"
//
//                                );
                 }



             });
        }
        System.out.println( "正在订阅" );

        access.bind();
        try {
            Thread.sleep( SLEEP );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        timer.schedule( new TimerTask() {
            @Override
            public void run() {
               long begin=System.currentTimeMillis();


            }
        }, PERIOD*3, 4000);
    }




    private  void RealValueBySyncAccess(ItemState state, String str) {
        try {
            if (state.getQuality() > QUALITY) {
            /* //TODO DO Some things*/
            }
            else {
           /* //TODO DO Some things*/
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 连接OPCServer  失败则重新连接OPCServer
     */
    private static void ConnByConnectionInfo( Server server) {


        try {
            JISystem.setJavaCoClassAutoCollection( false );
            AutoReconnectController controller = new AutoReconnectController( server );
            server.connect();
            controller.connect();
        } catch (Exception e) {

            synchronized (TestI) {
                try {
                    TestI.wait( 6000 );
                } catch (InterruptedException e1) {
                       e1.printStackTrace();
                }
            }
            String retStrFormatNowDate = CurrentTimeyyyyMMddHHmmss("yyyy-MM-dd HH:mm ss");
            System.out.println( " ]正在重新连接。。。。。。" + retStrFormatNowDate );

        }
    }


}


