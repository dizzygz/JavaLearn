public class JXTASample{
public static void main(String[] args) {
  //实例化一个对等体对象
RestoPeer myapp = new RestoPeer(); 
//启动JXTA
myapp.startJxta();
System.exit(0);
}
//启动JXTA
public void startJxta() {
try {
  //加入默认的对等组
netpg = new NetPeerGroupFactory().getInterface();
} catch (PeerGroupException e) {
e.printStackTrace();
}

/ 加入拍卖组
private void joinRestoNet() {
int count = 3; 
DiscoveryService hdisco = netpg.getDiscoveryService();
Enumeration ae = null; // 记录发现的广告。
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
 * 以上为循环发现目标组过程,以下为加入过程
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
System.out.println("找到RestoNet对等组，并加入存在的该组");
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
