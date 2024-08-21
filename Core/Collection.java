
What is Java Collection Framework?
    A java collection framework is a collection of interfaces and classes which are used to store and
    process data efficiently, as a Collection is something which is used to store Data objects.

    This framework was introduced in Java version 1.2.
    -> Reduced the development effort.
    -> Code quality is enhanced.

What are the basic interfaces of collection framework?

    1. Collection
    2. List
    3. Set
    4. Queue
    5. Map

Why Map Interface does not extend Collection interface?
    The Map is way different than collection. In Map there are no elements, it has key-value pairs.
    👉🏻 It does not fit into the Group of elements Paradigm.

    However there are many methods to retrieve keys and values as collection.

What is the difference between Collection and Collections?

Why Collection Interface does not extend Serializable and Cloneable interfaces?
    'There is no need to do it!'
    Collection is not supposed to do what Cloneable and Serializable interfaces do.

    What they do?
    They are just the marker interfaces which are actually empty interfaces.

    👉🏻 If Collection Interface implements these interfaces then it will mandate cloning and serialization
    in all implementation, which is less flexible and more restrictive.

When we had Array, Why do we need collection?
    We know Array is a group of primitives.. which holds homogeneous data.
    It has also some limitations like, arrays are always fixed in size.
    So to overcome these problems, collection were introduced.
    Collection, which can also be called a container, is a group of individual objects.

    How can it solve the problems that we had in array?

    Collections are grow-able in Nature,
    that means we aren't bound to declare size of any collection at declaration as we are with arrays.
    Size of collections can be increased or decreased on the base of our programming requirement.
    You can add or remove any number of elements in collection.

    hence collections solve the first limitation.

    And next,
    we only can have homogeneous type of data elements in array,
    But Collections can have any kind of data element. They can be homogeneous or heterogeneous.

when we should use arrays and when collection?
    Array are recommended to use if we know the size in advance..
    because Performance-wise Arrays are better to use than Collections.

    From Memory point of view, we should not use 'Arrays'..
    Suppose we take an array of 100 size. And if we only have 10 elements in it, so,
    here the rest of the memory blocks get wasted. Thats why arrays are not recommended to use in memory point of view.
    On the other hand, Collections are grow-able or resizable in nature, and it uses memory as per required only.

What is the difference between Array and ArrayList?
    The very first difference between Array and ArrayList is,
    Array can contain primitive or Objects whereas ArrayList can only contain Objects.
    next is
    Arrays are fixed in size whereas ArrayList size is dynamic.
    And, ArrayList accepts duplicate objects unlike arrays..
    Array does not provide a lot of features like ArrayList, such as add(), addAll(), removeAll() etc..

    So ArrayList is the obvious choice when we work on list.. But if the size of list is fixed and
        if we are using the list of primitives then we should use Arrays.. Although collection use auto boxing to reduce
        the coding effort but still it makes them slow.. so would use array with primitives.
    And if are working on multidimensional situation, then also using array [][] is way more easy than List<List<>>..

How LinkedList is different from ArrayList?
    ArrayList and LinkedList both implement the List interface but there are some differences between them..

    ArrayList is an indexed based data structure.. The underlying data structure for ArrayList is a resizable or growable Array.

    And LinkedList is a data structure which stores data and its address as list of nodes.. here,
        every node is linked to its previous and next node using pointers..
        That is, the address part of the element points to the next element of the linked list.
        so see the address that the first node is having.. is actually the address of the next node.

    This is how we create ArrayList, and linkedLists

    ArrayList<String> al = new ArrayList<String>();
    //and to add elements.. these are the methods.. (explain the suggestions)
    al.add("John");
    al.add("Rohn");

    LinkedList<String> lList = new LinkedList<String>();
    lList.add("");

    Since ArrayList is index based data structure, it provides random access to its elements with the performance of O(1)..
        that is,we can access any element by the index.. Linked list also allows to get any element by index,
        but internally it traverse the list from start to read at the index node, then return the element.
        So the performance is O(n) which is slower than of arrayList. Therefore the ArrayList is recommended to use retrieving data..

    Next thing is, Insertion and removal of any element is faster in LinkedList compared to ArrayList.
        Because one insertion or deletion in middle requires n number of shifts.. So there is no concept of resizing array when element is added in middle..

    and in linkedList it requires only one change in the address pointer of the particular node to add or remove any element.

    Next is,
    LinkedList consumes more memory than ArrayList because every node in LinkedList stores reference of previous and next elements..'

What are the different ways to iterate over a list?
    To access or to get elements from collection there are many ways present in java.
    1. Loops (classic for loop)
    2. Cursors
        In java these are the cursors available for collections:
            1. Iterator
            2. ListIterator
            3. Enumeration

What is the difference between Iterator and ListIterator and Enumeration?

What are the legacy implementations?
    Vector is a legacy class.
    Legacy class: The classes that were already there before introducing collection framework.

    Sub Class of Vector -> Stack, is also a legacy class.

    Vector is implemented on a growable or a resizable array.
        -> It is an ordered collection
        -> allows duplicates.

    Vector v = new Vector();

    Stack implements the stack data structure. It is based on the principle of Last In First Out.
        👉🏻 element which is inserted in last, will be the first one to come out.

    Stack s = new Stack();

      -> to insert any object : push()
      -> to remove the top element : pop()

What are the similarities and difference between ArrayList and Vector?

Which collection classes provide random access of its elements?
    These are the collection classes which provide random access:
        ArrayList, Vector, Stack, HashMap, TreeMap, Hash-table.

What are Stack and Queue? How they are different?
    Stack and Queue are used to store data before processing them.

    Queue represents an ordered list of objects which is limited to insert elements
    at the end of the list and removing from the start..

    This is how we create a queue,

    Queue<Integer> q = new LinkedList<>();

    being an interface it needs the concrete classes to create objects,
    PriorityQueue and LinkedList are most common to use.

    And to add element,
    q.add(10);
    q.add(20);

    sysout(q);

    and the remove method will remove the head that is the first element

    int a = q.remove();		//return the removed element
    sysout("element removed- "+a)

    sysout(q);

    So Queue allows retrieval of element in First In First Out order. and it is different from stack as
        Stack allows elements to be retrieved in Last In First out order.

    Stack<Integer> st = new Stack<>();
    st.push(10);
    st.push(20);

    To pop,
    st.pop();

    sysout(st);

    So thats the difference between Stack and queue.. Stack is a class and queue is an interface.

How can we sort Collections?
    There are some implementations of set and map which are used to store elements in a sorting order.
    -> SortedMap, SortedSet etc. - can be used to get a sorted collection(Map or Set).

    To sort List implementations, the Collections provides method sort().

    Collections.sort(): sorts list implementation passed to it.

    -> It does not return anything just sorts the collection.

How to make a collection read only?
    We can create a read only collection by using unmodifiableCollection method of Collections class.

    Collections.unmodifiableCollection(Collection c)

    -> if any operation occurs it will throw UnsupportedOperationException.

How can we make a collection thread-safe?
    There is a method in Collections class ->
    synchronizedCollection(Collection c) : used to get a synchronized or thread-safe collection.

What is the difference between Set and List?
    Both Set and List are used to store objects and provides convenient way to insert,
    remove and retrieve elements and also provides support for iteration.

    Fundamental differences between List and Set:
     1. Allowing Duplicate Elements
     2. Order

When should we use List and when to use Set??
    👉🏻 If we need to maintain insertion order and we can have duplicates too then we use List.
    👉🏻 If we want a collection of unique objects then we should use Set.

How does HashSet is implemented? How does it use Hashing?

What are Comparable and Comparator interface? When to use what?
    Comparable provides a single sorting sequence. In other words, we can sort the collection on the basis of a single element such as id, name, and price.
    The Comparator provides multiple sorting sequences. In other words,
        we can sort the collection on the basis of multiple elements such as id, name, and price etc.

    Comparable affects the original class, i.e., the actual class is modified.
    Comparator doesn't affect the original class, i.e., the actual class is not modified.

    Comparable provides compareTo() method to sort elements.
    Comparator provides compare() method to sort elements.

    Comparable is present in java.lang package.
    Comparator is present in java.util package.

    We can sort the list elements of Comparable type by Collections.sort(List) method.
    We can sort the list elements of Comparator type by Collections.sort(List, Comparator) method.

Whats difference between TreeSet and LinkedHashSet and HashSet?
    These are the implementations of Set.

    Starting with TreeSet, the main feature of TreeSet is Sorting.
    Its the implementation class of sortedSet.
    So in TreeSet the insertion of elements is done on some sorting order.
    like we want to store all the Employee's object according to their EmployeeIds then we should go for SortedSet or TreeSet.
    Also in treeSet, we cannot put heterogeneous elements in it.
    Its about sorting as we cannot sort different type of objects so it is restricted to insert diff data types in treeSet.

    SortedSet<Integer> t = new TreeSet<>();

    It will creates an TreeSet object in which elements to be inserted in Default natural sorting order.
    Note that, If we are depending on the default natural sorting order, then our elemtns/object should be...
    homogeneous and comparable, otherwise we will get classCastException.

    So we can add integer only.
    t.add(10);
    t.add(5);
    sysout(t);

    This will add both elements in ascending order by default.

    And next is LinkedHashSet.. it was introduced in 1.4 version. It is the sub class of Hashset (no insertion order) where insertion order is preserved.
    And that's the main difference between HashSet and LinkedHashSet.

    We create linkedHashSet like,
    LinkedHashSet lhs = new LinkedHashSet();

    So all of the three, TreeSet, LinkedHashSet and HashSet doesn't allow to store duplicates.
    And none of these are thread-safe..
    But HashSet is the Fastest among them.
    LinkedHashSet comes second or can be similar to HashSet but
    TreeSet is slower because it performs sorting for each insertion.

    Next difference between these, is ordering.
    HashSet doesn't maintain any order while LinkedHashSet maintains insertion order
    and treeSet maintains sorting order of elements.

    And talking about internal implementations,
    HashSet is backed by HashMap..
    whereas LinkedHashSet is implemented using HashSet and LinkedList.
    And TreeSet, it is backed up by navigableMap and it internally uses TreeMap.

    Next difference is about way of comparing things,
    like HashSet and LinkedHashSet uses equals() for comparison
    and TreeSet uses compareTo() method for maintaining ordering.
    This was all about differences between them.

Can we add a null element to TreeSet and HashSet?
    We can add a null element in HashSet but not in treeSet.

    👉🏻 TreeSet uses compareTo() method to compare objects with each other, if any element will be null
    by any chance, it will throw NullPointerException.

What is difference between poll() and remove() methods of Queue?
    Both of these methods are used to remove element and returns the head of the queue. The difference is,

    -> if the queue is empty and we call the remove() method, then it will throw exception,
    but if we call poll() method, it will return null.

What is the difference between remove() method of Collection and remove() method of Iterator?
    Collection.remove() is used for removing object from collection, while not iterating.

    -> When we use this remove() method to remove element at the time of iteration then it may throw
    ConcurrentModificationException.

    -> Iterator.remove() is advised to use for remove element while iterating.

How HashMap works in Java 8?
    inner class has four fields. key, value, next and hash.

    key : It stores the key of an element and its final.
    value : It holds the value of an element.
    next : It holds the pointer to next key-value pair. This attribute makes the key-value pairs stored as a linked list.
    hash : It holds the hashcode of the key.

    When the number of key-value pairs in a "HashMap" exceeds a certain threshold, determined by the load factor,
        the "HashMap" needs to resize its internal array and rehash all the key-value pairs. This process is called "rehashing” or "resizing.

    The purpose of resizing is to ensure that the load factor remains below a certain threshold to prevent excessive collisions,
        which can lead to degraded performance. By increasing the capacity (number of buckets) of the "HashMap" and redistributing the key-value pairs,
        the load factor is reduced, and the "HashMap" can maintain its efficiency.

    Here's how the resizing and rehashing process works step by step:
    Load Factor Threshold Exceeded
        As you keep adding elements, the number of key-value pairs increases.
        When the number of elements exceeds a certain threshold, determined by the load factor,
        the HashMap decides to resize its internal array to maintain efficiency. The default load factor is 0.75,
        which means that resizing occurs when the number of elements exceeds 75% of the current capacity.

    Calculate New Capacity
        When the load factor threshold is exceeded, the HashMap calculates the new capacity by doubling the current capacity.
        In this example, let's say the current capacity is 16, so the new capacity will be 32.

    Create a New Array
        The HashMap creates a new array with the new capacity (32 buckets). All the buckets in the new array are initially empty.

    Rehashing and Moving Elements
        For each key-value pair in the old array, the HashMap recalculates the hash code of the key using the new capacity (32 buckets)
            and finds the corresponding bucket in the new array.
        The key-value pair is then moved from the old bucket to the new bucket in the resized array.
        During this process, the hash codes of the keys are rehashed based on the new capacity,
            which may result in different bucket assignments compared to the old array.

    Linked Lists to Balanced Trees (Optional)
        In modern versions of Java (Java 8 onwards), if entries in a single bucket reach a threshold (TREEIFY_THRESHOLD, default value 8)
            then Map converts the bucket's internal structure from the linked list to a RedBlackTree.
            All Entry instances are converted to TreeNode instances.
        To improve retrieval performance, the HashMap converts the linked list into a balanced tree (Red-Black tree) during rehashing,
            ensuring more efficient retrieval (O(log n)) instead of linear search (O(n)).
        The conversion from a linked list to a balanced tree happens during rehashing and is done for any buckets with a size exceeding
            the threshold (8 or more entries).
        Note that when nodes in a bucket reduce less than UNTREEIFY_THRESHOLD the Tree again converts to LinkedList.
            This helps balance performance with memory usage because TreeNodes takes more memory than Map.Entry instances.
            So Map uses Tree only when there is a considerable performance gain in exchange for memory wastage.

    What are Red Black Trees and Why they are used?
        Red-Black trees are self-balancing binary search trees. Red-black tree makes sure that the length of the binary search
        trees is always log(n) despite new addition or removal of nodes.

    The main advantage of using Red-black tree structure is in a case where many entries are in the same bucket.
    For search operation, in java 7,it will take O(n) with a linked list. While in java 8 , the same search operation in a tree will cost O(log(n)).
        Drawbacks : Tree really takes more space than the linked list.
        By Inheritance, bucket can contain both Node(Entry object) and TreeNode(Red-black tree).
        1. If for a given bucket , there are more than 8 Nodes, the linked list is converted into a red-black tree.
            This is represented by the following code in HashMap class :
                static final int TREEIFY_THRESHOLD = 8;
        2. If for a given bucket , there are less than 6 nodes, then the tree can be converted into a linkedlist.
                static final int UNTREEIFY_THRESHOLD = 6;

Whats the difference between HashMap and HashTable?
    HashMap and HashTable are both key-value storage classes in Java.
    HashMap is non-synchronized, making it faster for single-threaded tasks, while HashTable is inherently synchronized, providing thread safety.
    HashTable doesn't allow any null keys or values, but HashMap lets you have one null key and several null values.

Can we use a Custom object as a key in HashMap? If yes then How?
    Yes! we may create custom object key for HashMap.
    -> for that we need to override the equals() and hashcode() method to the Class which we want to use as key.

Why it is suggetsed to have immutable objects as keys in hashMap?
  //why string is popular hasmap key in java?
    -> if we want to use custom object as key, we need to ensure that the hashcode() of the key of hashMap
    does not change. If it happens then it is impossible to get object value from that key.

What is the contract of equals() and hashCode() method?
    👉🏻 If two objects are equal, then they must have the same hashcode.
    👉🏻 if two objects have the same hash code, then they may or may not be equal.

    //Equal objects must produce same hashcode
	   //a.equals(b) -> true    then  a.hashCode() = b.hashCode()

  	//unequal objects need not produce same hashcode
  	//a.equals(b) -> false    then  a.hashCode() = b.hashCode() -> true
  	//a.equals(b) -> false    then  a.hashCode() = b.hashCode() -> false

What is the NavigableMap?

What is the difference between HashMap and HashSet in java?
    👉🏻 HashMap is collection of key-value pairs whereas HashSet is an un-ordered collection of unique elements!

What are IdentityHashMap and WeakHashMap? How they are different?
    IdentityHashMap: The IdentityHashMap implements the Map interface.
        It follows reference-equality in place of object-equality when comparing keys (and values).
        This class is used when the user requires the objects to be compared via reference.
        It is not synchronized and must be synchronized externally.
        The iterators in this class are fail-fast, throw ConcurrentModificationException in an attempt to modify while iterating.
    WeakHashMap: WeakHashMap is the implementation of the Map interface that stores only weak keys.
        In WeakHashMap, we can store only weak references of its key that allows a key-value pairs to be garbage collected
        when its key is no longer in ordinary use. WeakHashMap is the HashTable based implementation, but it is not synchronized.
        It allows you to store both null key and null values.
    EnumMap: EnumMap is a specialized implementation of the Map interface for enumeration types.
        It extends AbstractMap and implements the Map interface in Java. Few important features of EnumMap are as follows:
        EnumMap class is a member of the Java Collections Framework and it is not synchronized.
        EnumMap is an ordered collection, and they are maintained in the natural order of their keys
            (the natural order of keys means the order on which enum constant are declared inside enum type)
        EnumMap is much faster than HashMap.
        All keys of each EnumMap instance must be keys of a same enum type.
        EnumMap doesn't allow to insert null key if we try to insert the null key, it will throw NullPointerException.
        EnumMap is internally represented as arrays therefore it gives the better performance.


        PROPERTIES	                         IdentityHashMap	               WeakHashMap	                      EnumMap
        References	                    Stores strong key reference. 	Stores weak key reference.	    Stores strong key reference.
        Search and get the values	    Uses equality operator (==)	    It uses equals() method	        It also uses equals() method
                                        to search and get the values.    for that purpose.              for that purpose.
        Keys    	                    Allows to store any type of 	Allows to store any type	    Allows to store only enum type
                                        keys.                           of keys.                        keys.
        Underlined data structure	    Uses array as an underlined     Uses HashTable as an    	    It uses the array as an
                                        data structure.                 underlined data structure.      underlined data structure.
        Iterator	                    Iterator used is Fail-fast.	    Iterator used is Fail-fast.	    Iterator used is weakly consistent.
        Null Values	                    Allows to store null values.	Allows to store null values.	Doesn't allow to store null values

When to use HashMap and when to use TreeMap?
    👉🏻 HashMap is the best implementation of Map for inserting, deleting, and locating elements.

    👉🏻 TreeMap is the better alternative if we need to traverse the keys in a sorted order.

    -> HashMap is faster than TreeMap; for sorted key traversal, it is faster way to add elements to a
    HashMap, and then convert the map to a TreeMap.


//Concurrent Collections
//java.util.concurrent v5

What is iterator's fail-fast property?
    While iterating over any collection, we cannot perform any modification on elements.
    Whenever we access the next element in collection, Iterator's fail fast property checks for any
    modification in the structure of that collection.'
    -> If any modifications found, it throws RuntimeException.

    👉🏻 Almost all the implementations of the iterator, are fail-fast by design.
      ** Except the concurrent collection classes.

What are Concurrent Collection classes? When does ConcurrentModificationException occur?
    The Concurrent Package [java.util.concurrent] which introduced in java 1.5,
    contains thread-safe collection classes called Concurrent Collection class:
    -> that allows collections to be modified while iterating.

    By design, iterator implementation are fail fast and throw the ConcurrentModificationException
    whenever we modify element while iterating.

    -> Iterator implementations in Concurrent Package allows us to do the modifications at runtime too.

    1. CopyOnWriteArrayList 2. ConcurrentHashMap 3. CopyOnWriteArraySet.

What is the difference between fail-fast and fail safe?
    Fail-fast and Fail-safe are the iterators or collections in Java.
    Java SE specification doesn't use the Fail-safe term.
    We use the Fail-safe to segregate between the Non-Fail-fast and Fail-fast iterators.

    The Fail-Fast system terminates the operation as-fast-as-possible that are exposing failures and stop the entire operation.
    Whereas, Fail-Safe system doesn't terminate the operation that are exposing failures.
        The Fail-safe system tries to avoid raising Failures as much as possible.

      Key	                                Fail-Fast               	                    Fail-Safe
    Exception	    If we add, remove or update the collection elements      The fail-safe iterator tries to avoid raising
                    at the time when a thread is iterating them, the Fail    failure and doesn't throw an exception.
                    fast throw concurrent modification exception.
    Performance	    It doesn't require more memory while iterating over      It requires more memory due to working with copy collection.
    and Memory      it because it iterates over the original collection,     All the modifications are done in the copy collection,
                    and all the modifications are done in the original       not in the original one.
                    collection.
    Modifications	We cannot make changes in the collection while the       We can make changes in the collection while the iterator iterates over it.
                    iterator iterates over it.
    Examples	    Iterator on ArrayList and Iterator on HashMap.	         Iterator on CopyOnWriteArrayList and Iterator on ConcurrentHashMap.

What is the difference between Synchronized Collection and concurrent collection?
    Synchronized collections classes, like Hashtable and Vector provides thread-safe implementation of Map
    and List.

    There are several factors which make them less suitable for use in highly concurrent applications.

    Performance: The synchronized collections are unsuitable because of their 'wide-locking mechanism'.
    They acquire lock on complete object whereas concurrent classes locks only a part.

When do we use ConcurrentHashMap in Java?
    The ConcurrentHashMap class is introduced in JDK 1.5 belongs to java.util.concurrent package, which implements ConcurrentMap
    as well as to Serializable interface also. ConcurrentHashMap is an enhancement of HashMap as we know that while dealing with
    Threads in our application HashMap is not a good choice because performance-wise HashMap is not up to the mark.

    ConcurrentHashMap is a thread-safe implementation of the Map interface in Java, which means multiple threads can access it
    simultaneously without any synchronization issues. It's part of the java.util.concurrent package and was introduced in Java 5
    as a scalable alternative to the traditional HashMap class.

    One of the key features of the ConcurrentHashMap is that it provides fine-grained locking, meaning that it locks only the
    portion of the map being modified, rather than the entire map. This makes it highly scalable and efficient for concurrent
    operations. Additionally, the ConcurrentHashMap provides various methods for atomic operations such as putIfAbsent(), replace(), and remove().

    Key points of ConcurrentHashMap:
        The underlined data structure for ConcurrentHashMap is Hashtable.
        ConcurrentHashMap class is thread-safe i.e. multiple threads can operate on a single object without any complications.
        At a time any number of threads are applicable for a read operation without locking the ConcurrentHashMap object which is not there in HashMap.
        In ConcurrentHashMap, the Object is divided into a number of segments according to the concurrency level.
        The default concurrency-level of ConcurrentHashMap is 16.
        In ConcurrentHashMap, at a time any number of threads can perform retrieval operation but for updated in the object,
            the thread must lock the particular segment in which the thread wants to operate.
            This type of locking mechanism is known as Segment locking or bucket locking. Hence at a time, 16 update operations can be performed by threads.
        Inserting null objects is not possible in ConcurrentHashMap as a key or value.

Can we replace HashTable with ConcurrentHashMap?
    Yes, we can replace the HashTable with ConcurrentHashMap.
    -> As the performance of ConcurrentHashMap is better than HashTable.

    We need to be careful with code which relies on locking behavior of Hashtable.
    Since Hashtable locks whole Map instead of a portion of Map, compound operations like
    if(Hashtable.get(key) == null) put(key, value) works in Hashtable but not in concurrentHashMap.

What is CopyOnWriteArrayList? How it is different than ArrayList?
                                    ArrayList	                CopyOnWriteArrayList
        Synchronized	    It is not synchronized.             It is synchronized.
        Thread Safe	        It is not thread safe.              It is thread safe.
        Iterator type	    Its iterator is fail-fast           It is fail-safe and it will never throw
                            and it throws                       ConcurrentModificationException during iteration.
                            ConcurrentModificationException     The reason behind this is that CopyOnWriteArrayList
                            if concurrent modification          creates a new arraylist every time it is modified.
                            happens during iteration.
        Remove Opearation	Its iterator supports removal of    CopyOnWriteArrayList.remove() method throws exception
                            element during iteration.	        if elements are tried to be removed during iteration.
        Performance     	It is faster.                   	It is slower than ArrayList.
        Since Java Version	    1.2                             	1.5

What is BlockingQueue?
    The BlockingQueue interface in Java is added in Java 1.5 along with various other concurrent Utility classes
    like ConcurrentHashMap, Counting Semaphore, CopyOnWriteArrrayList, etc. BlockingQueue interface supports flow
    control (in addition to queue) by introducing blocking if either BlockingQueue is full or empty. A thread trying
    to enqueue an element in a full queue is blocked until some other thread makes space in the queue, either by
    dequeuing one or more elements or clearing the queue completely. Similarly, it blocks a thread trying to delete
    from an empty queue until some other threads insert an item. BlockingQueue does not accept a null value.
    If we try to enqueue the null item, then it throws NullPointerException.

    Java provides several BlockingQueue implementations such as LinkedBlockingQueue, ArrayBlockingQueue, PriorityBlockingQueue,
    SynchronousQueue, etc. Java BlockingQueue interface implementations are thread-safe. All methods of BlockingQueue are
    atomic in nature and use internal locks or other forms of concurrency control. Java 5 comes with BlockingQueue
    implementations in the java.util.concurrent package.
