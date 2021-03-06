package question;


/**
 * Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author wangyang
 * @since 2019/1/31
 */

public class Leetcode21E {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (l1 != null || l2 != null){
            if (l2 == null || (l1 != null &&l1.val <= l2.val)){
                node.next = l1;
                node = l1;
                l1=l1.next;
            }else{
                node.next = l2;
                node = l2;
                l2=l2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        new Leetcode21E().mergeTwoLists(new ListNode(1,2,4),new ListNode(1,3,4));
    }
}
