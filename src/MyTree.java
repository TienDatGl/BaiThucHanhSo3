class TNode
{
	int data;
	TNode left, right;
	TNode(int x) { data=x; left=right=null; }
	TNode(int x, TNode ll, TNode rr) { data=x; left=ll; right=rr; }
	public String toString() { return data+ " ";}
}
public class MyTree {
	TNode root;
	void createTree()
	{
		TNode a= new TNode(3, new TNode(1), new TNode(4));
		TNode b= new TNode(9, new TNode(6), null);
		root= new TNode(3,a,b);
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
			f1(T.left);
			System.out.print(T);
			f1(T.right);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTree T= new MyTree();
		T.createTree();
		T.tientu();
		T.hautu();
		T.trungtu();
		System.out.println("\nTotal: "+T.tong());
	}

}
