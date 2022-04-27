import java.util.Scanner;

public class MyTree3 extends MyTree {
	TNode root;
	/*void createTree()
	{
		TNode a= new TNode(3, new TNode(1), new TNode(4));
		TNode b= new TNode(9, new TNode(6), null);
		root= new TNode(3,a,b);
	}
	void createTreeT1()
	{
		
	}*/
	void f1(TNode T)
	{
		if(T!=null)
		{
			System.out.print(T);
			f1(T.left);
			f1(T.right);
		}
	}
	void f2(TNode T)
	{
		if(T!=null)
		{
			f2(T.left);
			f2(T.right);
			System.out.print(T);
		}
	}
	void f3(TNode T)
	{
		if(T!=null)
		{
			f1(T.left);
			System.out.print(T);
			f1(T.right);
		}
	}
	void tientu()
	{
		System.out.print("\nDuyet cay tien tu: ");
		f1(root);
	}
	void hautu()
	{
		System.out.print("\nDuyet cay hau tu: ");
		f2(root);
	}
	void trungtu()
	{
		System.out.print("\nDuyet cay trung tu: ");
		f3(root);
	}
	int sn(TNode T)
	{
		if(T==null || (T.left==null && T.right==null))
			return 0;
		else
			return 1+ sn(T.left)+ sn(T.right);
	}
	int sn(){ return sn(root); }
	TNode chendd(int x, TNode T)
	{
		if(T==null) T =new TNode(x);
		else if(sn(T.left)>sn(T.right)) T.right= chendd(x, T.right);
		else T.left= chendd(x, T.left);
		return T;
	}
	void chendd(int x) { root= chendd(x, root); }
	void nhapcaydd()
	{
		int x;
		Scanner kb= new Scanner(System.in);
		root=null;
		while(true)
		{
			System.out.println("Nhap so (>=0) de them vao ngan xep: "); x=kb.nextInt();
			if(x<0) break;
			chendd(x);
		}
	}
	//tinh tong not la
	int tongLa(TNode T)
	{
		if(T==null)
			return 0;
		else if(T.left==null && T.right==null) return T.data;
		else
			return tongLa(T.left) +tongLa(T.right);
	}
	int tongLa() { return tongLa(root); }
	int la(TNode T)
	{
		if(T==null)
			return 0;
		else if(T.left==null && T.right==null) return 1;
		else
			return la(T.left) +la(T.right);
	}
	int la(){ return la(root); }
	int onlyOne(TNode T)
	{
		if(T==null) return 0;
		else if(T.left==null && T.right!=null || T.left!=null && T.right==null)
			return 1;
		else
		return onlyOne(T.left)+onlyOne(T.right);
	}
	int onlyOne() { return onlyOne(root);}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTree3 T= new MyTree3();
		T.nhapcaydd();
		T.tientu();
		T.trungtu();
		T.hautu();
		System.out.println("\nSo not la (leaf) cua cay la: "+ T.la());
		System.out.println("\nTong cac la la: "+T.tongLa());
		System.out.println("So not co 1 con cua cay la: "+T.onlyOne());

	}

}
