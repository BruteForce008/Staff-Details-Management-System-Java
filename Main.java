package HashMapSort;
import java.util.*;
class StaffDetails
{
  
    int staffNumber;
    String staffName;
    private String staffEmail;
    private long phoneNumber;
    String location;
    String doj;
    ArrayList<String> staffDetList = new ArrayList<>();
    public void setter(HashMap<Integer,List<String>> staffMap)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Staff Number : ");
        this.staffNumber=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Staff Name : ");
        this.staffName=sc.nextLine();
        this.staffDetList.add(this.staffName);
        System.out.println("Enter the Staff Email : ");
        this.staffEmail=sc.nextLine();
        this.staffDetList.add(this.staffEmail);
        System.out.println("Enter the Staff Phone Number : ");
        this.phoneNumber=sc.nextLong();
        this.staffDetList.add(Long.toString(this.phoneNumber));
        sc.nextLine();
        System.out.println("Enter the Staff Location : ");
        this.location=sc.nextLine();
        this.staffDetList.add(this.location);
        System.out.println("Enter the Date Of Joining in (YYYY-MM-DD) Format : ");
        this.doj=sc.nextLine();
        this.staffDetList.add(doj);
        staffMap.put(this.staffNumber,this.staffDetList);
    }
    public void getter()
    {
        System.out.println("Staff Number : "+this.staffNumber);
        System.out.println("Staff Name : "+this.staffName);
        System.out.println("Staff Email : "+this.staffEmail);
        System.out.println("Staff Phone Number : "+this.phoneNumber);
        System.out.println("Staff Location : "+this.location);
        System.out.println("Enter the Date Of Joining in (YYYY-MM-DD) Format : "+this.doj);
        System.out.println("-----------------------------------------------------------------------------------------");
    }
    
}
public class Main extends StaffDetails
{
    public static void sortArr(ArrayList<StaffDetails> objArr)
    {
        StaffDetails objTemp;
        for(int i=0;i<objArr.size();i++)
        {
            for(int j=i+1;j<objArr.size();j++)
            {
                if(objArr.get(i).staffNumber>objArr.get(j).staffNumber)
                {
                    objTemp=objArr.get(i);
                    objArr.set(i, objArr.get(j));
                    objArr.set(j, objTemp);
                }
            }
        }
    }
    public static void sortDOJ(ArrayList<StaffDetails> doj)
    {
        int a;
        StaffDetails tempObj;
         for(int i=0;i<doj.size();i++)
        {
            for(int j=i+1;j<doj.size();j++)
            {
                a=doj.get(i).doj.compareTo(doj.get(j).doj);
                if(a>0)
                {
                    tempObj=doj.get(i);
                    doj.set(i,doj.get(j));
                    doj.set(j, tempObj);

                }
            }
        }
    }
    public static void main(String[] args) 
    {
        HashMap<Integer,List<String>> staffMap=new HashMap<>();
        ArrayList<StaffDetails> objArr=new ArrayList<>();
        ArrayList<StaffDetails> dojList=new ArrayList<>();
        ArrayList<StaffDetails> chennaiList=new ArrayList<>();
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        int firstTime=0;
        while(loop)
        {
            if(firstTime==0)
            {
                System.out.println("---------------------------------!!!WELCOME!!!------------------------------------");
                System.out.println("Enter the number to initiate the following Operations : ");
                
            }
            else
            System.out.println("Enter the number to initiate the following Operations : ");
            System.out.println("1.Create Staff ID. 2.Print the number of Staffs. 3.Sort according to Staff Number. 4.Sort according to Date of Joining 5.Display Staff List from Chennai Location 6.Exit");
            System.out.println("-----------------------------------------------------------------------------------------");
            int ops=sc.nextInt();
            switch(ops)
            {
                case 1: 
                {
                    StaffDetails staff= new StaffDetails();
                    staff.setter(staffMap);
                    objArr.add(staff);
                    dojList.add(staff);
                    if(staff.location.equalsIgnoreCase("Chennai"))
                    {
                        chennaiList.add(staff);
                    }
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Staff "+staff.staffName+" is added to the list Successfully.");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;

                }
                case 2:
                {
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("The Current number of staffs is : "+objArr.size());
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;
                }
                case 3:
                {
                    if(objArr.size()>0)
                    {
                        System.out.println("-----------------------------------------------------------------------------------------");
                        sortArr(objArr);
                        for(StaffDetails staff : objArr)
                        {
                            staff.getter();
                            System.out.println("-----------------------------------------------------------------------------------------");
                        }
                    }
                    else
                    {
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("The List is Empty");
                        System.out.println("-----------------------------------------------------------------------------------------");
                    }
                    break;
                }
                case 4:
                {
                    
                    if(dojList.size()>0)
                    {
                        System.out.println("-----------------------------------------------------------------------------------------");
                        sortDOJ(dojList);
                        for(StaffDetails staff : dojList)
                        {
                            staff.getter();
                        }
                        System.out.println("-----------------------------------------------------------------------------------------");
                    }
                    else
                    {
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("The List is Empty");
                        System.out.println("-----------------------------------------------------------------------------------------");
                    }
                    break;
                }
                case 5:
                {
                    System.out.println("-----------------------------------------------------------------------------------------");
                    if(chennaiList.size()>0)
                    {
                        for(StaffDetails staff : chennaiList)
                        {
                            staff.getter();
                        }
                    }
                    else
                    {
                        System.out.println("The List is Empty");   
                    }
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;
                }
                case 6:
                {
                    loop=false;
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Bye Bye See You Soon");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;
                }
                default:
                {
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("Enter the Correct Number");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    break;
                }

            }
            firstTime++;
         }
     
    }
    
}