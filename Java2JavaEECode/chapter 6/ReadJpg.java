import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import com.sun.image.codec.jpeg.*;

public class ReadJpg{
public static void main(String[] args)throws Exception{
	java.io.File file = new java.io.File("tmp.jpg");      
    String newurl="temp_min.jpg";
    Image src = javax.imageio.ImageIO.read(file); 
    float tagsize=287;
    int old_w=src.getWidth(null);                                  
    int old_h=src.getHeight(null);  
    int new_w=0;
    int new_h=0;                  
    System.out.println("<br/>the old width is :"+old_w+" the old height is "+old_h+"<br/>");
    float tempdouble;
    if(old_w>old_h){
     tempdouble=old_w/tagsize;
    }else{
     tempdouble=old_h/tagsize;
    }
    new_w=Math.round(old_w/tempdouble);
    new_h=Math.round(old_h/tempdouble);
    System.out.println("the new width is :"+new_w+" the new height is "+new_h+"<br/>");
    BufferedImage tag = new BufferedImage(new_w,new_h,BufferedImage.TYPE_INT_RGB);
    tag.getGraphics().drawImage(src,0,0,new_w,new_h,null);     
    FileOutputStream newimage=new FileOutputStream(newurl);         
    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);      
    encoder.encode(tag);                                             
    newimage.close();   
}
}

