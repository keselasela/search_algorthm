package test;


	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	abstract public class Algorizm {
		
		static ArrayList<Node> open_list = new ArrayList<>();
		static ArrayList<Node> closed_list = new ArrayList<>();
		
		static Node a = new Node("˜a‰ÌR");
		static Node b = new Node("_ŒË");
		static Node c = new Node("‘åã");
		static Node d = new Node("“Ş—Ç");
		static Node e = new Node("’Ã");
		static Node f = new Node("‹“s");
		static Node g = new Node("•Ÿˆä");
		static Node h = new Node("–¼ŒÃ‰®");
		static Node i = new Node("‹à‘ò");
		static Node j = new Node("Šò•Œ");
		
		
		public static void main(String[] args) {
			System.out.println("[‚³");
			Node n;
			init();
			open_list.add(a);
			n = open_list.get(0);
			
			
			while(true) {
				System.out.println(n.name);
				
				if(n.name == "Šò•Œ") {
					System.out.println("Šò•Œ”­Œ©");
					break;
				}
				open_list.remove(n);
				
				for(int i=n.list.size()-1; 0<=i; i--) { 
					if(!(open_list.contains(n.list.get(i)) || closed_list.contains(n.list.get(i)))) {
						n.list.get(i).parent = n;
						open_list.add(0,n.list.get(i));
					}
					closed_list.add(n);
				}
				
				
				if(open_list.size()==0) {
					System.out.println("Šò•Œ‚È‚µ");
					break;
				}
				n = open_list.get(0);
				
			}
			System.out.println("-------------------------------------------------");
			search_root(n);
			
		}		
		
		static void search_root (Node n) {
			System.out.println(n.name);
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
			d.list.add(a);
			d.list.add(c);
			d.list.add(e);
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
		}
	}

	



