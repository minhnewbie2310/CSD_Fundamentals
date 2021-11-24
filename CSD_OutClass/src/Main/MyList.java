package Main;
public class MyList {

    Node head, tail;

    // (1)
    MyList() {
        head = tail = null;
    }

    // (2)
    boolean isEmpty() {
        return (head == null);
    }

    // (3)
    void clear() {
        head = tail = null;
    }

    // (4) //Them 1 phan tu vao cuoi linkedlist
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    // (5)
    void visit(Node p) {
        if (p != null) {
            System.out.println(p.info);
        }
    }

    // (6) //Duyet linkedlist
    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    // (7) optional
    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (8) //tim node co ten ung voi ten truyen vao
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // (9) //Them 1 phan tu vao dau linkedlist
    void addFirst(Person x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    // (10)
    void insertAfter(Node q, Person x) {
        if (q == null) {
            return;
        }
        Node q1 = q.next;
        Node p = new Node(x, q1);
        q.next = p;
        if (tail == q) {
            tail = p;
        }
    }

    // (11)
    void insertBefore(Node q, Person x) {
        if (q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        //tim node f truoc node q
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; //q is not in the list
        }
        insertAfter(f, x);
    }

    //Xoa node dau tien trong list
    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    // (12) //xoa node q trong list
    void remove(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;//q is not in the list
        }
        f.next = q.next;
        if (f.next == null) {//xoa node tail
            tail = f;
        }

    }

    // (13) Xoa node ung voi ten truyen vao
    void remove(String xName) {
        remove(searchByName(xName));
    }

    // (14)
    void remove(int xAge) {
    }

    void removeAll(String xName) {
        Node p;
        while ((p = searchByName(xName)) != null) {
            remove(p);
        }
    }

    // (15)
    void removeAll(int xAge) {
    }

    // (16) //tra ve node ung voi vi tri k truyen vao
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return p;
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    // (17)
    void removePos(int k) {
        remove(pos(k));
    }

    // (18)
    void sortByName() {
        Node pi, pj;
        Person tmp;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.name.compareTo(pj.info.name) > 0) {
                    tmp = pi.info;
                    pi.info = pj.info;
                    pj.info = tmp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (19)
    void sortByAge() {
        Node pi, pj;
        Person tmp;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.age > pj.info.age) {
                    tmp = pi.info;
                    pi.info = pj.info;
                    pj.info = tmp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // (20)//tra ve kich thuoc cua linkedlist
    int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return (count);
    }

    // (21) //chuyen list sang mang
    Person[] toArray() {
        int n, i;
        n = size();
        Person[] persons = new Person[n];
        Node p = head;
        i = 0;
        while (p != null) {
            persons[i++] = new Person(p.info.name, p.info.age);
            p = p.next;
        }
        return (persons);
    }

    // (22) //dao linkedList
    void reverse() {
        MyList t = new MyList();
        Node p = head;
        while (p != null) {
            t.addFirst(p.info);
        }
        head = t.head;
        tail = t.tail;
    }

    // (23) 
    Node findMaxAge() {
        return (null);
    }

    // (24) 
    Node findMinAge() {
        return (null);
    }

    // (24) 
    void setData(Node p, Person x) {
        if (p != null) {
            p.info = x;
        }
    }

    // (26) 
    void sortByAge(int k, int h) {
    }

    // (27) 
    void reverse(int k, int h) // reverse from k to h 
    {
    }
}
