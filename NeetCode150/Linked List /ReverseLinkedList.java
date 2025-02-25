/**
 * Reverse Linked List
 * Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
 *
 * Example 1:
 *
 * Input: head = [0,1,2,3]
 *
 * Output: [3,2,1,0]
 * Example 2:
 *
 * Input: head = []
 *
 * Output: []
 * Constraints:
 *
 * 0 <= The length of the list <= 1000.
 * -1000 <= Node.val <= 1000
 */

class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        // Inicializar el nodo anterior como null (este se convertirá en la nueva cola de la lista invertida).
        ListNode prev = null;

        // Inicializar el nodo actual como la cabeza de la lista original.
        ListNode curr = head;

        // Iterar a través de la lista hasta que el nodo actual sea null.
        while (curr != null) {
            // Paso 1: Almacenar el siguiente nodo.
            ListNode next = curr.next;  // Guardar el siguiente nodo antes de invertir el enlace.

            // Paso 2: Invertir el enlace.
            curr.next = prev;           // Hacer que el nodo actual apunte al nodo anterior.

            // Paso 3: Mover los punteros hacia adelante.
            prev = curr;                // Mover 'prev' al nodo actual.
            curr = next;                // Mover 'curr' al siguiente nodo.
        }

        // 'prev' ahora apunta a la nueva cabeza de la lista invertida.
        return prev;
    }
}