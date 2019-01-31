package question;

/**
 * Description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author wangyang
 * @since 2018/11/12
 */

public class Leetcode2M {

    /*
     每位依次相加，用一个标志位记录进位情况，需要注意几种特殊情况，A比B长，AB的位数相同但最后还产生了一位最高位进位
     O(n)
     */
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int flag = sum / 10;
        ListNode headNode = new ListNode(sum % 10);
        ListNode thisNode = headNode;
        ListNode l1next = l1.next;
        ListNode l2next = l2.next;

        while (l1next != null || l2next != null || flag != 0) {

            sum = (l1next == null ? 0 : l1next.val) + (l2next == null ? 0 : l2next.val) + flag;
            flag = sum / 10;
            ListNode nextNode = new ListNode(sum % 10);
            thisNode.next = nextNode;
            thisNode = nextNode;
            l1next = l1next == null ? null : l1next.next;
            l2next = l2next == null ? null : l2next.next;
        }
        return headNode;
    }

    public static void main(String[] args) {
        Leetcode2M l2 =new Leetcode2M();
        ListNode first = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode second = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(l2.addTwoNumbers(first,second));

    }
}
