����̼��ͨѶ��ʹ��bindService ��������ʹ�� ALDL(Interface Definition Ianguage)
����ͨѶ������Service �����еķ��������� ����

.aidl �ļ����ɵ�����
 
 1������Ŀapp�����´��� aidl Packager���һ�AndroidStudio,����
    AIDL File������Ĭ�ϵ����ɷ�ʽʵ��:
	![]()
	
2���޸ĵ��еķ�������Ϊ�Լ�����ķ������������Լ�������

3��ע�⣬aidl �ļ������ɺ���д���ǲ�֧���κε����η�

4���������� aidl�ļ�

5������봫���Զ������ͣ������˻������ͣ�����ʱ����Ҫ�Զ���JavaBean
   implemens Parceable ��д���������Ѵﵽ�Լ�������

����

 ��Service �����У����ǲ����������ķ�ʽʹ�� 
 
     public class  MyBinder extends Binder{
        public BindService getBindService(){
            return BindService.this;
        }
    };
	
	����ֱ��ʹ��
	
	public static final class BinderService extends IMyAidlInterface.Stub {


        @Override
        public String getServiceMethodInfo() throws RemoteException {
            String result = "";
            for (int i = 0; i < 10; i++) {
                result = "С��---->";
            }
            return result;
        }
    }
	
	Service Code(����)��
	public class RemoteService extends Service {
	private IBinder binder = new BinderService();
		@Nullable
		@Override
		public IBinder onBind(Intent intent) {
			return binder;
		}
	}
	
	���ɣ�
	
	Activity �Ͳ�����д�ˣ�
