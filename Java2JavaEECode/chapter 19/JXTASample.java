public class JXTASample{
public static void main(String[] args) {
  //ʵ����һ���Ե������
RestoPeer myapp = new RestoPeer(); 
//����JXTA
myapp.startJxta();
System.exit(0);
}
//����JXTA
public void startJxta() {
try {
  //����Ĭ�ϵĶԵ���
netpg = new NetPeerGroupFactory().getInterface();
} catch (PeerGroupException e) {
e.printStackTrace();
}

/ ����������
private void joinRestoNet() {
int count = 3; 
DiscoveryService hdisco = netpg.getDiscoveryService();
Enumeration ae = null; // ��¼���ֵĹ�档
while (count-- > 0) {
try {
ae = hdisco.getLocalAdvertisements(DiscoveryService.GROUP, "Name", "RestoNet");
if ((ae != null) && ae.hasMoreElements()) 
{
break;
}
hdisco.getRemoteAdvertisements(null, DiscoveryService.GROUP, "Name", "RestoNet", 1, null);
try {
Thread.sleep(timeout);
} catch (InterruptedException e) {
e.printStackTrace();
}
} catch (IOException e) {
e.printStackTrace();
}
}
/*-------------------------------------------
 * ����Ϊѭ������Ŀ�������,����Ϊ�������
 * ----------------------------------------*/
PeerGroupAdvertisement restoNetAdv = null;
if (ae == null || !ae.hasMoreElements()) 
{
System.out.println("Could not find the RestoNext peergroup;createing me");
try {
ModuleImplAdvertisement implAdv = netpg.getAllPurposePeerGroupImplAdvertisement();
restoNet = netpg.newGroup(mkGroupID(), implAdv, "RestoNet", "RestoNet,Inc.");
restoNetAdv = netpg.getPeerGroupAdvertisement();
} catch (Exception e) {
e.printStackTrace();
}
} 
else 
{
restoNetAdv = (PeerGroupAdvertisement) ae.nextElement();
try {
restoNet = netpg.newGroup(restoNetAdv);
System.out.println("�ҵ�RestoNet�Ե��飬��������ڵĸ���");
} catch (PeerGroupException e) {
e.printStackTrace();
}
}
disco = restoNet.getDiscoveryService();
pipes = restoNet.getPipeService();
System.out.println("RestoNet Restaurant_(" + brand + ") is on-line");
return;
}
}
