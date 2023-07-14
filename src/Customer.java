public class Customer {

    private  String f_name;
    private  String s_name;

    private  int requiredburgers;


    public Customer( String f_name, String s_name, int requiredburgers){
        this.f_name = f_name;
        this.s_name = s_name;
        this.requiredburgers = requiredburgers;
    }
    public void setName(String fistname,String secondName){
        f_name =fistname;
        s_name =secondName;
    }
    public void setrequiredburgers( int Burgers){
        requiredburgers = Burgers;
    }
    public   String getname(){
        return f_name +" "+ s_name;
    }
    public   int getRequiredburgers(){
        return requiredburgers;
    }
   // public  String getF_name(){
     //   return f_name;
    //}
   // public  String getS_name(){
     //   return s_name;
    //}



}
