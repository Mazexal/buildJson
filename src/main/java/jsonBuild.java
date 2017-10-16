import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by 10235 on 2017/10/5.
 */
public class jsonBuild {

    public static void main(String[] args){
        long begin=new Date().getTime();
        int length=10000;
        List<String> res=jsonList(length);
        long end=new Date().getTime();

        for(String item : res){
            System.out.println(item);
        }
        System.out.println(end-begin);
    }

    public static int getRandInt(int begin,int end){
        int temp=end-begin;
        Random r=new Random();
        return (r.nextInt(begin)+temp);
    }

    private static List<String> jsonList(int length) {
        List<String> jsonList = new ArrayList();
        for (int i = 0; i < length; i++) {
            jsonList.add(buildObjectBase(100,0));
        }
        return jsonList;
    }


    private static String buildObjectBase(int length,int depthlevel){

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("{");
        for(int i=0;i<length;i++){
            int num = getRandInt(5,20);
            stringBuilder.append("\"");
            stringBuilder.append(strBuild(num));
            stringBuilder.append("\"");
            num=getRandInt(5,20);
            stringBuilder.append(":");
            int choose=getRandInt(3,4);
            int tmp = getRandInt(3,4);
            if(depthlevel>5){
                choose=5;
            }
            switch (choose){
                case 0:
                    depthlevel =depthlevel+1;
                    stringBuilder.append(buildObjectBase(tmp,depthlevel+1));
                    break;
                case 1:
                    depthlevel =depthlevel+1;
                    stringBuilder.append(buildArray(tmp,depthlevel+1));
                    break;
                default:
                    stringBuilder.append("\"");
                    stringBuilder.append(strBuild(num));

                    stringBuilder.append("\"");
                    break;
            }
            if(i!=length-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("}");
        return (stringBuilder.toString());
    }


    private static String buildArray( int depth,int depthlevel){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[");
        for(int i=0;i<depth;i++){
            int length =  getRandInt(5,12);
            stringBuilder.append(buildObjectBase(length,depthlevel+1));
            if(i!=depth-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        // stringBuilder.append(",");
        
        return stringBuilder.toString();
    }

    private static String strBuild(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQISTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
