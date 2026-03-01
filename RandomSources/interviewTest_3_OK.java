package RandomSources;

import java.util.*;

// Вывести значения односвязного списка в обратном порядке. Использовать console.log для вывода.
// const someList = {
//   value: 1,
//   next: {
//     value: 2,
//     next: {
//       value: 3,
//       next: {
//         value: 4,
//         next: null,
//       },
//     },
//   },
// };
// 4, 3, 2, 1
// ! done

public class interviewTest_3_OK {

  public void printReverseList() {
    Node current = head;
    ArrayList<Integer> result = new ArrayList<Integer>();
    // ArrayList<Integer> resultRevers = new ArrayList<Integer>();
    while (current != null) {
      result.add(current.value);
      current = current.next;
    }

    for (int i = (result.size() - 1); i >= 0; i--){
      System.out.print(result.get(i) + ", ");
    }

    System.out.println();
  }

  Node head;
  
  static class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
      this.next = null;
    }
  }
  
  public static void main(String[] args) {
    interviewTest_3_OK list = new interviewTest_3_OK();
    // Create nodes
    list.head = new Node(1);
    Node second = new Node(2);
    Node third = new Node(3);
    Node fourth = new Node(4);

    // Link them: 1 → 2 → 3 → 4 → null
    list.head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = null;

    list.printReverseList();
    // System.out.println(printFlatList(arr));
  }
}
