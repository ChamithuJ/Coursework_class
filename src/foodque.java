
public class foodque {

    private Customer[] queue;
    private int size;


    public foodque(int size){
        this.size = size;
        this.queue = new Customer[size];

    }

    public void WAITinglist(Customer data){
        for (int i=0 ; i< queue.length;i++){
            if (queue[i] == null){
                queue[i] = data;
                return;
            }
        }
        System.out.print("The waiting list is full.");
        return;
    }
    public void setcustomer( Customer customer){
        for(int i=0 ; i< queue.length;i++){
            if(queue[i]==null){
                queue[i]= customer;
                return;
            }
        }
        System.out.println("Queue is full");
    }
    public void Removecustomer(int Cashier , int CashierSlot){
        int slot =0;
        if ( Cashier == 1){slot =2;}
        if ( Cashier == 2){slot =3;}
        if ( Cashier == 3){slot =5;}
        if (slot ==0 ){
            System.out.println("Invalid Cashier ");
            return;
        }
        if (CashierSlot <= slot && CashierSlot>0){
            if (this.queue[CashierSlot -1] != null){
                String Name  = this.queue[CashierSlot -1].getname();
                this.queue[CashierSlot -1] = null;
                System.out.println("Customer" + Name +" removed from slot - "+ (slot ) );
                for(int i=0 ;i<(this.queue.length -1);i++){
                    if (this.queue[i]== null){
                        Customer var = this.queue[i+1];
                        this.queue[i +1]= this.queue[i];
                        this.queue[i]= var;
                    }
                }
            }

            else{
                System.out.println("Slot is empty already");
            }
        }else{
            System.out.println("Invalid slot number");
        }

    }
    public Customer[] getQueue(){ return queue;}

    public int servecustomer(int burgertot){
        if (this.queue[0]!= null) {
            int burgers = this.queue[0].getRequiredburgers();
            if (burgers > burgertot) {
                System.out.println("Can not serve this customer with remaning burgers Please refill . ");
                return 0;
            }

            System.out.println("The customer " + this.queue[0].getname() + " has been served. ");
            this.queue[0] = null;
            for (int i = 0; i < (this.queue.length -1); i++) {
                if (this.queue[i] == null) {
                    Customer var = this.queue[i+1];
                    this.queue[i + 1] = this.queue[i];
                    this.queue[i] = var;
                }
            }

            return burgers;
        }else{
                System.out.println("No customers available for service ");
                return 0;

        }
    }





}
