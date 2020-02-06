import java.io.*;

class Account
{
	String customer_name;
	int acc_number;
	String acc_type;

	public void getVal(String type){
		DataInputStream ob=new DataInputStream(System.in);
		try
		{
		System.out.println("Enter the Name: ");
		customer_name=ob.readLine();
		acc_type=type;
		System.out.println("Enter the Acc_no: ");
		acc_number=Integer.parseInt(ob.readLine());
		}
		catch (Exception e)
		{
		}
	}
	
	/*Account(String customer_name,int acc_number,String acc_type){		
		this.customer_name=customer_name;
		this.acc_number=acc_number;
		this.acc_type=acc_type;
	}*/
	public void putVal()
	{
		System.out.println("Name: "+customer_name);
		System.out.println("Acc_No.: "+acc_number);
		System.out.println("Acc_Type: "+acc_type);
	}
}

class SavAcc extends Account
{
	DataInputStream ob=new DataInputStream(System.in);
	private float interest;
	private float amount;

	public void getInt()
	{
		float intr=amount*(interest/100);
		amount= amount + intr;
		System.out.println("-------RS "+intr+"/- INTEREST CREDITED IN ONE YEAR---------");
		putVal1();
	}
	public void getVal1()
	{
		try
		{
		System.out.println("~~~~~~~~~~~~~~~~~~~ACCOUNT IS OPENED~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Enter the Amount: ");
		amount=Float.parseFloat(ob.readLine());
		System.out.println("Enter the Interest: ");
		interest=Float.parseFloat(ob.readLine());
		getVal("Savings");
		putVal1();
		}
		catch (Exception e)
		{
		}
	}
	public void deposit1(float amt)
	{
		System.out.println("-------RS"+amt+" IS DEPOSITED---------");
		if(amt>100)
			amount=amount+amt;
		else
			System.out.println("Amount has to be greater than 100");
		putVal1();
	}
	public void withdraw1(float amt)
	{
		int q=0;
		if(amount<amt)
			System.out.println("-----------RS "+amt+" can't be withdrawn-----------");
		else
		{
			if(amount-amt<500)
			{
				try
				{
					System.out.println("Minimum balance not maintaining. You will get a fine of RS 50\n Do you still want to process? \n If Yes Press 1");
					q=Integer.parseInt(ob.readLine());
				}
				catch (Exception e)
				{
				}
				
				if(q==1)
				{
					amount=amount-amt-50;
					System.out.println("-------RS "+amt+" IS WITHDRAWN---------");
				}
				else
					System.out.println("Cancelled");
			}
			else
			{
				System.out.println("-------RS "+amt+" IS WITHDRAWN---------");
				amount=amount-amt;
			}
		}
		putVal1();
	}
	public void putVal1()
	{
		System.out.println("---------------------------------------------------------------------");
		putVal();
		System.out.println("Amount: "+amount);
		System.out.println("Interest rate: "+interest+" %\n");
		System.out.println("---------------------------------------------------------------------");
	}
}

class CurAcc extends Account
{
	DataInputStream ob=new DataInputStream(System.in);
	private float amount2;

	public void getVal2()
	{
		System.out.println("~~~~~~~~~~~~~~~~~~~~~ACCOUNT IS OPENED~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Enter the Amount: ");
		try
		{
			amount2=Float.parseFloat(ob.readLine());
		}
		catch (Exception e)
		{
		}
		getVal("Current");
		putVal2();
	}
	public void deposit2(float amt)
	{
		System.out.println("-------RS"+amt+" IS DEPOSITED---------");
		if(amt>100)
			amount2=amount2+amt;
		else
			System.out.println("Amount has to be greater than 100");
		putVal2();
	}
	public void withdraw2(float amt)
	{
		int q=0;
		if(amount2<amt)
			System.out.println("-----------RS "+amt+" can't be withdrawn-----------");
		else
		{
			if(amount2-amt<500)
			{
				try
				{
					System.out.println("Minimum balance not maintaining. You will get a fine of RS 50\n Do you still want to process? \n If Yes Press 1");
					q=Integer.parseInt(ob.readLine());
				}
				catch (Exception e)
				{
				}
				
				if(q==1)
				{
					amount2=amount2-amt-50;
					System.out.println("-------RS "+amt+" IS WITHDRAWN---------");
				}
				else
					System.out.println("Cancelled");
			}
			else
			{
				System.out.println("-------RS "+amt+" IS WITHDRAWN---------");
				amount2=amount2-amt;
			}
		}
			putVal2();
	}
	public void putVal2()
	{
		System.out.println("---------------------------------------------------------------------");
		putVal();
		System.out.println("Amount: "+amount2);
		System.out.println("---------------------------------------------------------------------");
	}
}


class Test
{
	
	public static void main(String []args)
	{
		DataInputStream ob=new DataInputStream(System.in);
		SavAcc s=new SavAcc();
		CurAcc c=new CurAcc();
		float amount=0,j=5;
	try
	{
		
		System.out.println("Choose for Account Type :\n1.Savings\n2.Current\n Enter the choide: ");
		int n=Integer.parseInt(ob.readLine());
		switch(n)
		{
			case 1: 
			{
				s.getVal1();
				while(j==5)
				{
					System.out.println("Press\n1.Deposit\n2.Withdraw\n3.Calc Interest ");
					int i=Integer.parseInt(ob.readLine());
					try
					{
						if(i!=3)
						{
						System.out.println("Enter the amount:");
						amount=Float.parseFloat(ob.readLine());
						}
					}
					catch (Exception e)
					{
					}
					if(i==1)
						s.deposit1(amount);
					else if(i==2)
						s.withdraw1(amount);
					else if(i==3)
						s.getInt();
					else
						System.out.println("wrong choice");
					System.out.println("Want to do more Transactions?Press 5");
					j=Integer.parseInt(ob.readLine());
				}
				break;
			}
			case 2:
			{
				c.getVal2();
				while(j==5)
				{
						System.out.println("Press\n1.Deposit\n2.Withdraw\n");
						int i=Integer.parseInt(ob.readLine());
						System.out.println("Enter the amount:");
						amount=Float.parseFloat(ob.readLine());
						if(i==1)
							c.deposit2(amount);
						else if(i==2)
							c.withdraw2(amount);
						else
							System.out.println("wrong choice");
						System.out.println("Want to do more Transactions?Press 5");
							j=Integer.parseInt(ob.readLine());
				}
				break;
			}
			default:
				System.out.println("Wrong Choice");
				break;
				
		}
	}
	catch (Exception e)
	{
	}
	}
}