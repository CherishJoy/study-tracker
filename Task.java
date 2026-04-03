/*这个类负责：
1、存储任务数据（任务名称、累计学习小时数）
2、操作任务数据（增加时长、计算进度）
*/

public class Task {
    //任务名称，如java编程、街舞等
    private String name;
    //累计学习小时数，如5.5表示5个半小时
    private double totalHours;
    //constructor1，创建一个新任务，当前学习时长为0
    public Task(String name){
        this.name = name;
        this.totalHours = 0.0;
    }
    //constructor2，导入一个任务及学习时长
    public Task(String name, double totalHours){
        this.name = name;
        this.totalHours = totalHours;
    }
    //获取任务名称
    public String getName(){
        return name;
    }
    //获取累计学习小时数
    public double getTotalHours(){
        return totalHours;
    }

    //增加学习时长，参数是分钟，内部转换成小时再累加
    public void addMins(int minutes){
        //分钟转小时
        double hoursToAdd = minutes / 60.0;
        this.totalHours += hoursToAdd;
    }

    //计算当前学习进度，100小时法则：目标总时长100小时
    public double getProgressPercent(){
        return (this.totalHours / 100.0) * 100;
    }
    //计算距离100小时还差多少小时
    public double getRemainingHours(){
        double remaining = 100.0 - this.totalHours;
        if (remaining < 0){
            return 0
        }
        return remaining;
    }
    //命令行显示
    @Override
    public String toString(){
         // %-12s：左对齐，占12个字符宽度
        // %5.1f：浮点数，总共5位宽度，小数点后1位
        return String.format("%-12s: %5.1f / 100小时   进度: %5.1f%%   还差 %5.1f小时",
                name, totalHours, getProgressPercent(), getRemainingHours());
    }
    public String toFileString(){
        return name + "," + totalHours
    }
}