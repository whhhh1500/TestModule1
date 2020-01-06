package com.cc1500.utils.opcclient;

import org.springframework.stereotype.Service;

@Service
public class StartAddDataListener //implements ApplicationListener<ContextRefreshedEvent>

{
//	 private static Logger logger = LoggerFactory.getLogger(StartAddDataListener.class);
//	@Autowired
//	private IOPCItemDao OPCItemDao;
//
//	@Autowired
//	private  IPumpStationDao pumpStationDao;
//
//
//
//
//	public void jopc() throws InterruptedException, IllegalArgumentException, UnknownHostException, JIException, AlreadyConnectedException, NotConnectedException, DuplicateGroupException {
//
//        System.out.println("\n\n\n_________\n\n数据采集引擎启动 \n\n ________\n\n\n\n");
//    	Log logger = LogFactory.getLog(getClass());// 日志对象，记录日志
//    	logger.info("数据采集引擎启动");
//
//
//		Server server = new Server(
//				BaseConfiguration.getCLSIDConnectionInfomation(),
//				Executors.newSingleThreadScheduledExecutor());
//
//		server.connect();
//		Group group = server.addGroup();
//      //2.获取数据中点位信息
//      List<SelfOpcItem> itemsList=new ArrayList();
//      //注册读取数据的items
//      Map<SelfOpcItem, Item> regItemsMap = new HashMap();
//      try {
//			itemsList= OPCItemDao.queryAllItems();
//
//			for(int i=0;i<itemsList.size();i++){
//				Item item =group.addItem(itemsList.get(i).getTagName());
//				regItemsMap.put(itemsList.get(i), item);
//
//			// logger.info("注册系统要获取的点位信息== "+itemsList.get(i).getTagName());
//			}
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//
//		 while (true) {
//		      synchronized(server) {
//		    	  server.wait(2000);
//		      }
//		      for (Entry<SelfOpcItem, Item> temp : regItemsMap.entrySet()) {
//		    	  try {
//		    			dumpItem(temp.getKey() ,temp.getValue());
//		    	  }catch(Exception e) {
//		    		  System.out.println("读取点位数据异常："+e.toString());
//		    	  }
//
//				}
//
//
//		   }
//
//	   // JOpc.coUninitialize();
//    }
//	private static void dumpItem(SelfOpcItem selfitem, Item item) throws JIException {
//
//		//1.解析传入对象的tag名称 和值
//		//String groupName=item.getGroup().getName();
//		String tagName=item.getId();
//		Object value;
//		switch (selfitem.getTagType()) {
//        case 0:
//            //该Float需要转换成double
//            float objectAsFloat = item.read(true).getValue().getObjectAsFloat();
//            value = Double.parseDouble(String.valueOf(objectAsFloat));
//
//        case 1:
//        	value= item.read(true).getValue().getObjectAsInt();
//        case 2:
//        	value= (item.read(true).getValue().getObjectAsBoolean()?1:0);
//
//        case 3:
//        	value= item.read(true).getValue().getObjectAsString2();
//        default:// string
//        	value= item.read(true).getValue().toString();
//    }
//		String v_value=value.toString();
//	//System.out.println("{tagName:"+tagName+",v_value:"+v_value+"}");
//
//		Calendar tagTime=item.read(false).getTimestamp();
//		//2.转成OpcData对象方便存储
//		OpcData self_temp_itemData=new OpcData();
//		self_temp_itemData.setTagId(selfitem.getId());
//		self_temp_itemData.setValue(v_value);
//		//self_temp_itemData.setTime(new Date());
//		self_temp_itemData.setTime(tagTime.getTime());
//
//		//3.将对象以tagname作为key 存入hashmap
//		if(SystemConstant.OPCITEMMap==null) {
//			SystemConstant.OPCITEMMap=new HashMap();
//		}
//		SystemConstant.OPCITEMMap.put(tagName, self_temp_itemData);
//
//
//	}
//
//
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//    		 if(event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext"))
//    	        {
//    				new Thread(new Runnable() {
//    					@Override
//    					public void run() {
//    						System.out.println("开始");
//    						try {
//    							jopc();
//    						} catch (InterruptedException | IllegalArgumentException | UnknownHostException | JIException | AlreadyConnectedException | NotConnectedException | DuplicateGroupException e) {
//    							// TODO Auto-generated catch block
//    							e.printStackTrace();
//    						}
//    					}
//    				}).start();
//    				//3.独立线程推送
//
//    			 push();
//
//
//
//    	        }
//
//
//
//    }
//
//
//
//
//    //定时推送任务，间隔十五秒执行一次
//	public void push()  {
//		Timer timer = new Timer();
//        timer.schedule(new pushTask(),15000, 1000);
//	}
//
//	static int num = 0;
//
//	//定时推送任务，具体执行内容
//	static class pushTask extends TimerTask {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
//	    @Override
//	    public void run() {
//	    	//List<OpcItem> selfOpcdataList=new ArrayList<OpcItem>();
//	    	//从全局变量中获取当前所有tag的最近状态；
//	    	HashMap<String,OpcData> tempMap=SystemConstant.OPCITEMMap;
//	    	String strTemp="";
//	    	for(String key:tempMap.keySet()){
//	    		OpcData tempItem=tempMap.get(key);
//	           	strTemp=strTemp+"|"+tempItem.getTagId()+","+tempItem.getValue();
//	          }
//	    	if(strTemp.length()>0) {
//	    			try {
//	    				num=num++;
//				    	MyClient client = new MyClient();
//
//						//System.out.println("==========开始推送==========");
//						String uri = "ws://localhost:8080/OPCWeb_tjg/websocket?service123";
//						client.start(uri);
//						//System.out.println("==========开始推送  start=========="+strTemp);
//						client.sendMessage(strTemp);
//		    			client.closeSocket();
//					} catch (Exception e) {
//						logger.error( e.toString());
//					}
//
//	    		}
//
//	    }
//
//	}
	  

	
}