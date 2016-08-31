跨进程间的通讯，使用bindService 启动服务，使用 ALDL(Interface Definition Ianguage)
进行通讯，访问Service 服务中的方法或者是 其他

.aidl 文件生成的流程
 
 1、在项目app工程下创建 aidl Packager，右击AndroidStudio,生成
    AIDL File，这是默认的生成方式实例:
	![]()
	
2、修改当中的方法，改为自己定义的方法，已满足自己的需求

3、注意，aidl 文件的生成和书写，是不支持任何的修饰符

4、编译生成 aidl文件

5、如果想传输自定义类型，（除了基本类型），这时候需要自定义JavaBean
   implemens Parceable 重写几个方法已达到自己的需求！

二、

 在Service 服务中，我们不在已这样的方式使用 
 
     public class  MyBinder extends Binder{
        public BindService getBindService(){
            return BindService.this;
        }
    };
	
	而是直接使用
	
	public static final class BinderService extends IMyAidlInterface.Stub {


        @Override
        public String getServiceMethodInfo() throws RemoteException {
            String result = "";
            for (int i = 0; i < 10; i++) {
                result = "小明---->";
            }
            return result;
        }
    }
	
	Service Code(代码)：
	public class RemoteService extends Service {
	private IBinder binder = new BinderService();
		@Nullable
		@Override
		public IBinder onBind(Intent intent) {
			return binder;
		}
	}
	
	即可！
	
	Activity 就不在书写了！
