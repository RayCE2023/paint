/*
 * Author: Raymond Chen
 * 
 * Date: 2017/ 04/ 26
 * 
 * Discription: This is LinkedList class and this class is implements from LinkedListADT 
 * 
 */
package superpaint;
class LinkedList<T> implements LinkedListADT<T>{
  private ListNode<T> front = null;
  private int numberOfNodes = 0;
  
  // Returns true if the linked list has no nodes, or false otherwise.
  @Override
  public boolean isEmpty(){
    return (front == null);
  }

  // Deletes all of the nodes in the linked list.
  // Note: ListNode objects will be automatically garbage collected by JVM.
  @Override
  public void clear() {
    front = null;
    numberOfNodes = 0;
  }
  
  // Returns the number of nodes in the linked list
  @Override
  public int size(){
    return numberOfNodes;
  }
  
  // Adds a node to the front of the linked list.
  @Override
  public void addFirst( T element){
    front = new ListNode<T>( element , front);
    numberOfNodes++;
  }
  
  // Add an element to the end of the linked list
  @SuppressWarnings("unchecked")
  public void addLast( T element ) {
    ListNode<T> n;
    ListNode<T> temp;
    n = front;
    temp = front;
    
    if (front == null){
      addFirst( element);
    }
    else{
      front = new ListNode<T>( element, null);
      for ( int i = numberOfNodes; i > 0; i--){
        for(int a = 1; a < i; a++){
          temp = temp.getNext();
        }
        front = new ListNode<T>( temp.getData(), front);
        temp = n;
      }
       numberOfNodes++;  
    }
  }
  
  // Returns a reference to the data in the first node, or null if the list is empty.
  @Override
  public T peekFirst() {
    if ( isEmpty() ) 
      return null;
    
    return front.getData();
  }

  // Removes a node from the front of the linked list (if there is one).
  // Returns a reference to the data in the first node, or null if the list is empty.
  @Override
  @SuppressWarnings("unchecked")
  public T removeFirst() {
    T tempData;
    
    if ( isEmpty() ) 
      return null;
    
    tempData = front.getData();
    front = front.getNext();
    numberOfNodes--;
    return tempData;
  }
  
  //returns a node that removed from the list and if the list is empty, it will return null.
  @SuppressWarnings("unchecked")
  public T removeLast() {
        T tempData;
        if (isEmpty()){
            return null;
        }
        else{
            ListNode<T> lastNode = front;
            if (lastNode.getNext() == null){
                tempData = lastNode.getData();
                front = null;
                numberOfNodes--;
                return tempData;
            }
            while (lastNode.getNext().getNext() != null){
                lastNode = lastNode.getNext();
            }
            tempData = (T)lastNode.getNext().getData();
            
            lastNode.setNext(null);
            numberOfNodes--;
            return tempData;
        }

    }
    
  // Returns true if the linked list contains a certain element, or false otherwise.
    @Override
    @SuppressWarnings("unchecked")
    public boolean contains( T key ) {
        ListNode<T> searchNode;
        searchNode = front;
        while ( ( searchNode != null ) && ( !key.equals( searchNode.getData() ) ) ) {
            searchNode = searchNode.getNext();
        }
        return ( searchNode != null );
    }
    
    // Return String representation of the linked list.
    @Override
    @SuppressWarnings("unchecked")
    public String toString() {
        ListNode<T> node;
        String linkedList = "FRONT ==> ";
        
        node = front;
        while (node != null) {
            linkedList += "[ " + node.getData() + " ] ==> ";
            node = node.getNext();
        }
        
        return linkedList + "NULL";
    }
  
}
