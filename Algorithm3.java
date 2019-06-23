

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract public class Algorithm3 {
	
	static ArrayList<Node> open_list = new ArrayList<>();
	static ArrayList<Node> closed_list = new ArrayList<>();
	
	static Node a = new Node("�a�̎R");
	static Node b = new Node("�_��");
	static Node c = new Node("���");
	static Node d = new Node("�ޗ�");
	static Node e = new Node("��");
	static Node f = new Node("���s");
	static Node g = new Node("����");
	static Node h = new Node("���É�");
	static Node i = new Node("����");
	static Node j = new Node("��");
	
	
	public static void main(String[] args) {
		
		Node n;
		init();
		open_list.add(a);
		n = open_list.get(0);
		
		
		while(true) {
			System.out.println("���݁F"+n.name);
			System.out.println(n.name+"�̃����N����"+n.list.size());
			
			if(n.name == "��") {
				
				System.out.println("�򕌔���");
				System.out.println("----------------------------------------------");
				break;
			}
			
			for(int i=0; i<n.list.size(); i++) { 
				if(!(open_list.contains(n.list.get(i)) || closed_list.contains(n.list.get(i)))) {
					n.list.get(i).gn = n.num_list.get(i) + n.gn; //gm=gn+(n~m�Ԃ̃R�X�g)
					n.list.get(i).parent = n; //�ʂ����o�H�̋L��
					
					sort(n.list.get(i));//�q�m�[�h���I�[�v�����X�g�ɒǉ�
					System.out.print("1:");
				}else if(open_list.contains(n.list.get(i)) ) {
					//�����m�[�h��gn������ׁA����������gn��ݒ�
					if(n.list.get(i).gn < open_list.get(open_list.indexOf(n.list.get(i))).gn) {
						open_list.get(open_list.indexOf(n.list.get(i))).gn = n.list.get(i).gn;
					}else {
						//�Ȃɂ����Ȃ�
					}
					System.out.print("2:");
				}else {
					System.out.print("3:");
				}
				
				
				for(int j=0; j<open_list.size(); j++) {
					System.out.print(open_list.get(j).name + ", ");
					
				}
				System.out.println();
			}
			open_list.remove(n);
			
			closed_list.add(n);
			
			
			if(open_list.size()==0) {
				System.out.println("�򕌂Ȃ�");
				break;
			}
			n = open_list.get(0);
			
		}
		
		search_root(n);
		
	}		
	static void sort(Node n){
		int list_size = open_list.size();
		for(int i=0 ; i<list_size ; i++) {
			if(open_list.get(i).gn>n.gn) {
				
				open_list.add(i,n);
				break;
			}else if(i==list_size-1) {
				open_list.add(n);
			}
		}
		
		
		
	}
	
	static void search_root (Node n) {
		System.out.println(n.name + ", g�̒l"+ n.gn);
		if(n.parent!=null) {
		
		search_root(n.parent);
		}
	}
		
		
	
	
	static void init() {
		
		a.list.add(b);
		a.list.add(c);
		a.list.add(d);
		b.list.add(a);
		b.list.add(c);
		c.list.add(a);
		c.list.add(b);
		c.list.add(d);
		c.list.add(f);//
		d.list.add(a);
		d.list.add(c);
		d.list.add(e);
		d.list.add(h);//
		d.list.add(f);
		e.list.add(d);
		e.list.add(h);
		f.list.add(c);
		f.list.add(d);
		f.list.add(g);
		f.list.add(h);
		g.list.add(f);
		g.list.add(i);
		h.list.add(d);
		h.list.add(e);
		h.list.add(f);
		h.list.add(j);
		i.list.add(g);
		i.list.add(j);
		
		a.num_list.add(2);
		a.num_list.add(1);
		a.num_list.add(1);
		b.num_list.add(2);
		b.num_list.add(1);
		c.num_list.add(1);
		c.num_list.add(1);
		c.num_list.add(1);
		c.num_list.add(1);
		d.num_list.add(1);
		d.num_list.add(1);
		d.num_list.add(2);
		d.num_list.add(1);
		d.num_list.add(1);
		e.num_list.add(2);
		e.num_list.add(1);
		f.num_list.add(1);
		f.num_list.add(1);
		f.num_list.add(1);
		f.num_list.add(1);
		g.num_list.add(1);
		g.num_list.add(1);
		h.num_list.add(1);
		h.num_list.add(1);
		h.num_list.add(1);
		h.num_list.add(1);
		i.num_list.add(1);
		i.num_list.add(1);
	}
	
}

class Node{
	String name ;
	ArrayList<Node> list = new ArrayList<>();
	ArrayList<Integer> num_list = new ArrayList<>();
	int gn=0;
	Node parent=null;
	Node(String name){
		this.name = name;
	}
}
