package question;

/**
 * Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author wangyang
 * @since 2019/1/30
 */



public class Leetcode19M {
    //数组保存
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode[] temp = new ListNode[n+1];
        int i = 0;
        temp[i] = head;
        ListNode node = head;
        while (node.next != null){
            node = node.next;
            i++;
            if (i > n){
                i = i - n -1;
            }
            temp[i]  = node;
        }
        if (temp[n] == null) return head.next;
        ListNode n1 = i == n ? temp[0] : temp[i+1];
        n1.next = n1.next.next;
        return head;
    }



    //双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode temp = head;
        int i = 0;
        while (node.next != null){
            i++;
            if (i > n){
                temp = temp.next;
            }
            node = node.next;
        }
        if (i + 1 <= n) return head.next;
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,2);
        System.out.println(new Leetcode19M().removeNthFromEnd(node,1));
    }
}
