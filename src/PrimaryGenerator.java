import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 看想要哪种类型的流水号
 * 只要数字的，可以用 系统毫秒+用户ID 生成 流水号，这能保证唯一（同一个用户同一毫秒只能发其一次流水号申请）
 * 如果可以带字母的，就用java 自带的 生成UUID 类，生成一个
 */
public class PrimaryGenerator {
    private  static final String SERIAL_NUMBER = "XXXX";  // 流水号格式
    private static PrimaryGenerator PrimaryGenerator = null;

    private PrimaryGenerator() { }


    /**
          * 取得baiPrimaryGenerator的单例实现
          *
          * @return
          */
    public static PrimaryGenerator getInstance() {
        if (PrimaryGenerator == null) {
            synchronized (PrimaryGenerator.class) {
                if (PrimaryGenerator == null) {
                    PrimaryGenerator = new PrimaryGenerator();
                }
            }
        }
        return PrimaryGenerator;
    }

    /**
          * 生成下一个编号du
          */
    public synchronized String generaterNextNumber(String sno) {
        String id = null;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        if (sno == null) {
            id = formatter.format(date) + "0001";
        }else{
            int count = SERIAL_NUMBER.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append("0");
            }
            DecimalFormat df =new DecimalFormat("0000");
            id = formatter.format(date)+df.format(
                    1+Integer.parseInt(sno.substring(8,12)));
        }
        return id;
    }
}
