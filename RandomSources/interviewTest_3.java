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

public class interviewTest_3 {

  // public static void printFlatList(String[] args) {

  // }
  
  static class Node {
    int value;
    Node next;

    Node(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    // LinkedListExample list = new LinkedListExample();
    LinkedList<Node> list = new LinkedList<Node>();
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
    // System.out.println(printFlatList(arr));
  }
}
