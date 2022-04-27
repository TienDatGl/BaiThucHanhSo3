
/*class TNode
{
	int data;
	TNode left, right;
	TNode(int x) { data=x; left=right=null; }
	TNode(int x, TNode ll, TNode rr) { data=x; left=ll; right=rr; }
	public String toString() { return data+ " ";}
}*/
public class MyTree2 extends MyTree {

	TNode root;
	void createTree()
	{
		TNode f= new TNode(5, null, new TNode(6));
		TNode c= new TNode(9);
		TNode d= new TNode(1, new TNode(4), null);
		TNode e= new TNode(0, new TNode(6), new TNode(7));
		TNode a= new TNode(3, c, f);
		TNode b= new TNode(2, d, e);
		root= new TNode(11,a,b);

	}
	void createTreeT1()
	{
		
	}
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
			f3(T.left);
			System.out.print(T);
			f3(T.right);
		}
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

	void tientu()
	{
		System.out.print("\nDuyet cay tien tu: ");
		f1(root);
	}

	int tong(TNode T)
	{
		if(T==null)
			return 0;
		else
			return T.data + tong(T.left) + tong(T.right);
	}
	int tong()
	{
		return tong(root);
	}
	int nn(TNode T)
	{
		if(T==null || (T.left==null && T.right==null))
			return 0;
		else
			return 1+ nn(T.left)+ nn(T.right);
	}
	int nn()
	{
		return nn(root);
	}
	int la(TNode T)
	{
		if(T==null)
			return 0;
		else if(T.left==null && T.right==null) return 1;
		else
			return la(T.left) +la(T.right);
	}
	int la(){ return la(root); }
	int height(TNode T)
	{
		if(T==null) return 0;
		else return Math.max(height(T.left), height(T.right))+1;
	}
	int height() { return height(root);}
	int max(TNode T)
	{
		if(T==null)
			return 0;
		else if(T.left==null && T.right==null) return T.data;
		else if(T.left==null && T.right!=null) return Math.max(T.data,max(T.right));
		else if( T.left!=null && T.right==null) return Math.max(T.data, max(T.left));
		else return Math.max(T.data, Math.max(max(T.left), max(T.right)));
	}
	int max(){ return max(root);}
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
		MyTree2 T= new MyTree2();
		T.createTree();
		T.tientu();
		T.trungtu();
		T.hautu();
		System.out.println("\nTotal: "+T.tong());
		System.out.println("So not trong (inner node) cua cay la: "+ T.nn());
		System.out.println("So not la (leaf) cua cay la: "+ T.la());
		System.out.println("Chieu cao cua cay la: "+T.height());
		System.out.println("Gia tri lon nhat cua cay la: "+ T.max());
		System.out.println("So not co 1 con cua cay la: "+T.onlyOne());

	}

}
