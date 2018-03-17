package linkedlist;

public class linkedlist {
    Node head;

    public void addNode(int data){
        Node n = new Node(data);
        Node nex=head;
        if(head == null){
            head = n;
            return;
        }
        else{
            while(nex.next !=null) {
                nex = nex.next;
            }
        }
        nex.next=n;
    }

    public void printLinkedList(){
        Node temp = head;
        if(head ==null) System.out.println("empty list");
        while(temp !=null){
            System.out.print(temp.data);
            temp= temp.next;
        }
    }


    public void printLinkedList(Node head){
        Node temp = head;
        if(head ==null) System.out.println("empty list");
        while(temp !=null){
            System.out.print(temp.data);
            temp= temp.next;
        }
    }

    public void removeNode(int data){
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            if ((int)temp.data==data && temp.next==null){
                temp.next=null;

            }else if((int) temp.data==data && temp.next!=null){
                head = temp.next;
                temp=null;
            }
            else{
                while((int)temp.next.data != data){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
        }
    }

    public Node reverse(){
        if(head == null || head.next==null){
            return head;
        }
       Node temp=null;
        while(head !=null){
            Node n = head.next;
            head.next = temp;
            temp=head;
            head = n;
        }
        return temp;

    }
    public static void main(String[] args){
        linkedlist l = new linkedlist();
        l.addNode(2);
        l.addNode(4);
        l.addNode(6);
        l.addNode(9);
        l.addNode(7);
      //  l.printLinkedList();
      //  System.out.println("\n After deleting 9");
       //l.removeNode(9);
        l.printLinkedList();
      //  System.out.println("after deleting 2");
      //  l.removeNode(2);
        //l.printLinkedList();
Node n = l.reverse();
        System.out.println("reversed :");
        l.printLinkedList(n);
    }
}
